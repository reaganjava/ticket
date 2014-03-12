package com.pj.ebcenter.manager.hq.exception;

/**
 * <p>Copyright:Copyright(c)2012</p>
 * <p>Company:Mopon</p>
 * @date 2013年11月25日
 * @author あんど おか
 * @version 1.0
 */
public class BussinessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1005992942018638811L;

	private String errorCode;

	private String message;

	/**
	 * @param errorCode
	 * @param message
	 */
	public BussinessException(String errorCode, String message) {
		super();
		this.errorCode = errorCode;
		this.message = message;
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

}
