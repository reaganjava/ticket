package com.pj.ebcenter.ticket.service;



import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pj.ebcenter.ticket.dao.ISeqDao;
import com.pj.ebcenter.ticket.dao.IVoucherDao;
import com.pj.ebcenter.ticket.entity.Equipment;
import com.pj.ebcenter.ticket.entity.Registration;
import com.pj.ebcenter.ticket.util.JournalSeq;
import com.pj.ebcenter.ticket.util.MessageDef;
import com.pj.ebcenter.ticket.util.SeqContent;
/**
 * 
 * <p>Description: 凭证类服务层</p>
 * @date 2013年10月27日
 * @author 蒋伟
 * @version 1.0
 * <p>Company:Mopon</p>
 * <p>Copyright:Copyright(c)2013</p>
 */
@Service("voucherServiceImpl")
public class VoucherServiceImpl implements IVoucherService {
	
	@Autowired
	private IVoucherDao voucherDao;
    @Autowired
    private ISeqDao    seqDaoImpl;
	/**
	 * 
	 * 方法用途: 更新凭证设备<br>
	 * 实现步骤: <br>
	 * @param map
	 * @throws SQLException 
	 *
	 */
	public void modify_voucher_deviceid_by_value(Map<String, String> voucher) throws SQLException {
			 voucherDao.update_voucher_deviceid_by_value(voucher);
	}

	/**
	 * 
	 * 方法用途: 查询凭证信息<br>
	 * 实现步骤: <br>
	 * @param voucher
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("rawtypes")
	public List queryVoucher(Map<String, String> params) throws SQLException {
		return voucherDao.select_Voucher(params);
	}


	@Override
	public int modify_voucher_for_verify(Map<String, String> voucher) throws SQLException {
		 int  flagVoucherMerchar = voucherDao.update_voucherMerchant_for_verify(voucher);
		 int  flagVoucher = voucherDao.update_voucher_for_verify(voucher);
		return flagVoucher== 0 ? flagVoucherMerchar : flagVoucher;
	}


	@Override
	public int add_s_terminal_record(Map<String, String> voucher) throws SQLException {
		return voucherDao.insert_s_terminal_record(voucher);
	}



	@Override
	public int modify_s_terminal_record(Map<String, String> voucher) throws SQLException {
		return voucherDao.update_s_terminal_record(voucher);
	}
	/**
	 * 签到服务
	 * **/
	@Override
	public String signIn(Map<String, String> params) throws SQLException {
		String seq = "";
		StringBuffer sb = new StringBuffer();
		int count = voucherDao.queryEquipmentIsRegister(params);
		if(count<=0){
		try {
			seq = JournalSeq.getSpecifiedLengthSeq(seqDaoImpl.getNextVal(SeqContent.SEQ_EQUIPMENT_BATCH_NO));
		} catch (Exception e) {
			e.printStackTrace();
		}
				    params.put("batch_no", seq);
				    //签到修改设备注册状态
				     voucherDao.signIn(params);
				     //插入批次流水到设备批次表
					 voucherDao.insert_s_registration_service(params);
					 //根据设备ID联合查询设备，设备批次表
					 List<Equipment> list = new ArrayList<Equipment>(); 
					 list = voucherDao.queryEquipmentByNumber(params);
					 if(list.size()<=0){
						 sb.append("1").append("#").append(MessageDef.msg_equipment_nofound).append("#");
					 }else{
					 Equipment equipment = (Equipment) list.get(0);
					 Registration registration = equipment.getEquipmentRegistration().get(0);
					 sb.append("0").append("#").append(registration.getBatch_no()).append("#").append(equipment.getMerchantId()).append("#");
					 }
		}
		else{
					List<Equipment> list = new ArrayList<Equipment>(); 
					list = voucherDao.queryEquipmentByNumber(params);
					Equipment equipment = (Equipment) list.get(0);
					Registration registration = equipment.getEquipmentRegistration().get(0);
					if(equipment.getIsRegister().equals("0")){
					return sb.append("0").append("#").append(registration.getBatch_no()).append("#").append(equipment.getMerchantId()).append("#").append(MessageDef.msg_equipment_isRegister).append("#").toString();
					}
					else
					return sb.append("1").append("#").append(MessageDef.msg_equipment_isRegister).append("#").toString();

		}
		return sb.toString();
	}

	@Override
	public String signOut(Map<String, String> params) throws SQLException {
					StringBuffer sb = new StringBuffer();
					voucherDao.signOut(params);
					return sb.append("0").append("#").append(MessageDef.msg_signOut_success).append("#").toString();
	}

	@Override
	public void insert_s_registration_service(Map<String, String> params) throws SQLException {
					voucherDao.insert_s_registration_service(params);
	}

	@Override
	public int queryEquipmentIsRegister(Map<String, String> params) throws SQLException {
		             return voucherDao.queryEquipmentIsRegister(params);
	}

	@Override
	public int modifyVoucherIsTicket(Map<String, String> voucher) throws SQLException {
				  return  voucherDao.modifyVoucherIsTicket(voucher);
	}

	@Override
	public void add_s_ticket_record(Map<String, String> voucher) throws SQLException {
								voucherDao.insert_s_ticket_record(voucher);
	}

}
