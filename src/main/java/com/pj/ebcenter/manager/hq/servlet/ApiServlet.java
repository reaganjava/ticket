package com.pj.ebcenter.manager.hq.servlet;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pj.ebcenter.manager.hq.constant.ApiEnum;
import com.pj.ebcenter.manager.hq.entity.OutlineProduct;
import com.pj.ebcenter.manager.hq.exception.BussinessException;
import com.pj.ebcenter.manager.hq.service.IApiProcessor;
import com.pj.ebcenter.manager.local.jms.service.ILocalVoucherService;

/**
 * <p>
 * Copyright:Copyright(c)2012
 * </p>
 * <p>
 * Company:Mopon
 * </p>
 * 
 * @date 2013年11月21日
 * @author あんど おか
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/offline/send")
public class ApiServlet {

	protected Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private IApiProcessor apiProcessor;
	
	@RequestMapping(value = "sendTicketData")
	public void sendTicketData(HttpServletRequest request,
			HttpServletResponse response,String xmlContent){
		ticketDataController(response,xmlContent,ApiEnum.SYN_PRODUCT);
	}
	
	@RequestMapping(value = "checkETicket")
	public void checkETicket(HttpServletRequest request,
			HttpServletResponse response,String xmlContent){
		ticketDataController(response,xmlContent,ApiEnum.VOUCHER);
	}
	
	@RequestMapping(value = "outTicketNotice")
	public void outTicketNotice(HttpServletRequest request,
			HttpServletResponse response,String xmlContent){
		ticketDataController(response,xmlContent,ApiEnum.WICKET);
	}
		
	/**
	 * 
	 * 方法用途: <br>
	 * 实现步骤: <br>
	 * @param response
	 * @param xmlContent
	 * @param type
	 */
	public void ticketDataController(HttpServletResponse response,
			String xmlContent,ApiEnum type){
		logger.debug("Process in ApiServlet.ticketDataController parameter type:" + type
				+ ", xmlContent: " + xmlContent);
		String result = null;
		if (xmlContent == null || "".equals(xmlContent)) {
			result = "xmlContent内容不能为空";
		} else {
			result = apiProcessor.processor(type,xmlContent);
		}
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		try {
			response.getOutputStream().write(result.getBytes());
		} catch (IOException e) {
			logger.error("ApiServlet.ticketDataController IOException:"+e.toString());
			e.printStackTrace();
		}finally{
			try {
				response.getOutputStream().flush();
				response.getOutputStream().close();
			} catch (IOException e) {
				logger.error("ApiServlet.ticketDataController IOException:"+e.toString());
				e.printStackTrace();
			}
		}
	}	
}
