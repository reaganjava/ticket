package com.pj.ebcenter.manager.hq.service;

/**
 * <p>Copyright:Copyright(c)2012</p>
 * <p>Company:Mopon</p>
 * @date 2013年11月25日
 * @author 王方威
 * @version 1.0
 */
public interface IParseXmlProcessor {

	/**
	 * 
	 * 方法用途:同步商品的保温执行者 <br>
	 * 实现步骤: <br>
	 * @param xmlContent
	 * @return
	 */
	public String tranToSysnProductPackets(String xmlContent);
	
	/**
	 * 
	 * 方法用途:解析出票通知的报文 <br>
	 * 实现步骤: <br>
	 * @param xmlContent
	 * @return
	 */
	public String tranToOutTicketNoticePackets(String xmlContent);
	/**
	 * 方法用途:解析报文
	 * 	 实现步骤: <br>
	 * @param xmlContent
	 * @return
	 * **/
	public String tranCheckETTicketPackets(String xmlContent);
}
