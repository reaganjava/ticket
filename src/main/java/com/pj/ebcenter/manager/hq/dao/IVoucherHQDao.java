package com.pj.ebcenter.manager.hq.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.pj.ebcenter.manager.hq.entity.Voucher;
import com.pj.ebcenter.manager.hq.exception.BussinessException;

/**
 * 
 * <p>Description: 凭证管理</p>
 * @date 2013年10月16日
 * @author 蒋伟
 * @version 1.0
 * <p>Company:Mopon</p>
 * <p>Copyright:Copyright(c)2013</p>
 */
@Repository
public interface IVoucherHQDao {
	
	/**
	 * 
	 * 方法用途: 插入凭证信息<br>
	 * 实现步骤: <br>
	 * @param voucher 凭证对象
	 * @throws SQLException
	 */
	public void save(Voucher voucher);
	
	/**
	 * 
	 * 方法用途: 根据凭证值查询凭证详情<br>
	 * 实现步骤: <br>
	 * @param voucherValue
	 * @return
	 * @throws SQLException
	 */
	public Voucher getVoucherDetailByVoucher(String voucherValue);
	/**
	 * 
	 * 方法用途: 修改凭证状态<br>
	 * 实现步骤: <br>
	 * @param voucherValue
	 * @return
	 * @throws SQLException
	 */
	public boolean  updateVoucherOutTicket(Voucher voucher) throws BussinessException;
	
	/**
	 * 方法用途: 查询凭证同步标志位0<br>
	 * 实现步骤: <br>
	 * @return 未同步凭证列表
	 * @throws SQLException
	 */
	public List<Voucher> selectVoucherByIsSync();
	
	
	public void updateIsSync(Voucher voucher);
}
