package com.pj.ebcenter.manager.hq.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pj.ebcenter.manager.hq.constant.ApiEnum;
import com.pj.ebcenter.manager.hq.service.IApiProcessor;
import com.pj.ebcenter.manager.hq.service.IParseXmlProcessor;

/**
 * <p>Copyright:Copyright(c)2012</p>
 * <p>Company:Mopon</p>
 * @date 2013年11月22日
 * @author あんど おか
 * @version 1.0
 */
@Service("apiProcessor")
public class ApiProcessorImpl implements IApiProcessor {

	protected Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private IParseXmlProcessor parseXmlProcessor;

	/** 
	 * 方法用途: <br>
	 * 实现步骤: <br>
	 * @param apiEnum
	 * @return   
	 */
	@Override
	public String processor(ApiEnum apiEnum, String xmlContent) {

		logger.debug(" Process in ApiProcessorImpl.processor method, parameter apiEnum: " + apiEnum + ", xmlContent: "
				+ xmlContent);

		String res = null;
		switch (apiEnum) {
		case SYN_PRODUCT:
			res = parseXmlProcessor.tranToSysnProductPackets(xmlContent);
			break;
		case WICKET:
			res = parseXmlProcessor.tranToOutTicketNoticePackets(xmlContent);
			break;

		case VOUCHER:
			res = parseXmlProcessor.tranCheckETTicketPackets(xmlContent);
			break;
		default:
			break;
		}

		return res;
	}
}
