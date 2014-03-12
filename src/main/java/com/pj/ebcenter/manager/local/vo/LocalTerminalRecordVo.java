package com.pj.ebcenter.manager.local.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class LocalTerminalRecordVo implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -4524273124608373428L;

	private Integer terminalRecordId;

    private String recordChannel;

    private String voucherValue;

    private String tradeNum;

    private BigDecimal totalPrice;

    private Integer printTimes;

    private BigDecimal allSettlementPrice;

    private String terminalNum;

    private String orderNum;

    private String goodsId;

    private String goodsName;

    private String merchantId;

    private String merchantName;

    private String scenicSpotId;

    private String scenicSpotName;

    private Date useTime;

    private Byte checkingType;

    private String batchNo;

    private Byte needSendVerifyMsg;

    private Date createTime;

    public Integer getTerminalRecordId() {
        return terminalRecordId;
    }

    public void setTerminalRecordId(Integer terminalRecordId) {
        this.terminalRecordId = terminalRecordId;
    }

    public String getRecordChannel() {
        return recordChannel;
    }

    public void setRecordChannel(String recordChannel) {
        this.recordChannel = recordChannel == null ? null : recordChannel.trim();
    }

    public String getVoucherValue() {
        return voucherValue;
    }

    public void setVoucherValue(String voucherValue) {
        this.voucherValue = voucherValue == null ? null : voucherValue.trim();
    }

    public String getTradeNum() {
        return tradeNum;
    }

    public void setTradeNum(String tradeNum) {
        this.tradeNum = tradeNum == null ? null : tradeNum.trim();
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getPrintTimes() {
        return printTimes;
    }

    public void setPrintTimes(Integer printTimes) {
        this.printTimes = printTimes;
    }

    public BigDecimal getAllSettlementPrice() {
        return allSettlementPrice;
    }

    public void setAllSettlementPrice(BigDecimal allSettlementPrice) {
        this.allSettlementPrice = allSettlementPrice;
    }

    public String getTerminalNum() {
        return terminalNum;
    }

    public void setTerminalNum(String terminalNum) {
        this.terminalNum = terminalNum == null ? null : terminalNum.trim();
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum == null ? null : orderNum.trim();
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId == null ? null : merchantId.trim();
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName == null ? null : merchantName.trim();
    }

    public String getScenicSpotId() {
        return scenicSpotId;
    }

    public void setScenicSpotId(String scenicSpotId) {
        this.scenicSpotId = scenicSpotId == null ? null : scenicSpotId.trim();
    }

    public String getScenicSpotName() {
        return scenicSpotName;
    }

    public void setScenicSpotName(String scenicSpotName) {
        this.scenicSpotName = scenicSpotName == null ? null : scenicSpotName.trim();
    }

    public Date getUseTime() {
        return useTime;
    }

    public void setUseTime(Date useTime) {
        this.useTime = useTime;
    }

    public Byte getCheckingType() {
        return checkingType;
    }

    public void setCheckingType(Byte checkingType) {
        this.checkingType = checkingType;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo == null ? null : batchNo.trim();
    }

    public Byte getNeedSendVerifyMsg() {
        return needSendVerifyMsg;
    }

    public void setNeedSendVerifyMsg(Byte needSendVerifyMsg) {
        this.needSendVerifyMsg = needSendVerifyMsg;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	/** 
	 * 方法用途: <br>
	 * 实现步骤: <br>
	 * @return   
	 */
	@Override
	public String toString() {
		return "LocalTerminalRecordVo [terminalRecordId=" + terminalRecordId + ", recordChannel=" + recordChannel
				+ ", voucherValue=" + voucherValue + ", tradeNum=" + tradeNum + ", totalPrice=" + totalPrice
				+ ", printTimes=" + printTimes + ", allSettlementPrice=" + allSettlementPrice + ", terminalNum="
				+ terminalNum + ", orderNum=" + orderNum + ", goodsId=" + goodsId + ", goodsName=" + goodsName
				+ ", merchantId=" + merchantId + ", merchantName=" + merchantName + ", scenicSpotId=" + scenicSpotId
				+ ", scenicSpotName=" + scenicSpotName + ", useTime=" + useTime + ", checkingType=" + checkingType
				+ ", batchNo=" + batchNo + ", needSendVerifyMsg=" + needSendVerifyMsg + ", createTime=" + createTime
				+ "]";
	}
    
    
}