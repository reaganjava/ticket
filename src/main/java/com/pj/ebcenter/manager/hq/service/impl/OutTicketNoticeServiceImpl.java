package com.pj.ebcenter.manager.hq.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pj.ebcenter.manager.hq.dao.IVoucherHQDao;
import com.pj.ebcenter.manager.hq.entity.Voucher;
import com.pj.ebcenter.manager.hq.exception.BussinessException;
import com.pj.ebcenter.manager.hq.service.IOutTicketNoticeService;

/**
 * <p>Description: </p>
 * @date 2013年11月28日
 * @author 蒋伟
 * @version 1.0
 * <p>Company:Mopon</p>
 * <p>Copyright:Copyright(c)2013</p>
 */
@Service("outTicketNoticeServiceImpl")
public class OutTicketNoticeServiceImpl implements IOutTicketNoticeService{
	protected Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	private IVoucherHQDao voucherHQDao;
	/**根据请求过来的字符串处理返回XML消息
	 * @param xmlContext 请求的XML字符串
	 * @throws BussinessException 
	 * **/
	public boolean  updateVoucherOutTicket(String voucherValue) throws BussinessException {
		logger.info("outTicketNoticeServiceImpl.queryVoucherDetail method in call, parameter voucherValue:" + voucherValue);
		Voucher queryObj = voucherHQDao.getVoucherDetailByVoucher(voucherValue);
		if (queryObj == null) {
			throw new BussinessException("212", "凭证值为空!");
		}
		return voucherHQDao.updateVoucherOutTicket(queryObj);
	}
}
