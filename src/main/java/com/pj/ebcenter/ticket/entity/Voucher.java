package com.pj.ebcenter.ticket.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * <p>Description: 凭证表实体类</p>
 * @date 2013年10月16日
 * @author 蒋伟
 * @version 1.0
 * <p>Company:Mopon</p>
 * <p>Copyright:Copyright(c)2013</p>
 */
public class Voucher {

	/**
	 * 凭证序号
	 */
	private Long voucherNo;
	
	/**
	 * 凭证序号
	 */
	private String voucherId;
	
	/**
	 * 订单ID
	 */
	private String orderId;
	
	/**
	 * 订单ID
	 */
	private Integer orderType;
	
	/**
	 * 是否套票，0否1是
	 */
	private Integer isPackage;
	
	/**
	 * 套票ID
	 */
	private String packageId;
	
	/**
	 * 商品ID
	 */
	private String goodsId;
	
	/**
	 * 商品名称
	 */
	private String goodsName;
	
	/**
	 * 商品类型
	 */
	private Integer goodsTypeId;
	
	/**
	 * 渠道类型
	 */
	private Integer channelType;
	
	/**
	 * 渠道商ID
	 */
	private String instChannelId;
	
	/**
	 * 渠道商名称
	 */
	private String channelName;
	
	/**
	 * 商品市场价
	 */
	private BigDecimal listPrice;
	
	/**
	 * 真实售价
	 */
	private BigDecimal price;
	
	/**
	 * 供应商结算价
	 */
	private BigDecimal supplierSettlementPrice;
	
	/**
	 * 发送手机
	 */
	private String sendMobile;
	
	/**
	 * 凭证最大使用次数
	 */
	private Integer maxUseTimes;
	
	/**
	 * 已验证次数
	 */
	private Integer validateTimes;
	
	/**
	 * 作废的数量
	 */
	private Integer cancelNum;
	
	/**
	 * 短信发送次数
	 */
	private Integer smsCount;
	
	/**
	 * 凭证状态   2.未使用  4.已使用  ,6:已作废 7：过期可退 8:过期退款 ,9:改期 
	 */
	private Integer status;
	
	/**
	 * 冻结数量，冻结数量为0表示未冻结
	 */
	private Integer freezeNum;
	
	/**
	 * 是否打印入园凭票.1.已出 2.未出
	 */
	private Integer isTicket;
	
	/**
	 * 创建时间
	 */
	private Timestamp createTime;
	
	/**
	 * 凭证使用时间
	 */
	private Timestamp useTime;
	
	/**
	 * 凭证发送时间
	 */
	private Timestamp sendTime;
	
	/**
	 * 凭证有效期开始时间
	 */
	private Date startDate;
	
	/**
	 * 凭证有效期结束时间
	 */
	private Date endDate;
	
	/**
	 * 证件号
	 */
	private String certificateNum;
	
	
	/**
	 * 凭证值（接口产生）
	 */
	private String voucherValue;
	
	/**
	 * 凭证图片地址
	 */
	private String voucherImageUrl;
	
	/**
	 * 用户号
	 */
	private Long userId;
	
	/**
	 * 用户号
	 */
	private String invalidDesc;
	
	/**
	 * 修改凭证有效期开始时间
	 */
	private Timestamp changeStartDate;
	
	/**
	 * 修改凭证有效期结束时间
	 */
	private Timestamp changeEndDate;
	
	/**
	 * 景区ID
	 */
	private String scenicSpotId;
	
	/**
	 * 景区名称
	 */
	private String scenicSpotName;
	
	/**
	 * 供应商ID 
	 */
	private Long supplierId;
	/**
	 * 开始时间 存的是时间的分钟数
	 * **/
	private String startExpAllowTime; 
	/**
	 * 结束时间
	 * **/
	private String endExpAllowTime;
	/**
	 * 是否二次验证 0:否 1:是
	 * **/
	private Integer isSeondValid;
	/**
	 * 重打印次数
	 * ***/
	private Integer reprintTimes;
	public String getExpExceptionDate() {
		return expExceptionDate;
	}

	public void setExpExceptionDate(String expExceptionDate) {
		this.expExceptionDate = expExceptionDate;
	}

	public String getExpDayOfWeek() {
		return expDayOfWeek;
	}

	public void setExpDayOfWeek(String expDayOfWeek) {
		this.expDayOfWeek = expDayOfWeek;
	}


	/**
	 * 指定在门票有效期内不能使用的时间
	 * **/
	private String expExceptionDate;
	/**
	 * 指定门票星期几有效
	 * **/
	private String expDayOfWeek;
	public Integer getReprintTimes() {
		return reprintTimes;
	}

	public void setReprintTimes(Integer reprintTimes) {
		this.reprintTimes = reprintTimes;
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

	public Integer getIsSeondValid() {
		return isSeondValid;
	}

	public void setIsSeondValid(Integer isSeondValid) {
		this.isSeondValid = isSeondValid;
	}

	
	private List<VoucherMerchant> voucherMerchant = new ArrayList<VoucherMerchant>();

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
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

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public Integer getChannelType() {
		return channelType;
	}

	public void setChannelType(Integer channelType) {
		this.channelType = channelType;
	}


	public String getInstChannelId() {
		return instChannelId;
	}

	public void setInstChannelId(String instChannelId) {
		this.instChannelId = instChannelId;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public BigDecimal getListPrice() {
		return listPrice;
	}

	public void setListPrice(BigDecimal listPrice) {
		this.listPrice = listPrice;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getSupplierSettlementPrice() {
		return supplierSettlementPrice;
	}

	public void setSupplierSettlementPrice(BigDecimal supplierSettlementPrice) {
		this.supplierSettlementPrice = supplierSettlementPrice;
	}

	public String getSendMobile() {
		return sendMobile;
	}

	public void setSendMobile(String sendMobile) {
		this.sendMobile = sendMobile;
	}

	public Integer getMaxUseTimes() {
		return maxUseTimes;
	}

	public void setMaxUseTimes(Integer maxUseTimes) {
		this.maxUseTimes = maxUseTimes;
	}

	public Integer getValidateTimes() {
		return validateTimes;
	}

	public void setValidateTimes(Integer validateTimes) {
		this.validateTimes = validateTimes;
	}

	public Integer getCancelNum() {
		return cancelNum;
	}

	public void setCancelNum(Integer cancelNum) {
		this.cancelNum = cancelNum;
	}

	public Integer getSmsCount() {
		return smsCount;
	}

	public void setSmsCount(Integer smsCount) {
		this.smsCount = smsCount;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getFreezeNum() {
		return freezeNum;
	}

	public void setFreezeNum(Integer freezeNum) {
		this.freezeNum = freezeNum;
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

	public Timestamp getSendTime() {
		return sendTime;
	}

	public void setSendTime(Timestamp sendTime) {
		this.sendTime = sendTime;
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


	public String getCertificateNum() {
		return certificateNum;
	}

	public void setCertificateNum(String certificateNum) {
		this.certificateNum = certificateNum;
	}

	public String getVoucherValue() {
		return voucherValue;
	}

	public void setVoucherValue(String voucherValue) {
		this.voucherValue = voucherValue;
	}

	public String getVoucherImageUrl() {
		return voucherImageUrl;
	}

	public void setVoucherImageUrl(String voucherImageUrl) {
		this.voucherImageUrl = voucherImageUrl;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getInvalidDesc() {
		return invalidDesc;
	}

	public void setInvalidDesc(String invalidDesc) {
		this.invalidDesc = invalidDesc;
	}

	public Timestamp getChangeStartDate() {
		return changeStartDate;
	}

	public void setChangeStartDate(Timestamp changeStartDate) {
		this.changeStartDate = changeStartDate;
	}

	public Timestamp getChangeEndDate() {
		return changeEndDate;
	}

	public void setChangeEndDate(Timestamp changeEndDate) {
		this.changeEndDate = changeEndDate;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Long getVoucherNo() {
		return voucherNo;
	}

	public void setVoucherNo(Long voucherNo) {
		this.voucherNo = voucherNo;
	}

	public String getVoucherId() {
		return voucherId;
	}

	public void setVoucherId(String voucherId) {
		this.voucherId = voucherId;
	}

	public List<VoucherMerchant> getVoucherMerchant() {
		return voucherMerchant;
	}

	public void setVoucherMerchant(List<VoucherMerchant> voucherMerchant) {
		this.voucherMerchant = voucherMerchant;
	}

	public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Integer getGoodsTypeId() {
		return goodsTypeId;
	}

	public void setGoodsTypeId(Integer goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
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

	public void setScenicName(String scenicSpotName) {
		this.scenicSpotName = scenicSpotName;
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}


	public void setScenicSpotName(String scenicSpotName) {
		this.scenicSpotName = scenicSpotName;
	}

	
	
}
