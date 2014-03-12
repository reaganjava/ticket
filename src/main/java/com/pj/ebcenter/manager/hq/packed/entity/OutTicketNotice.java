package com.pj.ebcenter.manager.hq.packed.entity;

import javax.xml.bind.annotation.XmlElement;

/**
 * <p>Description: 出票通知接口消息体</p>
 * @date 2013年11月22日
 * @author 蒋伟
 * @version 1.0
 * <p>Company:Mopon</p>
 * <p>Copyright:Copyright(c)2013</p>
 */
public class OutTicketNotice {
private String message;
@XmlElement(name="Message")
public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}
}
