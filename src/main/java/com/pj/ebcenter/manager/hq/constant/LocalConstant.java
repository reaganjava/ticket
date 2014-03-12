package com.pj.ebcenter.manager.hq.constant;

/**
 * <p>Copyright:Copyright(c)2012</p>
 * <p>Company:Mopon</p>
 * @date 2013年11月22日
 * @author 王方威
 * @version 1.0
 */
public class LocalConstant {

	public LocalConstant(String key) {
		KEY = key;
	}

	/**
	 * 1：未同步，2：已同步
	 */
	public static int SYN_WEB = 2;
	public static int NOT_SYN_WEB = 1;

	/**
	 * 1：更新 2：新增
	 */
	public static int UPDATE_RECORD = 1;
	public static int CREATE_RECORD = 2;

	// public static String KEY = "Y2Y0NTlkYzMtY2EzOC00OTQ2";

	public static String KEY;

}
