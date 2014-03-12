package com.pj.ebcenter.manager.hq.packed;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.pj.ebcenter.manager.hq.packed.entity.BaseEntity;
import com.pj.ebcenter.manager.hq.packed.entity.Body;


/**
 * <p>Description: 消息请求对象</p>
 * @date 2013年11月22日
 * @author 蒋伟
 * @version 1.0
 * <p>Company:Mopon</p>
 * <p>Copyright:Copyright(c)2013</p>
 */
@XmlRootElement(name="Trade")
public class RequestMessage extends BaseEntity{

	private static final long serialVersionUID = -8323393538246374930L;
	private RequestHeader header;	//消息头
	private Body body;//消息体
	@XmlElement(name="Head")
	public RequestHeader getHeader() {
		return header;
	}
	public void setHeader(RequestHeader header) {
		this.header = header;
	}


	public String toString(){
		return "header{"+this.header+"}\r"+"body{"+this.body+"}";
	}
	@XmlElement(name="Body")
	public Body getBody() {
		return body;
	}
	public void setBody(Body body) {
		this.body = body;
	}

}
