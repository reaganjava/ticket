package com.pj.ebcenter.manager.hq.packed.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>Description: </p>
 * @date 2013年11月22日
 * @author 蒋伟
 * @version 1.0
 * <p>Company:Mopon</p>
 * <p>Copyright:Copyright(c)2013</p>
 */
@XmlRootElement(name="Body")
public class Body {
	private String voucherValue;

	@XmlElement(name = "VoucherValue")
	public String getVoucherValue() {
		return voucherValue;
	}

	public void setVoucherValue(String voucherValue) {
		this.voucherValue = voucherValue;
	}

	public String toString() {
		return "VoucherValue:"+this.voucherValue;
	}

}
