package com.pj.ebcenter.manager.local.jms.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.ebcenter.manager.local.dao.ILocalTerminalRecordDao;
import com.pj.ebcenter.manager.local.dao.ILocalVoucherDao;
import com.pj.ebcenter.manager.local.dao.IMqCacheDao;
import com.pj.ebcenter.manager.local.dao.IMqSynLogDao;
import com.pj.ebcenter.manager.local.jms.service.ILocalVoucherService;
import com.pj.ebcenter.manager.local.jms.service.ILocalVoucherTransactionService;
import com.pj.ebcenter.manager.local.vo.LocalTerminalRecordVo;
import com.pj.ebcenter.manager.local.vo.LocalVoucherMerchantVo;
import com.pj.ebcenter.manager.local.vo.LocalVoucherVo;
import com.pj.ebcenter.manager.local.vo.MqCache;
import com.pj.ebcenter.manager.local.vo.MqSynLog;

@Service("localVoucherTransactionService")
public class ILocalVoucherTransactionServiceImpl implements ILocalVoucherTransactionService {

	protected Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private ILocalVoucherDao localVoucherDao;

	@Autowired
	private IMqSynLogDao mqSynLogDao;

	@Autowired
	private IMqCacheDao mqCacheDao;

	@Autowired
	private ILocalTerminalRecordDao localTerminalRecordDao;

	@Autowired
	private ILocalVoucherService localVoucherService;

	@Override
	@Transactional
	public void updateSynToCloudData(LocalVoucherVo localVoucherVo) {
		localVoucherDao.updateSynToCloudData(localVoucherVo);

		// 记录日志
		MqSynLog log = new MqSynLog();
		log.setLogStatus(1);
		log.setLogDate(new Date());
		log.setMessage("景区阿里云景台同步信息到本地成功,同步方式[update]");
		log.setVoucher(localVoucherVo.getRefVoucherNo().toString());
		mqSynLogDao.insert(log);
	}

	@Override
	@Transactional
	public void addVoucherData(LocalVoucherVo localVoucherVo, List<LocalVoucherMerchantVo> voucherMerchants) {
		localVoucherDao.insertVoucherData(localVoucherVo);
		if (voucherMerchants!=null && voucherMerchants.size() != 0) {
			localVoucherDao.batchInsertVoucherMerchantData(voucherMerchants);
		}

		// 记录日志
		MqSynLog log = new MqSynLog();
		log.setLogStatus(1);
		log.setLogDate(new Date());
		log.setMessage("景区阿里云平台同步信息到本地成功,同步方式[insert]");
		log.setVoucher(localVoucherVo.getRefVoucherNo().toString());
		mqSynLogDao.insert(log);
	}

	@Override
	@Transactional
	public void synMqCache() {
		LocalVoucherVo voucher = null;
		LocalTerminalRecordVo terminalRecord = null;
		List<MqCache> mqCache = mqCacheDao.selectByDelFlag();

		// 循环同步
		for (MqCache item : mqCache) {
			try {
				voucher = localVoucherDao.selectVoucherVoToRefVoucherNo(item.getVourcherNo());
				terminalRecord = localTerminalRecordDao.selectByTerminalRecordId(item.getTerminalRecordId());
				localVoucherService.localSynToCloud(voucher, terminalRecord);
			} catch (Exception e) {
				log.warn("同步数据异常,凭证号：" + item.getVourcherNo() + "Exception:" + e);
				continue;
			}
			mqCacheDao.delMqCache(item.getMqTaskId());
		}
	}
}
