package com.pj.ebcenter.ticket.dao;



import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.pj.ebcenter.ticket.entity.Equipment;

/**
 * 
 * <p>Description: 凭证验证</p>
 * @date 2013年10月16日
 * @author 蒋伟
 * @version 1.0
 * <p>Company:Mopon</p>
 * <p>Copyright:Copyright(c)2013</p>
 */
@Repository
public interface IVoucherDao {

	@SuppressWarnings("rawtypes")
	public List select_Voucher(Map<String,String> params) throws SQLException;
	/**
	 * 
	 * 方法用途: 更新凭证设备<br>
	 * 实现步骤: <br>
	 * @param map
	 *
	 */
	public void update_voucher_deviceid_by_value(Map<String, String> voucher)throws SQLException;
	/**
	 * 
	 * 方法用途:  更新凭票信息<br>
	 * 实现步骤: <br>
	 * @param map
	 *
	 */
	public int update_voucher_for_verify(Map<String, String> voucher)throws SQLException;
	/**
	 * 
	 * 方法用途:  出票记录<br>
	 * 实现步骤: <br>
	 * @param map
	 *
	 */
	public int insert_s_terminal_record(Map<String, String> voucher)throws SQLException;
	/**
	 * 
	 * 方法用途:  更新出票记录<br>
	 * 实现步骤: <br>
	 * @param map
	 *
	 */
	public int update_s_terminal_record(Map<String, String> voucher)throws SQLException;
	/**
	 * 
	 * 方法用途:  POS机器签到服务<br>
	 * 实现步骤: <br>
	 * @param map
	 */
	public void signIn(Map<String,String> params) throws SQLException;
	/**
	 * 
	 * 方法用途:  POS机器签退服务<br>
	 * 实现步骤: <br>
	 * @param map
	 */
	public void signOut(Map<String,String> params) throws SQLException;
	/**
	 * 
	 * 方法用途:  业务平台产生批次号<br>
	 * 实现步骤: <br>
	 * @param map
	 */
	public void insert_s_registration_service(Map<String,String> params) throws SQLException;
	/**
	 * 
	 * 方法用途:  查询设备匹配的批次号<br>
	 * 实现步骤: <br>
	 * @param map
	 */
	public List<Equipment> queryEquipmentByNumber(Map<String,String> params) throws SQLException;
	/**
	 * 
	 * 方法用途:  查询该设备是否已经注册过<br>
	 * 实现步骤: <br>
	 * @param map
	 */
	public int queryEquipmentIsRegister(Map<String,String> params)throws SQLException;
	/***
	 *  方法用途
	 *  实现步骤:<br>
	 *  @param map
	 * **/
	public int update_voucherMerchant_for_verify(Map<String,String> params)throws SQLException;
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
	public void insert_s_ticket_record(Map<String, String> voucher) throws SQLException;
	/**
	 * 
	 * 方法用途:  查询设备<br>
	 * 实现步骤: <br>
	 * @param map
	 */
	public List<Equipment> selectEquipmentByEquipmentNumber(Map<String,String> params)throws SQLException;
	/**
	 * 
	 * 方法用途:  查询所有设备用于缓存<br>
	 * 实现步骤: <br>
	 * @param map
	 */
	public List<Equipment> queryAllEquipment()throws SQLException;

}
