package com.pj.ebcenter.manager.hq.exception;

/**
 * <p>Description:解析报文出异常抛出改异常 </p>
 * @date 2013-9-4
 * @author あんど おか
 * @version 1.0
 * <p>Company:Mopon</p>
 * <p>Copyright:Copyright(c)2013</p>
 */
public class ParseXmlException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4441134534098823659L;

	public ParseXmlException() {

	}

	public ParseXmlException(Exception exception) {
		super(exception);
	}
}
