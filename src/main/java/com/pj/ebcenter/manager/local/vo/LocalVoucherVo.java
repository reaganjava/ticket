package com.pj.ebcenter.manager.local.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

//import com.pj.ebcenter.manager.local.EncryptUtil;
//import com.pj.ebcenter.manager.pub.constant.ConstantInit;
//import com.pj.ebcenter.manager.pub.constant.SystemKeyConstant;
//import com.pj.ebcenter.manager.util.DateUtils;

public class LocalVoucherVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5470509950067475688L;
	/**
	 * 订单业务ID
	 */
	private String orderId;
	/**
	 * 关联S_VOUCHER的VOUCHER_NO
	 */
	private Long refVoucherNo;
	/**
	 * 关联S_VOUCHER的VOUCHER_ID凭证序号
	 */
	private String refVoucherId;
	/**
	 * 凭证值
	 */
	private String voucherValue;
	/**
	 * 证件号
	 */
	private String certificateNum;
	/**
	 * 商品ID
	 */
	private String goodsId;
	/**
	 * 商品名称
	 */
	private String goodsName;
	/**
	 * 景区ID
	 */
	private String scenicSpotId;
	/**
	 * 景区名称
	 */
	private String scenicSpotName;
	/**
	 * 是否套票，0否1是2子商品
	 */
	private Integer isPackage;
	/**
	 * 套票ID
	 */
	private String packageId;
	/**
	 * 已验证次数
	 */
	private Integer validateTime;
	/**
	 * 凭证最大使用次数
	 */
	private Integer maxUseTimes;
	/**
	 * 作废的数量
	 */
	private Integer cancelNum;
	/**
	 * 冻结数量，冻结数量为0表示未冻结
	 */
	private Integer freezeNum;
	/**
	 * 凭证状态  0:未生效 1.未使用  2.已使用  ,3:已作废 4：过期可退 5:过期退款 ,6:改期 7.部分使用
	 */
	private Integer status;
	/**
	 * 是否打印入园凭票.1.已出 2.未出
	 */
	private Integer isTicket;
	/**
	 * 凭证使用时间
	 */
	private Timestamp useTime;
	/**
	 * 凭证有效期开始时间
	 */
	private Date startDate;
	/**
	 * 凭证有效期结束时间
	 */
	private Date endDate;
	/**
	 * 开始时间 存的是时间的分钟数 允许门票在一天哪个时间段消费,0表示0点0分
	 */
	private String startExpAllowTime;
	/**
	 * 结束时间 存的是时间的分钟数 允许门票在一天哪个时间段消费 1440表示24:00分
	 */
	private String endExpAllowTime;
	/**
	 * 是否二次验证 0:否 1:是
	 */
	private Integer isSecondValid;

	/**
	 * 指定门票星期几有效，0全部，（1,2,5）表示周1周2周5
	 */
	private String expDayOfWeek;
	/**
	 * 指定在门票有效期内不能使用的时间
	 */
	private String expExceptionData;
	
	/**
	 * 真实售价
	 */
	private BigDecimal price;
	
	/**
	 * 供应商结算价
	 */
	private BigDecimal supplierSettlementPrice;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Long getRefVoucherNo() {
		return refVoucherNo;
	}

	public void setRefVoucherNo(Long refVoucherNo) {
		this.refVoucherNo = refVoucherNo;
	}

	public String getRefVoucherId() {
		return refVoucherId;
	}

	public void setRefVoucherId(String refVoucherId) {
		this.refVoucherId = refVoucherId;
	}

	public String getVoucherValue() {
		return voucherValue;
	}

	public void setVoucherValue(String voucherValue) {
		this.voucherValue = voucherValue;
	}

	public String getCertificateNum() {
		return certificateNum;
	}

	public void setCertificateNum(String certificateNum) {
		this.certificateNum = certificateNum;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getScenicSpotId() {
		return scenicSpotId;
	}

	public void setScenicSpotId(String scenicSpotId) {
		this.scenicSpotId = scenicSpotId;
	}

	public String getScenicSpotName() {
		return scenicSpotName;
	}

	public void setScenicSpotName(String scenicSpotName) {
		this.scenicSpotName = scenicSpotName;
	}

	public Integer getIsPackage() {
		return isPackage;
	}

	public void setIsPackage(Integer isPackage) {
		this.isPackage = isPackage;
	}

	public String getPackageId() {
		return packageId;
	}

	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}

	public Integer getValidateTime() {
		return validateTime;
	}

	public void setValidateTime(Integer validateTime) {
		this.validateTime = validateTime;
	}

	public Integer getMaxUseTimes() {
		return maxUseTimes;
	}

	public void setMaxUseTimes(Integer maxUseTimes) {
		this.maxUseTimes = maxUseTimes;
	}

	public Integer getCancelNum() {
		return cancelNum;
	}

	public void setCancelNum(Integer cancelNum) {
		this.cancelNum = cancelNum;
	}

	public Integer getFreezeNum() {
		return freezeNum;
	}

	public void setFreezeNum(Integer freezeNum) {
		this.freezeNum = freezeNum;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getIsTicket() {
		return isTicket;
	}

	public void setIsTicket(Integer isTicket) {
		this.isTicket = isTicket;
	}

	public Timestamp getUseTime() {
		return useTime;
	}

	public void setUseTime(Timestamp useTime) {
		this.useTime = useTime;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getStartExpAllowTime() {
		return startExpAllowTime;
	}

	public void setStartExpAllowTime(String startExpAllowTime) {
		this.startExpAllowTime = startExpAllowTime;
	}

	public String getEndExpAllowTime() {
		return endExpAllowTime;
	}

	public void setEndExpAllowTime(String endExpAllowTime) {
		this.endExpAllowTime = endExpAllowTime;
	}

	public Integer getIsSecondValid() {
		return isSecondValid;
	}

	public void setIsSecondValid(Integer isSecondValid) {
		this.isSecondValid = isSecondValid;
	}

	public String getExpDayOfWeek() {
		return expDayOfWeek;
	}

	public void setExpDayOfWeek(String expDayOfWeek) {
		this.expDayOfWeek = expDayOfWeek;
	}

	public String getExpExceptionData() {
		return expExceptionData;
	}

	public void setExpExceptionData(String expExceptionData) {
		this.expExceptionData = expExceptionData;
	}


	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * @return the supplierSettlementPrice
	 */
	public BigDecimal getSupplierSettlementPrice() {
		return supplierSettlementPrice;
	}

	/**
	 * @param supplierSettlementPrice the supplierSettlementPrice to set
	 */
	public void setSupplierSettlementPrice(BigDecimal supplierSettlementPrice) {
		this.supplierSettlementPrice = supplierSettlementPrice;
	}

	/** 
	 * 方法用途: <br>
	 * 实现步骤: <br>
	 * @return   
	 */
	@Override
	public String toString() {
		return "LocalVoucherVo [orderId=" + orderId + ", refVoucherNo=" + refVoucherNo + ", refVoucherId="
				+ refVoucherId + ", voucherValue=" + voucherValue + ", certificateNum=" + certificateNum + ", goodsId="
				+ goodsId + ", goodsName=" + goodsName + ", scenicSpotId=" + scenicSpotId + ", scenicSpotName="
				+ scenicSpotName + ", isPackage=" + isPackage + ", packageId=" + packageId + ", validateTime="
				+ validateTime + ", maxUseTimes=" + maxUseTimes + ", cancelNum=" + cancelNum + ", freezeNum="
				+ freezeNum + ", status=" + status + ", isTicket=" + isTicket + ", useTime=" + useTime + ", startDate="
				+ startDate + ", endDate=" + endDate + ", startExpAllowTime=" + startExpAllowTime
				+ ", endExpAllowTime=" + endExpAllowTime + ", isSecondValid=" + isSecondValid + ", expDayOfWeek="
				+ expDayOfWeek + ", expExceptionData=" + expExceptionData + ", price=" + price
				+ ", supplierSettlementPrice=" + supplierSettlementPrice + "]";
	}

}
