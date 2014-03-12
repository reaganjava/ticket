package com.pj.ebcenter.ticket.controller;

import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pj.ebcenter.ticket.service.IVoucherService;
import com.pj.ebcenter.ticket.util.DateUtils;
import com.pj.ebcenter.ticket.util.VoucherHelp;

/**
 * <p>Description:提供凭证验证服务类 </p>
 * @date 2013年10月21日
 * @author 蒋伟
 * @version 1.0
 * <p>Company:Mopon</p>
 * <p>Copyright:Copyright(c)2013</p>
 */
@Controller
@RequestMapping(value = "/verifyVoucher")
public class VerifyVoucherController {
	Logger log=Logger.getLogger(VerifyVoucherController.class);
	@Autowired
	private IVoucherService voucherService;
	@Autowired
	private VoucherHelp voucherHelp;
	/** 重打印标识符 */
	public final static String REPRINT_FLAG = "0";
	public final static String CHANGE_TICKET="2";
	public final static String IS_TITCK="1";

	@RequestMapping(method = RequestMethod.GET)
	public void verifyHandle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		long startTime = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder();
		// 商户号
		String merchant_Id = request.getParameter("merchant_Id");
		// 凭证值
		String voucherValue = request.getParameter("voucherid");
		// 消费时间(yyyy-MM-dd HH:mm:ss)
		String use_Time = DateUtils.changeDate(request.getParameter("time"));
		//消费时间 YYYYMMDDhhmmss
		String user_Time_Str = request.getParameter("time");
		// 店面号
		String storeNo = request.getParameter("storeNo");
		// 重复打印标识 0表示重打印
		String is_reprint = request.getParameter("is_reprint");
		// 设备编号
		String deviceid = request.getParameter("deviceid");
		//交易流水号
		String transactionID = request.getParameter("transactionID");
		//二次确认入园
		String confirm = request.getParameter("confirm");
		//批次号
		String batchID = request.getParameter("batchID");
		//店面名称 暂时没用
		String storename = request.getParameter("storename");
//		String batch_no = "";
//		String bussiness_no = "";
//		if (StringUtils.isNotEmpty(tradeno) && tradeno.length() > 6) {
//			batch_no = tradeno.substring(0, 6);
//		}
//		if (StringUtils.isNotEmpty(tradeno) && tradeno.length() > 6) {
//			bussiness_no = tradeno.substring(batch_no.length(), tradeno.length());
//		}
		Enumeration enu=request.getParameterNames();  
		while(enu.hasMoreElements()){  
		String paraName=(String)enu.nextElement();  
		log.info("paraName=["+paraName+":"+request.getParameter(paraName)+"]");  
		}  
		// 验证
		Map<String, String> verify_map = new HashMap<String, String>();
		verify_map.put("deviceid", deviceid);
		verify_map.put("money", "0".equals(request.getParameter("money")) ? "1" : request.getParameter("money"));
		verify_map.put("storeName", storename);
		verify_map.put("transactionID",transactionID);
		verify_map.put("use_time", use_Time);
		verify_map.put("voucher_value", voucherValue);
		verify_map.put("storeNo", storeNo);
		verify_map.put("is_reprint", is_reprint);
		verify_map.put("certificate_num", request.getParameter("certificate_num"));
		verify_map.put("batch_no", batchID);
		verify_map.put("merchant_Id", merchant_Id);
		verify_map.put("user_Time_Str",user_Time_Str);
		verify_map.put("confirm", confirm);
		String result = voucherHelp.validate(verify_map);// 验证结果返回

		// 以xml为载体返回
		response.setContentType("text/html;charset=utf-8");
		// 设置禁用缓存
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.setHeader("exprise", "-1");
		String results[] = result.split("#");
		@SuppressWarnings("unused")
		int length = results.length;
		// 验证通过
		if (results[0].equals("1")) {
			Map<String, String> params = new HashMap<String, String>();
			params.put("device_id", deviceid);
			params.put("voucher_value", voucherValue);
			boolean flag = REPRINT_FLAG.equals(is_reprint);
			sb.append("<?xml version='1.0' encoding='UTF-8'?><trade><head>")
					.append("<errorcode>0</errorcode>").append("<description>").append("</description>").append("<message>")
					.append("全价票")
					.append("</message></head>").append("<body>")
//					.append("<title>").append(results[1]);
//			if (flag) {
//				sb.append("（重打印）");
//			}
//			sb.append("</title>")
			.append("<printtext>").append(results[8]);
			if(flag){
			sb.append("(重打印)");
			}
			sb.append("\n");
			sb.append("凭证号码:").append(results[2]);
			sb.append("\n商户名称:").append(results[1]).append("\n店面名称:").append(results[1]).append("\n终端编号:")
					.append(deviceid);
			sb.append("\n批次号:").append(batchID);
			sb.append("\n交易号:").append(transactionID);
			sb.append("\n消费时间:").append(results[6]);
			// sb.append("\n商品名称：").append(results[1]);
			sb.append("\n消费数量:").append(results[3]);
			sb.append("\n说    明:").append("欢迎您再来").append(results[7]).append("旅游");
			sb.append("</printtext>").append("</body></trade>");
		} else if(results[0].equals("2")){
			boolean flag = REPRINT_FLAG.equals(is_reprint);
			if(results[1].equals("first")){
				sb.append("<?xml version='1.0' encoding='UTF-8'?><trade><head>")
				.append("<errorcode>2</errorcode><description>").append("</description>").append("<message>")
				.append("半价票").append("</message></head>")
				.append("<body><title></title><printtext>").append(results[2]);
				sb.append("</printtext></body></trade>");
			}
			else{
			sb.append("<?xml version='1.0' encoding='UTF-8'?><trade><head>")
			.append("<errorcode>2</errorcode><description>").append("</description>").append("<message>")
			.append("半价票").append("</message></head>")
			.append("<body><title></title><printtext>").append(results[8]);
			if(flag){
			sb.append("(重打印)");
			}
			sb.append("\n");
			sb.append("凭证号码:").append(results[2]);
			sb.append("\n商户名称:").append(results[1]).append("\n店面名称:").append(storename).append("\n终端编号:")
					.append(deviceid);
			sb.append("\n批次号:").append(batchID);
			sb.append("\n交易号:").append(transactionID);
			sb.append("\n消费时间:").append(results[6]);
			sb.append("\n消费数量:").append(results[3]);
			sb.append("</printtext></body></trade>");
		}
		}
		else {
					sb.append("<?xml version='1.0' encoding='UTF-8'?><trade><head>")
					.append("<errorcode>1</errorcode><description>").append(results[0]).append("</description></head>")
					.append("<body><title></title><printtext></printtext></body></trade>");
		}
		long endTime = System.currentTimeMillis();
		log.info(sb.toString() + "\n运行时间：" + (endTime - startTime)  + "毫秒");
		PrintWriter out = response.getWriter();
		out.print(sb.toString());
		out.flush();
		out.close();
	}
}
