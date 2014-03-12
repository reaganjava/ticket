package com.pj.ebcenter.manager.hq.service;

import com.pj.ebcenter.manager.hq.entity.Voucher;
import com.pj.ebcenter.manager.hq.exception.BussinessException;

/**
 * <p>Description: </p>
 * @date 2013年11月22日
 * @author 蒋伟
 * @version 1.0
 * <p>Company:Mopon</p>
 * <p>Copyright:Copyright(c)2013</p>
 */
public interface ICheckETTicketService {
	/**
	 * 
	 * 方法用途: 查询凭证详情<br>
	 * 实现步骤: <br>
	 * @param voucher
	 * @return
	 * @throws BussinessException 
	 */
	public Voucher queryVoucherDetail(String voucherValue);
}
