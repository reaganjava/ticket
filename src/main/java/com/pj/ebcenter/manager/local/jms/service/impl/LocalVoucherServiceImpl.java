package com.pj.ebcenter.manager.local.jms.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mopon.entity.sys.MessageEntity;
import com.mopon.service.impl.sys.BaseServiceImpl;
import com.mopon.util.JSONTools;
import com.pj.ebcenter.manager.hq.entity.OutlineProduct;
import com.pj.ebcenter.manager.local.dao.ILocalTerminalRecordDao;
import com.pj.ebcenter.manager.local.dao.ILocalVoucherDao;
import com.pj.ebcenter.manager.local.dao.IMqCacheDao;
import com.pj.ebcenter.manager.local.jms.service.ILocalVoucherService;
import com.pj.ebcenter.manager.local.jms.service.ILocalVoucherTransactionService;
import com.pj.ebcenter.manager.local.vo.LocalTerminalRecordVo;
import com.pj.ebcenter.manager.local.vo.LocalVoucherMerchantVo;
import com.pj.ebcenter.manager.local.vo.LocalVoucherVo;
import com.pj.ebcenter.manager.local.vo.MqCache;
import com.pj.ebcenter.ticket.util.DateUtils;

@Service("localVoucherService")
public class LocalVoucherServiceImpl extends BaseServiceImpl implements ILocalVoucherService {

	protected Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private ILocalVoucherDao localVoucherDao;

	@Autowired
	private IMqCacheDao mqCacheDao;

	@Autowired
	private ILocalTerminalRecordDao localTerminalRecordDao;

	@Autowired
	private ILocalVoucherTransactionService localVoucherTransactionService;

	@Override
	public void localSynCloudToLocal(List<Map<String, Object>> o) {
		Map<String, Object> obj = o.get(0);
		List<LocalVoucherVo> vouchers = (List<LocalVoucherVo>) obj.get("vouchers");
		List<LocalVoucherMerchantVo> voucherMerchants = (List<LocalVoucherMerchantVo>) obj.get("voucherMerchants");
		Map<String,List<LocalVoucherMerchantVo>> merchantMap = new HashMap<>();
		if(voucherMerchants!=null&&voucherMerchants.size()>0){
			for(LocalVoucherMerchantVo item:voucherMerchants){
				if(merchantMap.containsKey(item.getVoucherId())){
					merchantMap.get(item.getVoucherId()).add(item);
				}else{
					List<LocalVoucherMerchantVo> marray= new ArrayList<LocalVoucherMerchantVo>();
					marray.add(item);
					merchantMap.put(item.getVoucherId(), marray);
				}
			}
			
		}
		Integer count = null;
		log.info("localSynCloudToLocal vouchers.size():"+vouchers.size());
		// 将云端接收的信息更新到本地
		for (LocalVoucherVo item : vouchers) {
			
			count = localVoucherDao.selectVoucherVoCountToRefVoucherNo(item.getRefVoucherNo());
			
			try {

				// 判断是是否是新增数据
				if (count == null || count.equals(0)) {
					log.info("localSynCloudToLocal insert LocalVoucherVo:"+item);
					localVoucherTransactionService.addVoucherData(item, merchantMap.get(item.getRefVoucherId()));
				} else {
					log.info("localSynCloudToLocal update LocalVoucherVo:"+item);
					localVoucherTransactionService.updateSynToCloudData(item);
				}
			} catch (Exception e) {
				e.printStackTrace();
				log.warn("error,VoucherNo：" + item.getRefVoucherNo() + "Exception:" + e);
			}
		}
	}

	@Override
	public void localSynLocalToCloud(LocalVoucherVo voucher, LocalTerminalRecordVo terminalRecord) {
		
		log.info(" Process in LocalVoucherTransactionImpl.localSynLocalToCloud method, parameter voucher.toString: "
				+ voucher.toString() + ", terminalRecord.toString: " + terminalRecord.toString());

		Integer notSynDataCount = mqCacheDao.selectByDelFlagCount();

		// 如果有未同步的老数据优先同步
		if (notSynDataCount != null && notSynDataCount.intValue() > 0) {
			log.info("有历史历史同步失败的数据，优先同步");
			localVoucherTransactionService.synMqCache();
			log.info("历史数据同步完成");
		}

		try {
			localSynToCloud(voucher, terminalRecord);
		} catch (Exception e) {
			// MQ连接异常，记录同步失败的信息
			MqCache record = new MqCache();
			record.setDelFlag(1);
			record.setMessage("同步失败，凭证号：" + voucher.getRefVoucherNo() + "  出票记录编号："
					+ terminalRecord.getTerminalRecordId().toString() + "  异常：" + e.toString());
			record.setQueryTable("S_VOUCHER_" + DateUtils.format(new Date(), "yyyyMMdd"));
			record.setTerminalRecordId(terminalRecord.getTerminalRecordId());
			record.setVourcherNo(voucher.getRefVoucherNo());
			mqCacheDao.insert(record);
			log.warn("sendJMSMessage VoucherNo," + voucher.getRefVoucherNo() + "Exception:" + e);
		}
		log.info("同步本地凭证信息结束");

	}

	@Override
	public void localSynToCloud(LocalVoucherVo voucher, LocalTerminalRecordVo terminalRecord) {
		log.info("凭证号：" + voucher.getRefVoucherNo());
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> smsdata = new ArrayList<Map<String, Object>>();
		map.put("voucher", voucher);
		map.put("terminalRecord", terminalRecord);
		smsdata.add(map);
		MessageEntity<Map<String, Object>> message = new MessageEntity<Map<String, Object>>();
		message.setType(1);
		message.setArrayBody(smsdata);
		this.sendJMSMessage(message, "octAll", false);
	}

	@Override
	public void synOutlineProduct(OutlineProduct outlineProduct) {
		log.info("Process in LocalVoucherTransactionImpl.synOutlineProduct method prarameter：OutlineProduct," + outlineProduct);
		MessageEntity<OutlineProduct> message = new MessageEntity<OutlineProduct>();
		message.setObjectBody(outlineProduct);
		message.setType(2);
		try {
			this.sendJMSMessage(message, "octAll", false);
		}catch(Exception e){
			log.error("sendJMSMessage OutlineProduct," + outlineProduct + "  Exception:" + e);
		}
	}
}
