package com.pj.ebcenter.manager.local.vo;

import java.sql.Timestamp;

/**
 * <p>Description: </p>
 * @date 2014年1月20日
 * @author 王方威
 * @version 1.0
 * <p>Company:Mopon</p>
 * <p>Copyright:Copyright(c)2013</p>
 */
public class FtpLogDataVo {

	/**
	 * ID 
	 */
	private String id;

	/**
	 * csv文件的行的内容
	 */
	private String csvData;

	/**
	 * CSV文件的行数
	 */
	private int csvRow;

	/**
	 * FTP的文件全路径
	 */
	private String ftpFilePath;

	/**
	 * 本地下载FTP的文件全路径
	 */
	private String localFilePath;

	/**
	 * 处理时间
	 */
	private Timestamp operateTime;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the csvData
	 */
	public String getCsvData() {
		return csvData;
	}

	/**
	 * @param csvData the csvData to set
	 */
	public void setCsvData(String csvData) {
		this.csvData = csvData;
	}

	/**
	 * @return the csvRow
	 */
	public int getCsvRow() {
		return csvRow;
	}

	/**
	 * @param csvRow the csvRow to set
	 */
	public void setCsvRow(int csvRow) {
		this.csvRow = csvRow;
	}

	/**
	 * @return the ftpFilePath
	 */
	public String getFtpFilePath() {
		return ftpFilePath;
	}

	/**
	 * @param ftpFilePath the ftpFilePath to set
	 */
	public void setFtpFilePath(String ftpFilePath) {
		this.ftpFilePath = ftpFilePath;
	}

	/**
	 * @return the localFilePath
	 */
	public String getLocalFilePath() {
		return localFilePath;
	}

	/**
	 * @param localFilePath the localFilePath to set
	 */
	public void setLocalFilePath(String localFilePath) {
		this.localFilePath = localFilePath;
	}

	/**
	 * @return the operateTime
	 */
	public Timestamp getOperateTime() {
		return operateTime;
	}

	/**
	 * @param operateTime the operateTime to set
	 */
	public void setOperateTime(Timestamp operateTime) {
		this.operateTime = operateTime;
	}

	/** 
	 * 方法用途: <br>
	 * 实现步骤: <br>
	 * @return   
	 */
	@Override
	public String toString() {
		return "FtpLogDataVo [id=" + id + ", csvData=" + csvData + ", csvRow=" + csvRow + ", ftpFilePath="
				+ ftpFilePath + ", localFilePath=" + localFilePath + ", operateTime=" + operateTime + "]";
	}

}
