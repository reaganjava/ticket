package com.pj.ebcenter.manager.hq.exception;

/**
 * <p>Description: 验证签名错误</p>
 * @date 2013-9-5
 * @author あんど おか
 * @version 1.0
 * <p>Company:Mopon</p>
 * <p>Copyright:Copyright(c)2013</p>
 */
public class SignedErrorException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4262890516142813384L;

	public SignedErrorException() {

	}

	public SignedErrorException(String message) {
		super(message);
	}

	public SignedErrorException(Exception exception) {
		super(exception);
	}
}
