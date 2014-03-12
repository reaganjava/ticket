package com.pj.ebcenter.manager.local.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.pj.ebcenter.manager.local.vo.LocalVoucherMerchantVo;
import com.pj.ebcenter.manager.local.vo.LocalVoucherVo;

@Repository
public interface ILocalVoucherDao {

	/**
	 * 查找指定日期能够使用的凭证相关信息
	 * 方法用途: <br>
	 * 实现步骤: <br>
	 * @return
	 */
	public List<LocalVoucherVo> selectSynToLocalVoucher();

	/**
	 * 查找指定日期凭证能够消费的商户信息
	 * 方法用途: <br>
	 * 实现步骤: <br>
	 * @return
	 */
	public List<LocalVoucherMerchantVo> selectSynToLocalVoucherMerchant();
	
	/**
	 * 将云端的退票作废的票据同步到本地
	 * 
	 * @param entity
	 */
	public void updateSynToCloudData(@Param("entity") LocalVoucherVo entity);
	
	/** 
	 * 方法用途:根据凭证号查询凭证存在记录 <br>
	 * 实现步骤: <br>
	 * @param refVoucherNo   要同步的数据
	 * @return 凭证记录数
	 */
	public Integer selectVoucherVoCountToRefVoucherNo(Long refVoucherNo);
	
	/** 
	 * 方法用途:根据凭证号查询凭证信息 <br>
	 * 实现步骤: <br>
	 * @param refVoucherNo   要同步的数据
	 * @return 凭证信息
	 */
	public LocalVoucherVo selectVoucherVoToRefVoucherNo(Long refVoucherNo);
	
	
	/**
	 * 动态创建凭证表
	 * 方法用途: <br>
	 * 实现步骤: <br>
	 * @param tableName:当前S_VOUCHER表
	 * @param oldTable:备份的表明
	 */
	public void createVoucherHistoryDataTable(@Param("tableName") String tableName,
			@Param("oldTable") String oldTable);
	
	/**
	 * 清空表S_VOUCHER的数据
	 * 方法用途: <br>
	 * 实现步骤: <br>
	 */
	public void truncateVoucherData(@Param("tableName") String tableName);
	
	/**
	 * 插入凭证信息
	 * 方法用途: <br>
	 * 实现步骤: <br>
	 * @param voucher
	 */
	public void insertVoucherData(@Param("voucher")LocalVoucherVo voucher);
	
	/**
	 * 漂亮插入
	 * 方法用途: <br>
	 * 实现步骤: <br>
	 * @param voucherMerchant
	 */
	public void batchInsertVoucherMerchantData(List<LocalVoucherMerchantVo> list);
}
