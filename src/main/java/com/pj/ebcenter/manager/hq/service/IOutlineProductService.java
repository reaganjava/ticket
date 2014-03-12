package com.pj.ebcenter.manager.hq.service;

import com.pj.ebcenter.manager.hq.entity.OutlineProduct;
import com.pj.ebcenter.manager.hq.exception.BussinessException;

/**
 * <p>Copyright:Copyright(c)2012</p>
 * <p>Company:Mopon</p>
 * @date 2013年11月21日
 * @author 王方威
 * @version 1.0
 */
public interface IOutlineProductService {

	/**
	 * 方法用途: 保存同步商品<br>
	 * 实现步骤: <br>
	 * @param outlineProduct
	 * @throws BussinessException 
	 */
	public OutlineProduct saveOutlineProduct(OutlineProduct outlineProduct) throws BussinessException;
}
