package com.pj.ebcenter.manager.hq.constant;

/**
 * <p>Copyright:Copyright(c)2012</p>
 * <p>Company:Mopon</p>
 * @date 2013年11月22日
 * @author 王方威
 * @version 1.0
 */
public enum ApiEnum {

	SYN_PRODUCT("同步商品"),

	VOUCHER("电子凭证"),

	WICKET("出票通知");

	/**
	 * 描述
	 */
	private String message;

	ApiEnum(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
