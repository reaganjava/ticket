package com.pj.ebcenter.manager.local.ftp.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mopon.ftp.FtpFactoryBean;
import com.mopon.service.impl.sys.BaseServiceImpl;
import com.pj.ebcenter.manager.local.ConstantInit;
import com.pj.ebcenter.manager.local.EncryptUtil;
import com.pj.ebcenter.manager.local.SystemKeyConstant;
import com.pj.ebcenter.manager.local.dao.ILocalEquipmentDao;
import com.pj.ebcenter.manager.local.ftp.service.ILocalFtpService;
import com.pj.ebcenter.manager.local.ftp.service.ILocalFtpTransactionService;
import com.pj.ebcenter.manager.local.vo.FtpLogDataVo;
import com.pj.ebcenter.manager.local.vo.LocalEquipmentVo;
import com.pj.ebcenter.manager.local.vo.LocalVoucherMerchantVo;
import com.pj.ebcenter.manager.local.vo.LocalVoucherVo;
import com.pj.ebcenter.ticket.util.DateUtils;

@Service("localFtpService")
public class LocalFtpServiceImpl extends BaseServiceImpl implements ILocalFtpService {

	protected Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private FtpFactoryBean ftpClientFacotry;

	@Autowired
	private ILocalFtpTransactionService localFtpTransactionService;

	@Autowired
	private ILocalEquipmentDao localEquipmentDao;

	private void parseCsv(File file, Map<LocalVoucherVo, List<LocalVoucherMerchantVo>> voucherData) throws IOException,
			ParseException {
		BufferedReader bufferdReader = null;
		if (file != null && file.exists() && file.isFile()) {
			try {
				bufferdReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "GBK"));

				// 剔除掉CSV文件的标题
				bufferdReader.readLine();
				String strTem = "";
				int row = 1;
				while ((strTem = bufferdReader.readLine()) != null) {
					if (strTem == null || strTem.trim().length() < 1) {
						break;
					}
					String[] csvData = strTem.split(",");

					log.debug("csv data: " + strTem);
					LocalVoucherVo tempData = new LocalVoucherVo();
					List<LocalVoucherMerchantVo> vmData = new ArrayList<>();

					try {
						adapterdata(csvData, tempData, vmData);
					} catch (Exception e) {
						e.printStackTrace();

						try {
							FtpLogDataVo data = new FtpLogDataVo();
							data.setCsvData(strTem);
							data.setCsvRow(row);
							data.setFtpFilePath(file.getPath());
							data.setOperateTime(new Timestamp(System.currentTimeMillis()));
							localFtpTransactionService.insertFtpLogDataVo(data);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
					row++;

					voucherData.put(tempData, vmData);
				}
				log.debug("readfile:" + file);
			} catch (IOException e) {
				log.error(" in LocalFtpServiceImpl.parseCsv method ", e);
				throw e;
			} finally {
				try {
					bufferdReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/** 
	 * 方法用途: <br>
	 * 实现步骤: <br>
	 * @param csvData
	 * @param tempData
	 * @throws ParseException   
	 */
	private void adapterdata(String[] csvData, LocalVoucherVo tempData, List<LocalVoucherMerchantVo> vmData)
			throws ParseException {

		String desKey = ConstantInit.configMap.get(SystemKeyConstant.LOCAL_JSON_DES_KEY);
		// "订单号,凭证号,凭证ID,凭证值,证件号,商品ID,商品名称,景区ID,景区ID,是否套票,"

		tempData.setOrderId(csvData[0]);
		tempData.setRefVoucherNo(Long.parseLong(csvData[1]));
		tempData.setRefVoucherId(csvData[2]);
		tempData.setVoucherValue(csvData[3]);
		tempData.setCertificateNum(csvData[4]);
		tempData.setGoodsId(csvData[5]);
		tempData.setGoodsName(csvData[6]);
		tempData.setScenicSpotId(csvData[7]);
		tempData.setScenicSpotName(csvData[8]);
		tempData.setIsPackage(Integer.parseInt(csvData[9]));

		// "套票ID,已验证次数,凭证最大使用次数,作废的数量,冻结数量,凭证状态,是否打印入园凭票,使用时间,有效期开始时间,有效期结束时间,"
		tempData.setPackageId(csvData[10]);
		tempData.setValidateTime((csvData[11] == null || "".equals(csvData[11])) ? null : Integer.parseInt(csvData[11]));
		tempData.setMaxUseTimes(Integer.parseInt(csvData[12]));
		tempData.setCancelNum(Integer.parseInt(csvData[13]));
		tempData.setFreezeNum(Integer.parseInt(csvData[14]));
		tempData.setStatus(Integer.parseInt(csvData[15]));
		tempData.setIsTicket(Integer.parseInt(csvData[16]));
		tempData.setUseTime((csvData[16] == null || "".equals(csvData[17])) ? null : new Timestamp(DateUtils.format(
				csvData[17], "yyyy-MM-dd HH:mm:ss").getTime()));
		tempData.setStartDate((csvData[18] == null || "".equals(csvData[18])) ? null : DateUtils.format(csvData[18],
				"yyyy-MM-dd"));
		tempData.setEndDate((csvData[19] == null || "".equals(csvData[19])) ? null : DateUtils.format(csvData[19],
				"yyyy-MM-dd"));

		// "开始时间的分钟数,结束时间的分钟数,是否二次验证,指定门票星期几有效,指定在门票有效期内不能使用的时间,消费区域";
		tempData.setStartExpAllowTime(csvData[20]);
		tempData.setEndExpAllowTime(csvData[21]);
		tempData.setIsSecondValid(Integer.parseInt(csvData[22]));

		log.debug(" csvData[23] [" + csvData[23] + "], [" + csvData[24] + "], [" + csvData[25] + "]"+",["+csvData[26]+"],["+csvData[27]+"]");
		tempData.setExpDayOfWeek(csvData[23] == null || "".equals(csvData[23]) ? null : EncryptUtil.DES3Decrypt(
				EncryptUtil.Base64DecodeInLine(csvData[23]), desKey));

		tempData.setExpExceptionData((csvData[24] == null || "".equals(csvData[24])) ? null : EncryptUtil.DES3Decrypt(
				EncryptUtil.Base64DecodeInLine(csvData[24]), desKey));

		tempData.setPrice(new BigDecimal(csvData[25]));
		tempData.setSupplierSettlementPrice(new BigDecimal(csvData[26]));
		
		String jsonObject = ((csvData[27] == null || "".equals(csvData[27])) ? null : EncryptUtil.DES3Decrypt(
				EncryptUtil.Base64DecodeInLine(csvData[27]), desKey));

		log.debug(" jsonObject: " + jsonObject);

		if (jsonObject != null && !"".equals(jsonObject) && !"[null]".equals(jsonObject)) {
			JSONArray t = JSONArray.fromObject(jsonObject);

			for (int i = 0; i < t.size(); i++) {
				LocalVoucherMerchantVo st = (LocalVoucherMerchantVo) JSONObject.toBean((JSONObject) t.get(i),
						LocalVoucherMerchantVo.class);
				vmData.add(st);
			}
		}
	}

	@Override
	public void getVoucherDataFromTtp(String ftpAbsultePath) {

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		FTPClient ftpClient = ftpClientFacotry.getFtpConnection();
		try {

			ftpClient.changeWorkingDirectory(ftpAbsultePath);

			String downLoadFileName = downloadFile(ftpAbsultePath,
					ConstantInit.configMap.get(SystemKeyConstant.LOCAL_SCENIC_CODE) + ".csv",
					ConstantInit.configMap.get(SystemKeyConstant.DOWN_LOAD_FILE_PATH), ftpClient);

			Map<LocalVoucherVo, List<LocalVoucherMerchantVo>> voucherData = new HashMap<>();

			parseCsv(new File(downLoadFileName), voucherData);

			// LocalVoucherVo vo = voucherData.keySet().iterator().next();
			//
			// log.debug("===" + vo.toString());
			//
			// log.debug("====" + voucherData.get(vo).get(0));

			localFtpTransactionService.initThisBatchDB(ftpAbsultePath, voucherData);

		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
	}

	public static void main(String[] args) throws IOException {
		// LocalFtpServiceImpl ftpTransactionServiceImpl = new LocalFtpServiceImpl();
		// FtpFactoryBean ftpFactoryBean = new FtpFactoryBean("data.mopon.cn", 2322, "/resouce_test/local", "tongbiao",
		// "861206");
		// FTPClient ftp = null;
		// ftp = ftpFactoryBean.getFtpConnection();
		//
		// ftp.changeWorkingDirectory("20140120");
		//
		// String saveFileName = "D:\\test\\down" + File.separator + "20140120" + File.separator + "JQ000009.csv";
		//
		//
		// ftpTransactionServiceImpl.downloadFile("20140120", "JQ000009.csv", "D:\\test\\down", ftp);

	}

	private String downloadFile(String absultePath, String filename, String savePath, FTPClient ftpClient)
			throws IOException {

		log.debug(" Process in downLoadFile method, parameter absultePath: " + absultePath + ", filename: " + filename
				+ ", savePath: " + savePath);

		String saveFilePath = savePath + File.separator + absultePath + File.separator + filename;

		// 定义文件的输出流

		FileOutputStream outStream = null;
		try {

			File file = new File(savePath + File.separator + absultePath);

			if (!file.isDirectory()) {
				file.mkdirs();
			}

			outStream = new FileOutputStream(saveFilePath);

			ftpClient.retrieveFile(filename, outStream);

			return saveFilePath;
		} catch (IOException ioe) {
			log.error(" in LocalFtpServiceImpl.downloadFile method happen IOException ", ioe);
			throw ioe;
		} finally {
			try {
				if (outStream != null) {
					outStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	/** 
	 * 方法用途: <br>
	 * 实现步骤: <br>
	 * @param data   
	 */
	@Override
	public void saveLocalEquipmentVo(List<LocalEquipmentVo> data) {

		log.debug(" Process in LocalFtpServiceImpl.saveLocalEquinment method ");

		try {
			List<String> ids = new ArrayList<>();

			for (LocalEquipmentVo vo : data) {
				ids.add(vo.getEquipmentId());
			}

			// 查找通不过来的设备信息在本地服务端存在的数据
			List<LocalEquipmentVo> existData = localEquipmentDao.findLocalEquimentById(ids);

			Map<String, LocalEquipmentVo> existMap = adapter(existData);

			for (LocalEquipmentVo vo : data) {
				if (existMap.containsKey(vo.getEquipmentId())) {
					localEquipmentDao.updateLocalEquiment(vo);
				} else {
					localEquipmentDao.saveLocalEquipment(vo);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Map<String, LocalEquipmentVo> adapter(List<LocalEquipmentVo> data) {

		Map<String, LocalEquipmentVo> res = new HashMap<>();

		for (LocalEquipmentVo vo : data) {
			res.put(vo.getEquipmentId(), vo);
		}

		return res;
	}
}
