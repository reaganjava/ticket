package com.pj.ebcenter.manager.hq.packed;

import javax.xml.bind.annotation.XmlElement;

import com.pj.ebcenter.manager.hq.packed.entity.BaseEntity;

/**
 * <p>Description: 响应消息头</p>
 * @date 2013年11月22日
 * @author 蒋伟
 * @version 1.0
 * <p>Company:Mopon</p>
 * <p>Copyright:Copyright(c)2013</p>
 */
public class ResponseHeader extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1540159972077757776L;
	private String version;// 接口版本，默认1.0
	private String sequenceId; // 消息序列号
	private String statusCode;// 状态码
	private String timeStamp; // 报文请求时间,15位数字组成的时间戳YYYYMMDDHHMMSSS
	private String signed;// 消息签名 消息签名规则：Base64(MD5(消息序号+线下系统帐号+消息体内容长度))

	@XmlElement(name = "Version")
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@XmlElement(name = "SequenceId")
	public String getSequenceId() {
		return sequenceId;
	}

	public void setSequenceId(String sequenceId) {
		this.sequenceId = sequenceId;
	}

	@XmlElement(name = "TimeStamp")
	public String getTimeStamp() {
		return timeStamp;
	}
	@XmlElement(name = "StatusCode")
	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	@XmlElement(name = "Signed")
	public String getSigned() {
		return signed;
	}

	public void setSigned(String signed) {
		this.signed = signed;
	}

	public String toString() {
		return "version:" + this.version + "\r" + "sequenceId:" + this.sequenceId + "\r" + "statusCode:"
				+ this.statusCode + "\r" + "signed:" + this.signed + "\r" + "timeStamp:" + this.timeStamp;
	}

}
