package com.pj.ebcenter.manager.local.ftp.service;

import java.util.List;
import java.util.Map;

import com.pj.ebcenter.manager.local.vo.FtpLogDataVo;
import com.pj.ebcenter.manager.local.vo.LocalVoucherMerchantVo;
import com.pj.ebcenter.manager.local.vo.LocalVoucherVo;

/**
 * <p>Description: </p>
 * @date 2014年1月17日
 * @author 王方威
 * @version 1.0
 * <p>Company:Mopon</p>
 * <p>Copyright:Copyright(c)2013</p>
 */
public interface ILocalFtpTransactionService {

	/**
	 * 处理这次批处理的需要创建的表，备份的数据
	 * 方法用途: <br>
	 * 实现步骤: <br>
	 * @param date
	 */
	public void initThisBatchDB(String date, Map<LocalVoucherVo, List<LocalVoucherMerchantVo>> voucherData);

	/**
	 * 保存错误的日志
	 * 方法用途: <br>
	 * 实现步骤: <br>
	 * @param data
	 */
	public void insertFtpLogDataVo(FtpLogDataVo data);
}
