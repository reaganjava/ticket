package com.pj.ebcenter.manager.hq.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pj.ebcenter.manager.hq.constant.LocalConstant;
import com.pj.ebcenter.manager.hq.constant.StatusCode;
import com.pj.ebcenter.manager.hq.dao.IOutlineProuctDao;
import com.pj.ebcenter.manager.hq.entity.OutlineProduct;
import com.pj.ebcenter.manager.hq.exception.BussinessException;
import com.pj.ebcenter.manager.hq.service.IOutlineProductService;
import com.pj.ebcenter.manager.local.jms.service.ILocalVoucherService;

/**
 * <p>Copyright:Copyright(c)2012</p>
 * <p>Company:Mopon</p>
 * @date 2013年11月21日
 * @author あんど おか
 * @version 1.0
 */
@Service("outlineProductService")
public class OutlineProductServiceImpl implements IOutlineProductService {

	protected Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private IOutlineProuctDao outlineProuctDao;
	
	@Autowired
	private ILocalVoucherService localVoucherService;

	/** 
	 * 方法用途: <br>
	 * 实现步骤: <br>
	 * @param outlineProduct   
	 * @throws BussinessException 
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public OutlineProduct saveOutlineProduct(OutlineProduct outlineProduct) throws BussinessException {

		logger.debug(" Process in OutlineProductServiceImpl.saveOutlineProduct method, parameter outlineProduct.toString(): "
				+ outlineProduct.toString());

		// 初始化返回值
		OutlineProduct res = new OutlineProduct();

		// 通过商品的Id和来源方的账号查找同步的商品是否存在
		List<OutlineProduct> existProduct = outlineProuctDao.getOutlineProductByIdAndAccount(
				outlineProduct.getRefProductId(), outlineProduct.getOfflineAccount());

		// 查看满足条件的已经同步的商品是否存在
		int existProductSize = existProduct.size();

		// 判断查询的数据是否错在错误
		if (existProductSize > 1) {
			logger.warn(" the OutlineProduct table has Error data. ");

			throw new BussinessException(StatusCode.CODE_ERROR_SYSTEM_DATA, StatusCode.MESSAGE_CODE_ERROR_SYSTEM_DATA);
		} else {

			// 判断同步的对象这次是否在数据存在
			if (existProductSize == 1) {
				OutlineProduct preObject = existProduct.get(0);
				// 判断需要处理的对象是否和传入的对象时完全一样
				if (!outlineProduct.equals(preObject)) {
					outlineProduct.setIsSyn(LocalConstant.NOT_SYN_WEB);
					outlineProduct.setIsUpdate(LocalConstant.UPDATE_RECORD);
					outlineProuctDao.updateOutlineProduct(outlineProduct);

					res = outlineProduct;
				} else {

					throw new BussinessException(StatusCode.CODE_SUCCESS, StatusCode.MESSAGE_CODE_SUCCESS_NO_DO);
				}
			} else {
				outlineProduct.setIsSyn(LocalConstant.NOT_SYN_WEB);
				outlineProduct.setIsUpdate(LocalConstant.CREATE_RECORD);
				outlineProuctDao.saveOutlineProduct(outlineProduct);

				res = outlineProduct;
			}
			
			//将数据发送到云平台
			localVoucherService.synOutlineProduct(outlineProduct);
		}

		return res;

	}
}
