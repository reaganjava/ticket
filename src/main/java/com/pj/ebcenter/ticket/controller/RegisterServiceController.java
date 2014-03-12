package com.pj.ebcenter.ticket.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pj.ebcenter.manager.local.ftp.service.ILocalFtpService;
import com.pj.ebcenter.ticket.service.IVoucherService;
import com.pj.ebcenter.ticket.util.CacheManager;
import com.pj.ebcenter.ticket.util.DateUtils;

/**
 * <p>Description: POS机签到签退控制类</p>
 * @date 2013年10月26日
 * @author 蒋伟
 * @version 1.0
 * <p>Company:Mopon</p>
 * <p>Copyright:Copyright(c)2013</p>
 */
@Controller
@RequestMapping(value = "/register")
public class RegisterServiceController {
	Logger logger = Logger.getLogger(RegisterServiceController.class);
	@Autowired
	private IVoucherService voucherService;
	@Autowired
	private CacheManager cacheManager;

	@Autowired
	private ILocalFtpService localFtpService;

	@RequestMapping(value = "/ftp")
	public void ftp(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("=======================================");
		//localFtpService.getVoucherDataFromTtp();
	}

	@RequestMapping(value = "/signIn")
	public void signIn(HttpServletRequest request, HttpServletResponse response) throws Exception {
		long startTime = System.currentTimeMillis();
		StringBuffer sb = new StringBuffer();
		Map<String, String> params = new HashMap<String, String>();
		String device_id = request.getParameter("deviceid");
		String password = request.getParameter("passWord");
		String createTime = request.getParameter("createTime");
		params.put("equipment_number", device_id);
		if (password != null)
			params.put("password", password);
		params.put("create_time", DateUtils.changeDate(createTime));
		String[] result = voucherService.signIn(params).split("#");
		// 以xml为载体返回
		response.setContentType("text/html;charset=utf-8");
		// 设置禁用缓存
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.setHeader("exprise", "-1");
		if (result[0].equals("0")) {
			sb.append("<?xml version='1.0' encoding='UTF-8'?><trade><head>")
					.append("<errorcode>0</errorcode><description></description></head>").append("<body>")
					.append("<batchNo>").append(result[1]).append("</batchNo>").append("<merchant_id>")
					.append(result[2]).append("</merchant_id>").append("</body></trade>");
		} else {
			sb.append("<?xml version='1.0' encoding='UTF-8'?><trade><head>")
					.append("<errorcode>1</errorcode><description>").append(result[1]).append("</description></head>")
					.append("<body><title></title><printtext></printtext></body></trade>");

		}
		cacheManager.refreshCache(device_id);
		System.out.println(sb.toString());
		long endTime = System.currentTimeMillis();
		logger.info(sb.toString() + "\\n运行时间：" + (endTime - startTime) + "秒");
		PrintWriter out = response.getWriter();
		out.print(sb.toString());
		out.flush();
		out.close();
	}

	@RequestMapping(value = "/signOut")
	public void signOut(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		StringBuffer sb = new StringBuffer();
		Map<String, String> params = new HashMap<String, String>();
		String device_id = request.getParameter("deviceid");
		String password = request.getParameter("passWord");
		String createTime = request.getParameter("createTime");
		params.put("equipment_number", device_id);
		params.put("password", password);
		params.put("create_time", createTime);
		String[] result = voucherService.signOut(params).split("#");
		// 以xml为载体返回
		response.setContentType("text/html;charset=utf-8");
		// 设置禁用缓存
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.setHeader("exprise", "-1");
		if (result[0].equals("0")) {
			sb.append("<?xml version='1.0' encoding='UTF-8'?><trade><head>")
					.append("<errorcode>0</errorcode><description>").append(result[1]).append("</description></head>")
					.append("<body>").append("</body></trade>");
		}
		logger.info(sb.toString());
		System.out.println(sb.toString());
		PrintWriter out = response.getWriter();
		out.print(sb.toString());
		out.flush();
		out.close();
	}

}
