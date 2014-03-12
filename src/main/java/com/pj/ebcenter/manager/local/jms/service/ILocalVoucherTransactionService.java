package com.pj.ebcenter.manager.local.jms.service;

import java.util.List;

import com.pj.ebcenter.manager.local.vo.LocalVoucherMerchantVo;
import com.pj.ebcenter.manager.local.vo.LocalVoucherVo;

public interface ILocalVoucherTransactionService {
	
	/**
	 * 方法用途: 将云端数据同步到本地<br>
	 * 实现步骤: <br>
	 * @param localVoucherVo
	 */
	public void updateSynToCloudData(LocalVoucherVo localVoucherVo);
	
	/**
	 * 插入凭证信息
	 * 方法用途: <br>
	 * 实现步骤: <br>
	 * @param voucher
	 */
	public void addVoucherData(LocalVoucherVo voucher,List<LocalVoucherMerchantVo> localVoucherMerchantVo);
	
	/**
	 * 方法用途: 将未连接MQ的缓存数据继续同步<br>
	 * 实现步骤: <br>
	 */
	public void synMqCache();
}
