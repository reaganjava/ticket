package com.pj.ebcenter.manager.hq.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 
 * 线下商品同步的数据
 * @author あんど おか
 * @version 1.0
 *  @date 2013年11月21日
 * <p>Copyright:Copyright(c)2012</p>
 * <p>Company:Mopon</p>
 */
public class OutlineProduct implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5933260739972166474L;

	/**
	 * PK
	 */
	private int id;

	/**
	 * 线下系统的账号
	 */
	private String offlineAccount;

	/**
	 * 线下商品的ID
	 */
	private String refProductId;

	/**
	 * 线上商品的ID
	 */
	private String ebProductId;

	/**
	 * 线上商品名称
	 */
	private String ebProductName;

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
	 * 是否同步（1：未同步，2：已同步）
	 */
	private int isSyn;

	/**
	 * 是跟新还是新增（1：更新 2：新增）
	 */
	private int isUpdate;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

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
	 * @return the ebProductId
	 */
	public String getEbProductId() {
		return ebProductId;
	}

	/**
	 * @param ebProductId the ebProductId to set
	 */
	public void setEbProductId(String ebProductId) {
		this.ebProductId = ebProductId;
	}

	/**
	 * @return the ebProductName
	 */
	public String getEbProductName() {
		return ebProductName;
	}

	/**
	 * @param ebProductName the ebProductName to set
	 */
	public void setEbProductName(String ebProductName) {
		this.ebProductName = ebProductName;
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

	/**
	 * @return the isSyn
	 */
	public int getIsSyn() {
		return isSyn;
	}

	/**
	 * @param isSyn the isSyn to set
	 */
	public void setIsSyn(int isSyn) {
		this.isSyn = isSyn;
	}

	/**
	 * @return the isUpdate
	 */
	public int getIsUpdate() {
		return isUpdate;
	}

	/**
	 * @param isUpdate the isUpdate to set
	 */
	public void setIsUpdate(int isUpdate) {
		this.isUpdate = isUpdate;
	}

	/**
	 * @return the offlineAccount
	 */
	public String getOfflineAccount() {
		return offlineAccount;
	}

	/**
	 * @param offlineAccount the offlineAccount to set
	 */
	public void setOfflineAccount(String offlineAccount) {
		this.offlineAccount = offlineAccount;
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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OutlineProduct other = (OutlineProduct) obj;
		if (refConsumeArea == null) {
			if (other.refConsumeArea != null)
				return false;
		} else if (!refConsumeArea.equals(other.refConsumeArea))
			return false;
		if (refDescription == null) {
			if (other.refDescription != null)
				return false;
		} else if (!refDescription.equals(other.refDescription))
			return false;
		if (refGuestPrompt == null) {
			if (other.refGuestPrompt != null)
				return false;
		} else if (!refGuestPrompt.equals(other.refGuestPrompt))
			return false;
		if (refLimitCount == null) {
			if (other.refLimitCount != null)
				return false;
		} else if (!refLimitCount.equals(other.refLimitCount))
			return false;
		if (refMarketPrice == null) {
			if (other.refMarketPrice != null)
				return false;
		} else if (!refMarketPrice.equals(other.refMarketPrice))
			return false;
		if (refProductId == null) {
			if (other.refProductId != null)
				return false;
		} else if (!refProductId.equals(other.refProductId))
			return false;
		if (refProductName == null) {
			if (other.refProductName != null)
				return false;
		} else if (!refProductName.equals(other.refProductName))
			return false;
		if (refSalesPrice == null) {
			if (other.refSalesPrice != null)
				return false;
		} else if (!refSalesPrice.equals(other.refSalesPrice))
			return false;
		if (refValidityBuyEnd == null) {
			if (other.refValidityBuyEnd != null)
				return false;
		} else if (!refValidityBuyEnd.equals(other.refValidityBuyEnd))
			return false;
		if (refValidityBuyStart == null) {
			if (other.refValidityBuyStart != null)
				return false;
		} else if (!refValidityBuyStart.equals(other.refValidityBuyStart))
			return false;
		if (refValidityDesc == null) {
			if (other.refValidityDesc != null)
				return false;
		} else if (!refValidityDesc.equals(other.refValidityDesc))
			return false;
		if (refValidityEnd == null) {
			if (other.refValidityEnd != null)
				return false;
		} else if (!refValidityEnd.equals(other.refValidityEnd))
			return false;
		if (refValidityStart == null) {
			if (other.refValidityStart != null)
				return false;
		} else if (!refValidityStart.equals(other.refValidityStart))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OutlineProduct [id=" + id + ", offlineAccount=" + offlineAccount + ", refProductId=" + refProductId
				+ ", ebProductId=" + ebProductId + ", ebProductName=" + ebProductName + ", refProductName="
				+ refProductName + ", refLimitCount=" + refLimitCount + ", refValidityBuyStart=" + refValidityBuyStart
				+ ", refValidityBuyEnd=" + refValidityBuyEnd + ", refValidityStart=" + refValidityStart
				+ ", refValidityEnd=" + refValidityEnd + ", refValidityDesc=" + refValidityDesc + ", refDescription="
				+ refDescription + ", refGuestPrompt=" + refGuestPrompt + ", refMarketPrice=" + refMarketPrice
				+ ", refSalesPrice=" + refSalesPrice + ", refConsumeArea=" + refConsumeArea + ", isSyn=" + isSyn
				+ ", isUpdate=" + isUpdate + "]";
	}

}
