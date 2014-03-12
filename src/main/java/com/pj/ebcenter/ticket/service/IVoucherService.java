package com.pj.ebcenter.ticket.service;



import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 
 * <p>Description: 凭证类服务层</p>
 * @date 2013年10月16日
 * @author 蒋伟
 * @version 1.0
 * <p>Company:Mopon</p>
 * <p>Copyright:Copyright(c)2013</p>
 */
public interface IVoucherService {
	/**
	 * 
	 * 方法用途: 更新凭证设备<br>
	 * 实现步骤: <br>
	 * @param map
	 * @throws SQLException 
	 */
	public void modify_voucher_deviceid_by_value(Map<String,String> voucher) throws SQLException;
	/**
	 * 
	 * 方法用途: 查询凭证信息<br>
	 * 实现步骤: <br>
	 * @param voucher
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("rawtypes")
	public List queryVoucher(Map<String,String> params) throws SQLException;
	/**
	 * 
	 * 方法用途:  更新凭票信息<br>
	 * 实现步骤: <br>
	 * @param map
	 */
	public int modify_voucher_for_verify(Map<String, String> voucher)throws SQLException;
	/**
	 * 
	 * 方法用途:  入园记录<br>
	 * 实现步骤: <br>
	 * @param map
	 *
	 */
	public int add_s_terminal_record(Map<String, String> voucher)throws SQLException;
	/**
	 * 
	 * 方法用途:  更新入园记录<br>
	 * 实现步骤: <br>
	 * @param map
	 *
	 */
	public int modify_s_terminal_record(Map<String, String> voucher)throws SQLException;
	/**
	 * 
	 * 方法用途:  POS机器签到服务<br>
	 * 实现步骤: <br>
	 * @param map
	 * @throws SQLException 
	 */
	public String signIn(Map<String,String> params) throws SQLException  ;
	/**
	 * 
	 * 方法用途:  POS机器签退服务<br>
	 * 实现步骤: <br>
	 * @param map
	 */
	public String signOut(Map<String,String> params) throws SQLException;
	/**
	 * 
	 * 方法用途:  业务平台产生批次号<br>
	 * 实现步骤: <br>
	 * @param map
	 */
	public void insert_s_registration_service(Map<String,String> params) throws SQLException;
	/**
	 * 
	 * 方法用途:  查询该设备是否已经注册过<br>
	 * 实现步骤: <br>
	 * @param map
	 */
	public int queryEquipmentIsRegister(Map<String,String> params)throws SQLException;
	/**
	 * 
	 * 方法用途:  更新换票接口<br>
	 * 实现步骤: <br>
	 * @param map
	 */
	public int modifyVoucherIsTicket(Map<String, String> voucher)throws SQLException;
	/**
	 * 
	 * 方法用途:  插入出票记录<br>
	 * 实现步骤: <br>
	 * @param map
	 */
	public void add_s_ticket_record(Map<String, String> voucher)throws SQLException;

}
