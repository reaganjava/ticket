package com.pj.ebcenter.manager.local.vo;

import java.util.Date;

/**
 * 
 * <p>Description: </p>
 * @date 2014年1月20日
 * @author 王丽松
 * @version 1.0
 * <p>Company:Mopon</p>
 * <p>Copyright:Copyright(c)2013</p>
 */
public class MqCache {

	/**
	 * ID
	 */
	private Integer mqTaskId;

	/**
	 * 凭证号
	 */
    private Long vourcherNo;

	/**
	 * 出票记录编号
	 */
    private Integer terminalRecordId;
	
	/**
	 * 要查询的对应表名
	 */
	private String queryTable;

	/**
	 * 删除标记：0:已删除 1：新增
	 */
	private Integer delFlag;
	
	/**
	 * 记录时间
	 */
	private Date datatime;
	
	/**
	 * 信息
	 */
	private String message;

	public Integer getMqTaskId() {
		return mqTaskId;
	}

	public void setMqTaskId(Integer mqTaskId) {
		this.mqTaskId = mqTaskId;
	}

	public Long getVourcherNo() {
		return vourcherNo;
	}

	public void setVourcherNo(Long vourcherNo) {
		this.vourcherNo = vourcherNo;
	}

	public Integer getTerminalRecordId() {
		return terminalRecordId;
	}

	public void setTerminalRecordId(Integer terminalRecordId) {
		this.terminalRecordId = terminalRecordId;
	}

	public String getQueryTable() {
		return queryTable;
	}

	public void setQueryTable(String queryTable) {
		this.queryTable = queryTable == null ? null : queryTable.trim();
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	public Date getDatatime() {
		return datatime;
	}

	public void setDatatime(Date datatime) {
		this.datatime = datatime;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message == null ? null : message.trim();
	}
}