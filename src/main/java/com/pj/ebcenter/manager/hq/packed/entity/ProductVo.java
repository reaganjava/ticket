package com.pj.ebcenter.manager.hq.packed.entity;

import java.sql.Timestamp;

/**
 * <p>Copyright:Copyright(c)2012</p>
 * <p>Company:Mopon</p>
 * @date 2013年11月22日
 * @author 王方威
 * @version 1.0
 */
public class ProductVo {

	/**
	 * 线下系统的账号
	 */
	private String refProductId;

	/**
	 * 线下商品的名称
	 */
	private String refProductName;

	/**
	 * 最大购买数量
	 */
	private Integer refLimitCount;

	/**
	 * 商品可购买开始时间 格式：  yyyy-MM-dd
	 */
	private Timestamp refValidityBuyStart;

	/**
	 * 商品可购买结束时间 格式：  yyyy-MM-dd
	 */
	private Timestamp refValidityBuyEnd;

	/**
	 * 商品有效期开始时间 格式：  yyyy-MM-dd
	 */
	private Timestamp refValidityStart;

	/**
	 * 商品有效期结束时间 格式：  yyyy-MM-dd
	 */
	private Timestamp refValidityEnd;

	/**
	 * 商品有效期说明
	 */
	private String refValidityDesc;

	/**
	 * 商品说明
	 */
	private String refDescription;

	/**
	 * 游客提示
	 */
	private String refGuestPrompt;

	/**
	 * 门市价
	 */
	private String refMarketPrice;

	/**
	 * 建议零售价
	 */
	private String refSalesPrice;

	/**
	 * 可消费区域
	 */
	private String refConsumeArea;

	/**
	 * @return the refProductId
	 */
	public String getRefProductId() {
		return refProductId;
	}

	/**
	 * @param refProductId the refProductId to set
	 */
	public void setRefProductId(String refProductId) {
		this.refProductId = refProductId;
	}

	/**
	 * @return the refProductName
	 */
	public String getRefProductName() {
		return refProductName;
	}

	/**
	 * @param refProductName the refProductName to set
	 */
	public void setRefProductName(String refProductName) {
		this.refProductName = refProductName;
	}

	/**
	 * @return the refValidityDesc
	 */
	public String getRefValidityDesc() {
		return refValidityDesc;
	}

	/**
	 * @param refValidityDesc the refValidityDesc to set
	 */
	public void setRefValidityDesc(String refValidityDesc) {
		this.refValidityDesc = refValidityDesc;
	}

	/**
	 * @return the refDescription
	 */
	public String getRefDescription() {
		return refDescription;
	}

	/**
	 * @param refDescription the refDescription to set
	 */
	public void setRefDescription(String refDescription) {
		this.refDescription = refDescription;
	}

	/**
	 * @return the refGuestPrompt
	 */
	public String getRefGuestPrompt() {
		return refGuestPrompt;
	}

	/**
	 * @param refGuestPrompt the refGuestPrompt to set
	 */
	public void setRefGuestPrompt(String refGuestPrompt) {
		this.refGuestPrompt = refGuestPrompt;
	}

	/**
	 * @return the refMarketPrice
	 */
	public String getRefMarketPrice() {
		return refMarketPrice;
	}

	/**
	 * @param refMarketPrice the refMarketPrice to set
	 */
	public void setRefMarketPrice(String refMarketPrice) {
		this.refMarketPrice = refMarketPrice;
	}

	/**
	 * @return the refSalesPrice
	 */
	public String getRefSalesPrice() {
		return refSalesPrice;
	}

	/**
	 * @param refSalesPrice the refSalesPrice to set
	 */
	public void setRefSalesPrice(String refSalesPrice) {
		this.refSalesPrice = refSalesPrice;
	}

	/**
	 * @return the refConsumeArea
	 */
	public String getRefConsumeArea() {
		return refConsumeArea;
	}

	/**
	 * @param refConsumeArea the refConsumeArea to set
	 */
	public void setRefConsumeArea(String refConsumeArea) {
		this.refConsumeArea = refConsumeArea;
	}

	public Integer getRefLimitCount() {
		return refLimitCount;
	}

	public void setRefLimitCount(Integer refLimitCount) {
		this.refLimitCount = refLimitCount;
	}

	public Timestamp getRefValidityBuyStart() {
		return refValidityBuyStart;
	}

	public void setRefValidityBuyStart(Timestamp refValidityBuyStart) {
		this.refValidityBuyStart = refValidityBuyStart;
	}

	public Timestamp getRefValidityBuyEnd() {
		return refValidityBuyEnd;
	}

	public void setRefValidityBuyEnd(Timestamp refValidityBuyEnd) {
		this.refValidityBuyEnd = refValidityBuyEnd;
	}

	public Timestamp getRefValidityStart() {
		return refValidityStart;
	}

	public void setRefValidityStart(Timestamp refValidityStart) {
		this.refValidityStart = refValidityStart;
	}

	public Timestamp getRefValidityEnd() {
		return refValidityEnd;
	}

	public void setRefValidityEnd(Timestamp refValidityEnd) {
		this.refValidityEnd = refValidityEnd;
	}

	@Override
	public String toString() {
		return "ProductVo [refProductId=" + refProductId + ", refProductName=" + refProductName + ", refLimitCount="
				+ refLimitCount + ", refValidityBuyStart=" + refValidityBuyStart + ", refValidityBuyEnd="
				+ refValidityBuyEnd + ", refValidityStart=" + refValidityStart + ", refValidityEnd=" + refValidityEnd
				+ ", refValidityDesc=" + refValidityDesc + ", refDescription=" + refDescription + ", refGuestPrompt="
				+ refGuestPrompt + ", refMarketPrice=" + refMarketPrice + ", refSalesPrice=" + refSalesPrice
				+ ", refConsumeArea=" + refConsumeArea + "]";
	}

}
