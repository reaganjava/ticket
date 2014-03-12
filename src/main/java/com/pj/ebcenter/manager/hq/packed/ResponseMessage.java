package com.pj.ebcenter.manager.hq.packed;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.pj.ebcenter.manager.hq.packed.entity.BaseEntity;

/**
 * <p>Description: 消息响应对象</p>
 * @date 2013年11月22日
 * @author 蒋伟
 * @version 1.0
 * <p>Company:Mopon</p>
 * <p>Copyright:Copyright(c)2013</p>
 */
@XmlRootElement(name = "Trade")
public class ResponseMessage extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ResponseHeader header;
	private Object body;
	@XmlElement(name="Head")
	public ResponseHeader getHeader() {
		return header;
	}
	public void setHeader(ResponseHeader header) {
		this.header = header;
	}
	@XmlElement(name="Body")
	public Object getBody() {
		return body;
	}
	public void setBody(Object body) {
		this.body = body;
	}
}
