package com.pj.ebcenter.manager.local.ftp.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pj.ebcenter.manager.local.dao.IFtpLogDataDao;
import com.pj.ebcenter.manager.local.dao.ILocalVoucherDao;
import com.pj.ebcenter.manager.local.ftp.service.ILocalFtpTransactionService;
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
@Service("localFtpTransactionService")
public class LocalFtpTransactionServiceImpl implements ILocalFtpTransactionService {

	protected Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private ILocalVoucherDao localVoucherDao;

	@Autowired
	private IFtpLogDataDao ftpLogDataDao;

	public void insertFtpLogDataVo(FtpLogDataVo data) {
		log.debug(" Proces in LocalFtpTransactionServiceImpl.insertFtpLogDataVo method, parameter data.toString(): "
				+ data.toString());
		ftpLogDataDao.insertFtpLogDataVo(data);
	}

	/** 
	 * 方法用途: <br>
	 * 实现步骤: <br>
	 * @param date   
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void initThisBatchDB(String date, Map<LocalVoucherVo, List<LocalVoucherMerchantVo>> voucherDataMap) {
		log.debug(" Process in LocalFtpTransactionServiceImpl.initThisBatchDB mehtod, parameter date: " + date);

		// 备份历史数据
		localVoucherDao.createVoucherHistoryDataTable("S_VOUCHER_" + date, "S_VOUCHER");
		localVoucherDao.createVoucherHistoryDataTable("S_VOUCHER_MERCHANT_" + date, "S_VOUCHER_MERCHANT");

		// 清空S_VOUCHER表的数据
		localVoucherDao.truncateVoucherData("S_VOUCHER");
		localVoucherDao.truncateVoucherData("S_VOUCHER_MERCHANT");

		if (!voucherDataMap.isEmpty()) {
			for (LocalVoucherVo lvData : voucherDataMap.keySet()) {
				try {
					insertVoucherData(lvData, voucherDataMap.get(lvData));
				} catch (Exception e) {
					log.error(" happen Exception in insertVoucherData method, voucherId " + lvData.getRefVoucherId());
					// TODO write the log
				}
			}
		} else {
			log.info(" this time FTP CSV Not Record of Voucher generator, date : " + date);
		}

	}

	private void insertVoucherData(LocalVoucherVo voucherData, List<LocalVoucherMerchantVo> vmData) {

		log.debug("process in LocalFtpTransactionServiceImpl.insertVoucherData method, parameter voucherData: "
				+ voucherData.toString());

		localVoucherDao.insertVoucherData(voucherData);

		localVoucherDao.batchInsertVoucherMerchantData(vmData);
	}

}
