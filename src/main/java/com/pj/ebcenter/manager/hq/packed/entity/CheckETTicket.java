package com.pj.ebcenter.manager.hq.packed.entity;

import javax.xml.bind.annotation.XmlElement;

/**
 * <p>Description: 电子凭证换纸质票接口消息体</p>
 * @date 2013年11月22日
 * @author 蒋伟
 * @version 1.0
 * <p>Company:Mopon</p>
 * <p>Copyright:Copyright(c)2013</p>
 */
public class CheckETTicket extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String orderId; //电商平台订单编号
	private String voucherValue;//凭证值
	private String status;//凭证状态
	private String statusDec;//凭证状态描述
	private String offlineGoodsId;//线下系统的商品ID
	private String salePrice;//售价
	private String useStartTime ;//使用开始时间
	private String useEndTime;//使用结束时间
	private String Message;//返回的信息文本
	@XmlElement(name="OrderId")
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	@XmlElement(name="VoucherValue")
	public String getVoucherValue() {
		return voucherValue;
	}
	public void setVoucherValue(String voucherValue) {
		this.voucherValue = voucherValue;
	}
	@XmlElement(name="Status")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@XmlElement(name="StatusDec")
	public String getStatusDec() {
		return statusDec;
	}
	public void setStatusDec(String statusDec) {
		this.statusDec = statusDec;
	}
	@XmlElement(name="OfflineGoodsId")
	public String getOfflineGoodsId() {
		return offlineGoodsId;
	}
	public void setOfflineGoodsId(String offlineGoodsId) {
		this.offlineGoodsId = offlineGoodsId;
	}
	@XmlElement(name="SalePrice")
	public String getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(String salePrice) {
		this.salePrice = salePrice;
	}
	@XmlElement(name="UseStartTime")
	public String getUseStartTime() {
		return useStartTime;
	}
	public void setUseStartTime(String useStartTime) {
		this.useStartTime = useStartTime;
	}
	@XmlElement(name="UseEndTime")
	public String getUseEndTime() {
		return useEndTime;
	}
	public void setUseEndTime(String useEndTime) {
		this.useEndTime = useEndTime;
	}
	@XmlElement(name="Message")
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public String toString(){
		return this.orderId+this.offlineGoodsId+this.salePrice+this.status+this.statusDec+this.useEndTime+this.useStartTime+this.voucherValue+this.Message;
	}
}
