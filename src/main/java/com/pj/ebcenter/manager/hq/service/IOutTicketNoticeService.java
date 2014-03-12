package com.pj.ebcenter.manager.hq.service;

import com.pj.ebcenter.manager.hq.exception.BussinessException;

/**
 * <p>Description: </p>
 * @date 2013年11月28日
 * @author 蒋伟
 * @version 1.0
 * <p>Company:Mopon</p>
 * <p>Copyright:Copyright(c)2013</p>
 */
public interface IOutTicketNoticeService {
	public boolean  updateVoucherOutTicket(String voucherValue) throws BussinessException;
}