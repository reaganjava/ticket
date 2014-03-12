package com.pj.ebcenter.ticket.util;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pj.ebcenter.manager.local.jms.service.ILocalVoucherService;
import com.pj.ebcenter.manager.local.vo.LocalTerminalRecordVo;
import com.pj.ebcenter.manager.local.vo.LocalVoucherVo;
import com.pj.ebcenter.ticket.dao.ISeqDao;
import com.pj.ebcenter.ticket.entity.Voucher;
import com.pj.ebcenter.ticket.service.IVoucherService;

/**
 * <p>Description: </p>
 * @date 2013年10月23日
 * @author 蒋伟
 * @version 1.0
 * <p>Company:Mopon</p>
 * <p>Copyright:Copyright(c)2013</p>
 */
@Component("terminalManager")
public class TerminalManager {
	@Autowired
	private IVoucherService voucherService;
	@Autowired
	private ISeqDao seqDaoImpl;
	@Autowired
	private ILocalVoucherService iLocalVoucherService;
		/**
		 * oper =1 代表添加 2 代表更新
		 * 
		 * @param ctx
		 * @throws Exception 
		 */
		public    void  addOrUpdate(Map params,Voucher voucher,Map map) throws Exception {
			String operationType = params.get("oper").toString();
			String seq = null;
			// 重打印
			if (("0").equals(operationType)) {
				voucherService.modify_s_terminal_record(params);
			} else {
				// 供应商结算价
			//	float settlement_price = new Float(params.get("settlement_price").toString()).floatValue();
				// 销售单价
			//	float sales_price = new Float(params.get("sales_price").toString()).floatValue();
				// 一次消费数量
				int print_times = new Integer(params.get("print_times").toString()).intValue();
				params.put("total_price", new BigDecimal(params.get("sales_price").toString()).multiply(new BigDecimal(print_times)) );
				// 结算总价
				params.put("all_settlement_price",new BigDecimal(params.get("settlement_price").toString()).multiply(new BigDecimal(print_times)));
				seq = JournalSeq.getSpecifiedLengthSeq(seqDaoImpl.getNextVal(SeqContent.SEQ_S_TERMINAL_RECORD));
				params.put("terminal_record_id", seq);
			    voucherService.add_s_terminal_record(params);
			}
			List<Voucher> list = voucherService.queryVoucher(map);
			voucher = list.get(0);
			synLocalToCloud(voucher, map,seq);
		}

		public    void  addOrUpdateTicket(Map params) throws Exception {
				String seq = JournalSeq.getSpecifiedLengthSeq(seqDaoImpl.getNextVal(SeqContent.SEQ_S_TERMINAL_RECORD));
				params.put("terminal_record_id", seq);
			    voucherService.add_s_ticket_record(params);
			}
		/**
		 * 描述：调用接口同步数据到阿里云
		 * @param Map
		 * @param Voucher
		 * 
		 * ***/
		public void synLocalToCloud(Voucher voucher,Map<String, String> map,String seq) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
			LocalVoucherVo vo = new LocalVoucherVo();
			LocalTerminalRecordVo terminalVo = new LocalTerminalRecordVo();
			Integer num = voucher.getMaxUseTimes() - voucher.getFreezeNum() - voucher.getCancelNum();
			PropertyUtils.copyProperties(vo, voucher);
			PropertyUtils.copyProperties(terminalVo, voucher);
			vo.setRefVoucherId(voucher.getVoucherId());
			vo.setRefVoucherNo(voucher.getVoucherNo());
			vo.setValidateTime(voucher.getValidateTimes());
			vo.setIsSecondValid(voucher.getIsSeondValid());
			vo.setCertificateNum(voucher.getCertificateNum());
			vo.setExpExceptionData(voucher.getExpExceptionDate());
			terminalVo.setAllSettlementPrice(new BigDecimal(voucher.getSupplierSettlementPrice().toString()).multiply(new BigDecimal(num)) );
			terminalVo.setTotalPrice(new BigDecimal(voucher.getPrice().toString()).multiply(new BigDecimal(num)) );
			terminalVo.setBatchNo(map.get("batch_no"));
			terminalVo.setCheckingType(new Byte(map.get("checking_type")));
			terminalVo.setTradeNum(map.get("transactionID"));
			terminalVo.setPrintTimes(num);
			terminalVo.setVoucherValue(voucher.getVoucherValue());
			terminalVo.setTerminalNum(map.get("deviceid"));
			terminalVo.setMerchantId(map.get("merchant_Id"));
			terminalVo.setMerchantName(map.get("merchantName"));
			terminalVo.setRecordChannel(map.get("merchantName"));
			terminalVo.setOrderNum(voucher.getOrderId());
			terminalVo.setTerminalRecordId(Integer.valueOf(seq));
			terminalVo.setCreateTime(new Date());
			System.err.println(vo);
			System.err.println(terminalVo);
			iLocalVoucherService.localSynLocalToCloud(vo, terminalVo);


		}
}
