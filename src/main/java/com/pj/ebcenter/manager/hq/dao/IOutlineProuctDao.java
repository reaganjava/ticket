package com.pj.ebcenter.manager.hq.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.pj.ebcenter.manager.hq.entity.OutlineProduct;

/**
 * <p>Copyright:Copyright(c)2012</p>
 * <p>Company:Mopon</p>
 * @date 2013年11月21日
 * @author あんど おか
 * @version 1.0
 */
@Repository
public interface IOutlineProuctDao {

	/**
	 * 方法用途: 保存线下商品<br>
	 * 实现步骤: <br>
	 * @param outlineProduct
	 * @return
	 */
	public int saveOutlineProduct(@Param("product")
	OutlineProduct outlineProduct);

	/**
	 * 通过账号和线下的商品的ID查找同步商品的信息
	 * 方法用途: <br>
	 * 实现步骤: <br>
	 * @param refProductId
	 * @param offlineAccount
	 * @return
	 */
	public List<OutlineProduct> getOutlineProductByIdAndAccount(@Param("refProductId")
	String refProductId, @Param("offlineAccount")
	String offlineAccount);

	/** 
	 * 方法用途:线下商品更新，更新商品 <br>
	 * 实现步骤: <br>
	 * @param outlineProduct   
	 */
	public void updateOutlineProduct(@Param("product")
	OutlineProduct outlineProduct);
}
