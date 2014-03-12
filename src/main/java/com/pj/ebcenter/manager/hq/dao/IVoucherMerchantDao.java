package com.pj.ebcenter.manager.hq.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.pj.ebcenter.manager.hq.entity.VoucherMerchant;

/**
 * 
 * <p>Description: 凭证商户记录表管理</p>
 * @date 2013年10月16日
 * @author 蒋伟
 * @version 1.0
 * <p>Company:Mopon</p>
 * <p>Copyright:Copyright(c)2013</p>
 */
@Repository
public interface IVoucherMerchantDao {

	/**
	 * 
	 * 方法用途: 根据商品ID和凭证ID查询商户 信息.<br>
	 * 实现步骤: <br>
	 * @param voucherMerchant
	 * @return
	 * @throws SQLException
	 */
	public List<VoucherMerchant> queryMerchantInfoByGoodsId(VoucherMerchant voucherMerchant);
	
	/**
	 * 
	 * 方法用途: 保存.<br>
	 * 实现步骤: <br>
	 * @param voucherMerchant
	 * @throws SQLException
	 */
	public void save(VoucherMerchant voucherMerchant);
	
	public List<VoucherMerchant> queryMerchantByIsSync();
	
	public void updateIsSync(VoucherMerchant voucherMerchant);
}
