package com.pj.ebcenter.manager.local.jms.service;

import java.util.List;
import java.util.Map;

import javax.jms.JMSException;

import com.pj.ebcenter.manager.hq.entity.OutlineProduct;
import com.pj.ebcenter.manager.local.vo.LocalTerminalRecordVo;
import com.pj.ebcenter.manager.local.vo.LocalVoucherVo;

public interface ILocalVoucherService {
	
	/** 
	 * 方法用途: 将数据同步到本地<br>
	 * 实现步骤: 接收阿里云的数据同步到本地<br>
	 * @param vouchers 要同步的数据
	 */
	public void localSynCloudToLocal(List<Map<String,Object>> o);
	
	/**
	 * 方法用途: 本地验票数据同步<br>
	 * 实现步骤: <br> 
	 * @param voucher 凭证信息
	 * @param terminalRecord 出票信息
	 * @throws JMSException JMS异常
	 */
	public void localSynLocalToCloud(LocalVoucherVo voucher,LocalTerminalRecordVo terminalRecord);
	
	/**
	 * 
	 * 方法用途:将本地验票数据同步到阿里云 <br>
	 * 实现步骤: <br>
	 * @param voucher
	 * @param terminalRecord
	 */
	public void localSynToCloud(LocalVoucherVo voucher,
			LocalTerminalRecordVo terminalRecord);
	
	/**
	 * 
	 * 方法用途:线下商数据同步 <br>
	 * 实现步骤: <br>
	 * @param voucher
	 * @param terminalRecord
	 */
	public void synOutlineProduct(OutlineProduct outlineProduct);
}
