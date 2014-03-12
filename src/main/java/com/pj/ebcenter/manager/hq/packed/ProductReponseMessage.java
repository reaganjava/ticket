package com.pj.ebcenter.manager.hq.packed;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.pj.ebcenter.manager.hq.packed.entity.BaseEntity;
import com.pj.ebcenter.manager.hq.packed.entity.ProductResponseVo;

/**
 * <p>Copyright:Copyright(c)2012</p>
 * <p>Company:Mopon</p>
 * @date 2013年11月25日
 * @author 王方威
 * @version 1.0
 */
@XmlRootElement(name = "Trade")
public class ProductReponseMessage extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3500827928829119130L;

	private ResponseHeader header;

	private ProductResponseVo body;

	@XmlElement(name = "Head")
	public ResponseHeader getHeader() {
		return header;
	}

	public void setHeader(ResponseHeader header) {
		this.header = header;
	}

	/**
	 * @return the body
	 */
	@XmlElement(name = "Body")
	public ProductResponseVo getBody() {
		return body;
	}

	/**
	 * @param body the body to set
	 */
	public void setBody(ProductResponseVo body) {
		this.body = body;
	}

}
