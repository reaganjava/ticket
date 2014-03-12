package com.pj.ebcenter.manager.hq.packed;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.pj.ebcenter.manager.hq.packed.entity.BaseEntity;
import com.pj.ebcenter.manager.hq.packed.entity.ProductVo;

/**
 * <p>Copyright:Copyright(c)2012</p>
 * <p>Company:Mopon</p>
 * @date 2013年11月25日
 * @author 王方威
 * @version 1.0
 */
@XmlRootElement(name = "Trade")
public class ProductRequestMessage extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3676299423317671040L;
	private RequestHeader header; // 消息头
	private ProductVo body;// 消息体

	@XmlElement(name = "Head")
	public RequestHeader getHeader() {
		return header;
	}

	public void setHeader(RequestHeader header) {
		this.header = header;
	}

	public String toString() {
		return "header{" + this.header + "}\r" + "body{" + this.body + "}";
	}

	/**
	 * @return the body
	 */
	@XmlElement(name = "Body")
	public ProductVo getBody() {
		return body;
	}

	/**
	 * @param body the body to set
	 */
	public void setBody(ProductVo body) {
		this.body = body;
	}

}
