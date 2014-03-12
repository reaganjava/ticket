package com.pj.ebcenter.manager.hq.packed.entity;

import javax.xml.bind.annotation.XmlElement;

/**
 * <p>Copyright:Copyright(c)2012</p>
 * <p>Company:Mopon</p>
 * @date 2013年11月25日
 * @author 王方威
 * @version 1.0
 */
public class ProductResponseVo {

	private String ebProductId;

	private String message;

	/**
	 * @return the ebProductId
	 */
	@XmlElement(name = "EbGoodsId")
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
	 * @return the message
	 */
	@XmlElement(name = "Message")
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/** 
	 * 方法用途: <br>
	 * 实现步骤: <br>
	 * @return   
	 */
	@Override
	public String toString() {
		return "ProductReponseMessage [ebProductId=" + ebProductId + ", message=" + message + "]";
	}

}
