package com.pj.ebcenter.manager.hq.service;

import com.pj.ebcenter.manager.hq.constant.ApiEnum;

/**
 * <p>Copyright:Copyright(c)2012</p>
 * <p>Company:Mopon</p>
 * @date 2013年11月22日
 * @author 王方威
 * @version 1.0
 */
public interface IApiProcessor {

	/**
	 * 方法用途: 执行接口方法<br>
	 * 实现步骤: <br>
	 * @param apiEnum
	 * @param xmlContent
	 * @return
	 */
	public String processor(ApiEnum apiEnum, String xmlContent);
}
