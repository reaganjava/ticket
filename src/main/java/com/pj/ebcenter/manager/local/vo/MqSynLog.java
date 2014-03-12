package com.pj.ebcenter.manager.local.vo;

import java.io.Serializable;
import java.util.Date;

public class MqSynLog implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 5782336453489001311L;

	/**
	 * ID
	 */
	private Integer logId;

	/**
	 * 状态
	 */
    private Integer logStatus;

    /**
	 * 时间
	 */
    private Date logDate;

    /**
	 * voucher的json对象
	 */
    private String voucher;

    /**
	 * terminalrecord的json对象
	 */
    private String terminalrecord;

    /**
     * 信息
     */
    private String message;

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Integer getLogStatus() {
        return logStatus;
    }

    public void setLogStatus(Integer i) {
        this.logStatus = i;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher == null ? null : voucher.trim();
    }

    public String getTerminalrecord() {
        return terminalrecord;
    }

    public void setTerminalrecord(String terminalrecord) {
        this.terminalrecord = terminalrecord == null ? null : terminalrecord.trim();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }
}