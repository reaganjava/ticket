package com.pj.ebcenter.ticket.util;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pj.ebcenter.ticket.controller.VerifyVoucherController;
import com.pj.ebcenter.ticket.entity.Equipment;
import com.pj.ebcenter.ticket.entity.Voucher;
import com.pj.ebcenter.ticket.entity.VoucherMerchant;
import com.pj.ebcenter.ticket.pub.constant.VoucherConstant;
import com.pj.ebcenter.ticket.service.IVoucherService;

/**
 * <p>Description: 凭证验证帮助类</p>
 * @date 2013年10月21日
 * @author 蒋伟
 * @version 1.0
 * <p>Company:Mopon</p>
 * <p>Copyright:Copyright(c)2013</p>
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
@Component("voucherHelp")
public class VoucherHelp {
	@Autowired
	private IVoucherService voucherService;
	@Autowired
	private TerminalManager terminalManager;

	@Autowired
	private CacheManager cacheManager;

	/**
	 * 功能：验证凭证
	 * 
	 * @param Map
	 * @throws Exception 
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public String validate(Map<String, String> map) throws Exception {
		int checking_type = 0; // 验证方式
		int updateflag = 0;
		String type_name = "商品"; // 方式
		Map<String, String> params = new HashMap<String, String>();//
		String use_Time_date = map.get("use_time").toString().trim().substring(0, 10);// 使用时间
		String isReprint = map.get("is_reprint").toString().trim(); // 重打印
		boolean reprintFlag = VerifyVoucherController.REPRINT_FLAG.equals(isReprint); // 重打印标识符
		String voucher_value = map.get("voucher_value").toString().trim();// 凭证值
		String merchant_Id = map.get("merchant_Id");// 商户号

		Equipment cacheEquipment = cacheManager.getCacheEquipment(map.get("deviceid"));
		if (null == cacheEquipment) {
			cacheManager.refreshCache(map.get("deviceid"));
			cacheEquipment = cacheManager.getCacheEquipment(map.get("deviceid"));
			if (null == cacheEquipment)
				return new StringBuilder("平台没有找到该设备!").toString();
			else
				merchant_Id = cacheEquipment.getMerchantId();
		} else {
			merchant_Id = cacheEquipment.getMerchantId();
		}
		// 通过凭证号查询
		if (StringUtils.isNotEmpty(voucher_value)) {
			if (reprintFlag) {
				params.put("status", VoucherConstant.voucher_has_used);
				params.put("status1", VoucherConstant.voucher_part_used);
				params.put("use_time_not_null", "1");
			}
			if (voucher_value.length() <= 14) {
				params.put("voucher_value", voucher_value);
				checking_type = 1;
			} else {
				params.put("certificate_num", voucher_value);
				checking_type = 2;
				type_name = "商品";
			}
		} else {
			return "凭证号不能为空!";
		}
		// 根据id查找
		//params.put("voucher_value", voucher_value);
		params.put("merchant_id", merchant_Id);
		params.put("checking_type", String.valueOf(checking_type));
		map.put("checking_type", String.valueOf(checking_type));
		List row = voucherService.queryVoucher(params);
		int rowCount = row.size();
		if (rowCount < 1 && reprintFlag) {
			return new StringBuilder("此").append(type_name).append("还没进行消费不能进行重打印!").toString();
		}
		if (rowCount < 1) {
			return new StringBuilder("此").append(type_name).append("不能在该商户上使用").toString();
		}

		Map dataMap = new HashMap();
		Voucher voucher = null;
		boolean levelFlag = true;  // 警告级别
		String timeCheck = "";
		VoucherMerchant vm = null;
		for (int k = 0; k < rowCount; k++) {
			StringBuilder result = new StringBuilder();
			voucher = (Voucher) row.get(k);
			List vmList = voucher.getVoucherMerchant();
			String merchantId = "";
			String merchantName = "";
			for (int i = 0; i < vmList.size(); i++) {
				vm = (VoucherMerchant) vmList.get(i);
				if (vm.getMerchantId().toString().equals(merchant_Id)) {
					merchantId = vm.getMerchantId().toString();
					merchantName = vm.getMerchantName();
					dataMap.put("merchantName", merchantName);
					dataMap.put("canUserTimes", vm.getCanUseTimes());
					dataMap.put("userTimes", vm.getUseTimes());
					dataMap.put("scenicSpotName", vm.getScenicSpotName());
					map.put("merchant_Id", vm.getMerchantId());
					map.put("merchantName", vm.getMerchantName());
					break;
				}
			}
			dataMap.put("goods_name", voucher.getGoodsName());
			dataMap.put("voucher_value", voucher.getVoucherValue());
			dataMap.put("use_time", map.get("use_time").toString());
			dataMap.put("order_id", voucher.getOrderId());
			dataMap.put("max_use_times", voucher.getMaxUseTimes() - voucher.getFreezeNum() - voucher.getCancelNum());
			dataMap.put("voucher_id", voucher.getVoucherId());
			dataMap.put("issecond", voucher.getIsSeondValid().intValue()==1?2:1);
			String status = voucher.getStatus().toString();
			/**
			 * 消费类型为换票并没有出票的凭证
			 * **/
			if ( isReprint.equals(VerifyVoucherController.CHANGE_TICKET) ) {
				//如果已出票
				if (VerifyVoucherController.IS_TITCK.equals(voucher.getIsTicket().toString())) {
					return result.append("该").append(type_name).append("已出票，请联系客服进行取票重置!\n联系电话:400-066-8882").toString();
				}
				else  {
					//如果能消费次数等于已使用次数
					if(/*dataMap.get("canUserTimes").equals(dataMap.get("userTimes"))*/VoucherConstant.voucher_has_used.equals(status)||VoucherConstant.voucher_part_used.equals(status)){
						return result.append("该").append(type_name).append("已经全部消费不能进行换票!").toString();
					} else {
						return changeTicket(vm, dataMap, checking_type, result, terminalManager, updateflag, voucherService,
								merchantId, merchant_Id, voucher, map, use_Time_date, type_name, params);
					}
					/*if(dataMap.get("canUserTimes").equals(dataMap.get("userTimes"))){
						result.append("该").append(type_name).append("已经全部消费不能进行换票!");
					}else{*/
					//}
				}
			}
			//主要针对身份证验证：判断未使用的凭证是否合法，不合法继续找
			if (VoucherConstant.voucher_not_used.equals(status)) {
				levelFlag = false;
				timeCheck = checkVality(voucher, use_Time_date, type_name, params, map);
				if ("".equals(timeCheck)) {
					break;
				}
			}
			//不等于“未使用凭证”的判断
			if (levelFlag) {
				if (VoucherConstant.voucher_expired_retreat.equals(status)) {
					result.append("该").append(type_name).append("已过期,不允许使用!");
				}
				else if (VoucherConstant.voucher_obsolete.equals(status)) {
					result.append("该").append(type_name).append("已作废,不允许使用!");
				}
				else if (VoucherConstant.voucher_not_effective.equals(status)) {
					result.append("该").append(type_name).append("凭证未生效!");
				}
				else if (!reprintFlag && (VoucherConstant.voucher_has_used.equals(status)||VoucherConstant.voucher_part_used.equals(status))) {
					result.append("该").append(type_name).append("凭证已使用!");
				} 
				if (rowCount==k+1) {
					if (!"".equals(result.toString()))
						return result.toString();
				} 
			} 
		}
		if (!"".equals(timeCheck)) {
			return timeCheck;
		}
		/****
		 * 
		 * 类型为消费的验证
		 * **/
		if (!reprintFlag && !isReprint.equals(VerifyVoucherController.CHANGE_TICKET)) {

			return consume(use_Time_date, updateflag, params, type_name,
					checking_type, cacheEquipment, new StringBuilder(), voucher, merchant_Id, dataMap, map, vm);

		} 
		/**
		 * 重打印
		 * **/
		if (reprintFlag && !isReprint.equals(VerifyVoucherController.CHANGE_TICKET)) {

			return rePrinter(row, dataMap, merchant_Id, dataMap);

		}
		return "";
	}

	/**
	 * 
	 * 描述：打印验证信息 
	 * 
	 * @param Map
	 * @param dataMap
	 * @return
	 */
	public static String printValidateMsg(Map<String, String> dataMap) {
		return new StringBuilder(String.valueOf(dataMap.get("issecond"))).append("#").append(dataMap.get("merchantName")).append("#")
				.append(dataMap.get("voucher_value")).append("#").append(String.valueOf(dataMap.get("max_use_times")))
				.append("#").append(dataMap.get("order_id").toString()).append("#").append(dataMap.get("voucher_id"))
				.append("#").append(dataMap.get("use_time")).append("#").append(dataMap.get("scenicSpotName"))
				.append("#").append(dataMap.get("goods_name")).append("#").toString();
	}

	/**
	 * 
	 * 描述：打印验证信息 
	 * 
	 * @param Map
	 * @param dataMap
	 * @return
	 */
	public static String printValidateConfirmMsg(Map<String, String> dataMap) {
		return new StringBuilder(dataMap.get("issecond")).append("#").append(dataMap.get("merchantName")).append("#")
				.append(dataMap.get("voucher_value")).append("#").append(String.valueOf(dataMap.get("max_use_times")))
				.append("#").append(dataMap.get("order_id").toString()).append("#").append(dataMap.get("voucher_id"))
				.append("#").append(dataMap.get("use_time")).append("#").append(dataMap.get("scenicSpotName"))
				.append("#").append(dataMap.get("goods_name")).append("#").toString();
	}

	/***
	 * 重打印
	 * 
	 * **/
	public String rePrinter(List row, Map dataMap, String merchant_Id, Map map) {
		Voucher voucher = (Voucher) row.get(0);
		dataMap.put("oper", "0");
		dataMap.put("validate_times", voucher.getValidateTimes());
		List vmList = voucher.getVoucherMerchant();
		String merchantName = "";
		for (int i = 0; i < vmList.size(); i++) {
			VoucherMerchant vm = (VoucherMerchant) vmList.get(i);
			if (vm.getMerchantId().toString().equals(merchant_Id)) {
				merchantName = vm.getMerchantName();
				dataMap.put("merchantName", merchantName);
				dataMap.put("canUserTimes", vm.getCanUseTimes());
				dataMap.put("userTimes", vm.getUseTimes());
				dataMap.put("scenicSpotName", vm.getScenicSpotName());
			}
		}
		dataMap.put("voucher_value", voucher.getVoucherValue());
		dataMap.put("order_id", voucher.getOrderId());
		dataMap.put("voucher_id", voucher.getVoucherId());
		dataMap.put("use_time", voucher.getUseTime().toString());
		dataMap.put("max_use_times", voucher.getMaxUseTimes() - voucher.getFreezeNum() - voucher.getCancelNum());
		dataMap.put("goods_name", voucher.getGoodsName());
		try {
			terminalManager.addOrUpdate(dataMap, voucher, map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return printValidateMsg(dataMap);
	}

	/**
	 * 描述：凭证消费
	 * **/
	public String consume(String use_Time_date,
			int updateflag, Map params, String type_name, int checking_type, Equipment cacheEquipment,
			StringBuilder result, Voucher voucher, String merchant_Id, Map dataMap, Map map, VoucherMerchant vm) {

			result = new StringBuilder();
			String merchantId = map.get("merchant_Id").toString();
			//String merchantName = map.get("merchantName").toString();
			//VoucherMerchant vm = null;
			/*List vmList = voucher.getVoucherMerchant();
			String merchantId = "";
			String merchantName = "";
			VoucherMerchant vm = null;
			for (int i = 0; i < vmList.size(); i++) {
				vm = (VoucherMerchant) vmList.get(i);
				if (vm.getMerchantId().toString().equals(merchant_Id)) {
					merchantId = vm.getMerchantId().toString();
					merchantName = vm.getMerchantName();
					dataMap.put("merchantName", merchantName);
					dataMap.put("canUserTimes", vm.getCanUseTimes());
					dataMap.put("userTimes", vm.getUseTimes());
					dataMap.put("scenicSpotName", vm.getScenicSpotName());
					map.put("merchant_Id", vm.getMerchantId());
					map.put("merchantName", vm.getMerchantName());
				}
			}*/
			if (!merchantId.equals(merchant_Id)) {
				return result.append("设备与商户信息不匹配!").toString();
			}
			// 判断该凭证是否可以该商户上使用
			if (dataMap.get("canUserTimes").equals(dataMap.get("userTimes"))) {
				return result.append("该").append(type_name).append("在该商户已全部消费!").toString();
			}
			/***
			 * 二次验证（只用于闸机设备）
			 * **/
			if (/*voucher.getIsSeondValid().intValue() == 1 && */cacheEquipment.getEquipmentModel().equals("1")) {
				if (map.get("confirm") == null) {
					
					return result.append(dataMap.get("issecond").toString()).append("#").append(dataMap.get("merchantName")).append("#")
							.append(dataMap.get("voucher_value")).append("#")
							.append(String.valueOf(dataMap.get("max_use_times"))).append("#")
							.append(dataMap.get("order_id").toString()).append("#").append(dataMap.get("voucher_id"))
							.append("#").append(dataMap.get("use_time")).append("#")
							.append(dataMap.get("scenicSpotName")).append("#").append(dataMap.get("goods_name"))
							.append("#").toString().toString();
					// result.append("2").append("#").append("first").append("#").append("该").append(type_name).append("需要二次验证!");
				} else if (map.get("confirm").equals("1")) {
					return result.append("该").append(type_name).append("二次验证失败!").toString();
				}
				/**
				 * 第二次传入时判断
				 * ***/
				/*else if (map.get("confirm").equals("0")) {
					params.put("voucher_id", voucher.getVoucherId().toString());
					params.put("use_time", map.get("use_time").toString());
					params.put("merchant_id",merchant_Id);
					try {
						updateflag = voucherService.modify_voucher_for_verify(params);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					if (updateflag > 0) {
						try {
							Map<String, String> map_terminal = terminalMap(voucher, vm, map, dataMap, terminalManager,
									checking_type);
							terminalManager.addOrUpdate(map_terminal, voucher, map);
							// return printValidateConfirmMsg(dataMap);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				} else {
					return new StringBuilder("通信失败,请重新消费!").toString();
				}*/
				else if (!map.get("confirm").equals("0")) {
					return new StringBuilder("通信失败,请重新消费!").toString();
				}

			}
			/**
			 * 需要二次验证凭证设备类型为POS 的请求处理
			 * ***/
			else if (voucher.getIsSeondValid().intValue() == Constant.IS_SECOND_VALID_YES && cacheEquipment.getEquipmentModel().equals(Constant.EQUIPMENT_MODEL_POS)) {
				return new StringBuilder("该凭证只能用于闸机验证!").toString();
			}
			// 已验证的次数
			int validate_times = Integer.parseInt(voucher.getValidateTimes().toString());
			// 二次验证
			int isSecondValid = Integer.parseInt(voucher.getIsSeondValid().toString());
			// 最大使用次数
			int max_use_times = Integer.parseInt(voucher.getMaxUseTimes().toString());
			// 凭证状态 0：未完全使用 1：已使用 2：过期结算 3：已作废 4:过期退款
			String status = voucher.getStatus().toString();

			// 消费次数
			int expendTimes = max_use_times - validate_times; //

			
			// 未使用或者重打印票
			if ((VoucherConstant.voucher_not_used.equals(status)/* && isSecondValid == Constant.IS_SECOND_VALID_NO*/)
				/*	|| VoucherConstant.voucher_has_used.equals(status)
					|| VoucherConstant.voucher_part_used.equals(status)*/) {

				params.clear();
				params.put("voucher_id", voucher.getVoucherId().toString());
				params.put("use_time", map.get("use_time").toString());
				params.put("validateTimes", String.valueOf(validate_times));
				params.put("merchant_id",merchant_Id);
				// 更新凭票信息

				try {
					updateflag = voucherService.modify_voucher_for_verify(params);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

				dataMap.put("expendTimes", expendTimes);
				dataMap.put("use_time", map.get("use_time").toString());
				dataMap.put("order_id", voucher.getOrderId());
				dataMap.put("voucher_value", voucher.getVoucherValue());
				dataMap.put("validate_times", validate_times);
				dataMap.put("max_use_times", voucher.getMaxUseTimes() - voucher.getFreezeNum() - voucher.getCancelNum());
				dataMap.put("goods_name", voucher.getGoodsName());
				if (updateflag > 0) {
					try {
						Map<String, String> map_terminal = terminalMap(voucher, vm, map, dataMap, terminalManager,
								checking_type);
						terminalManager.addOrUpdate(map_terminal, voucher, map);
					} catch (Exception e) {
						e.printStackTrace();
					}
					return printValidateMsg(dataMap);
				} else {
					return new StringBuilder("通信失败,请重新消费!").toString();
				}

			} else if (VoucherConstant.voucher_expired_retreat.equals(status)) {
				result.append("该").append(type_name).append("已过期,不允许使用!");
			} else if (VoucherConstant.voucher_obsolete.equals(status)) {
				result.append("该").append(type_name).append("已作废,不允许使用!");
			} else if (VoucherConstant.voucher_not_effective.equals(status)) {
				result.append("该").append(type_name).append("凭证未生效!");
			} /*else if (isSecondValid == 1 && cacheEquipment.getEquipmentModel().equals("1")) {
				if (map.get("confirm") == null) {
					result.append("2").append("#").append("该").append(type_name).append("需要二次验证!");
				} else if (map.get("confirm").equals("1")) {
					result.append("该").append(type_name).append("二次验证失败!");
				} else {
					validate_times++;
					// 消费次数
					params.put("voucher_id", voucher.getVoucherId().toString());
					params.put("use_time", map.get("use_time").toString());
					params.put("validateTimes", String.valueOf(validate_times));
					params.put("merchant_id",merchant_Id);
					try {
						updateflag = voucherService.modify_voucher_for_verify(params);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					dataMap.put("order_id", voucher.getOrderId());
					dataMap.put("use_time", map.get("use_time").toString());
					dataMap.put("order_id", voucher.getOrderId());
					dataMap.put("voucher_value", voucher.getVoucherValue());
					dataMap.put("validateTimes", String.valueOf(validate_times));
					dataMap.put("max_use_times",
							voucher.getMaxUseTimes() - voucher.getFreezeNum() - voucher.getCancelNum());
					if (updateflag > 0) {
						try {
							return printValidateConfirmMsg(dataMap);
						} catch (Exception e) {
							e.printStackTrace();
						}
					} else {
						return new StringBuilder("通信失败,请重新消费!").toString();
					}
				}
			}*/
		if (!"".equals(result.toString()))
			return result.toString();
		
		return null;

	} 
	/**
	 * 
	 * 方法用途: 验证凭证的时间有效性<br>
	 * 实现步骤: <br>
	 * @param voucher
	 * @param use_Time_date
	 * @param type_name
	 * @param params
	 * @param map
	 * @return
	 */
	public String checkVality (Voucher voucher, String use_Time_date,
			String type_name, Map<String, String> params, Map<String, String> map) {
		StringBuilder result = new StringBuilder();
		// 最后有效使用时间
		if (DateUtils.parseDate(use_Time_date).after(voucher.getEndDate())) {
			return result.append(type_name).append("已过期,不允许使用!").toString();
		}
		// 开始有效使用时间
		if (DateUtils.parseDate(use_Time_date).before(voucher.getStartDate())) {
			return result.append(type_name).append("未到使用时间,不允许使用!").toString();
		}
		// 允许门票在一天哪个时间段消费
		String totalMinute = DateUtils.getHoursAndMinute(map.get("user_Time_Str").toString());
		String startAllowTime = voucher.getStartExpAllowTime();
		String endAllowTime = voucher.getEndExpAllowTime();
		int startH = Integer.parseInt(startAllowTime) / 60;
		int endH = Integer.parseInt(endAllowTime) / 60;
		if (Integer.parseInt(totalMinute) < Integer.parseInt(startAllowTime)
				&& Integer.parseInt(totalMinute) > Integer.parseInt(endAllowTime)) {
			return result.append("该").append(type_name).append("只允许在")
					.append(String.valueOf(startH) + ":00-" + String.valueOf(endH) + ":00").append("时间段内使用!").toString();
		}
		// 指定门票星期几有效，0全部
		String exp_day_of_week = voucher.getExpDayOfWeek();
		if (exp_day_of_week!=null&&!exp_day_of_week.equals("") && !"0".equals(exp_day_of_week)) {
			String[] arr = exp_day_of_week.split(",");
			Calendar now = Calendar.getInstance();
			now.setTime(DateUtils.StringToDate(map.get("use_time").toString()));
			int week = now.get(Calendar.DAY_OF_WEEK);
			week = week == 1 ? 7 : week - 1;
			boolean flag = false;
			for (int i = 0, length = arr.length; i < length; i++) {
				if (arr[i] != "") {
					if (week == Integer.parseInt(arr[i])) {
						flag = true;
						break;
					}
				}
			}
			if (!flag) {
				return result.append("该").append(type_name).append("只允许在星期").append(exp_day_of_week).append("使用!").toString();
			}
		}
		// 指定在门票有效期内不能使用的时间
		String expExceptionDate = voucher.getExpExceptionDate();
		JSONArray array = null;
		if (expExceptionDate!=null && !expExceptionDate.equals("")) {
			array = JSONArray.fromObject(expExceptionDate);
		}
		if (array != null && !"0".equals(expExceptionDate)) {
			for (int l = 0; l < array.size(); l++) {
				String[] arr = array.get(l).toString().split(",");
				String cur_date = DateUtils.getCurrentDate();
				boolean flag = false;
				for (int i = 0, length = arr.length; i < length; i++) {
					if (cur_date.equals(arr[i])) {
						flag = true;
						break;
					}
				}
				if (flag) {
					result.append("该").append(type_name).append("不允许在").append(cur_date).append("使用。");
					continue;
				}
			}

		}
		return "";
	} 

	/**
	 * 描述：换票
	 * @return 
	 * **/
	public static String changeTicket(VoucherMerchant vm, Map<String, String> dataMap, int checking_type,
			StringBuilder result, TerminalManager terminalManager, int updateflag, IVoucherService voucherService,
			String merchantId, String merchant_Id, Voucher voucher, Map<String, String> map, String use_Time_date,
			String type_name, Map<String, String> params) {

		if (!merchantId.equals(merchant_Id)) {
			result.append("设备与商户信息不匹配!");
		}
		// 最后有效打印时间
		if (DateUtils.parseDate(use_Time_date).after(voucher.getEndDate())) {
			result.append(type_name).append("已过期,不允许打印!");
		}
		params.clear();
		params.put("voucher_value", voucher.getVoucherValue().toString());
		params.put("order_id", voucher.getOrderId().toString());
		params.put("use_time", map.get("use_time").toString());
		params.put("is_ticket", VerifyVoucherController.IS_TITCK);
		// 更新凭票信息
		try {
			updateflag = voucherService.modifyVoucherIsTicket(params);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		dataMap.put("use_time", map.get("use_time").toString());
		dataMap.put("order_id", voucher.getOrderId());
		dataMap.put("voucher_value", voucher.getVoucherValue());
		dataMap.put("goods_name", voucher.getGoodsName());
		dataMap.put("max_use_times",
				String.valueOf(voucher.getMaxUseTimes() - voucher.getFreezeNum() - voucher.getCancelNum()));
		if (updateflag > 0) {
			try {
				Map<String, String> map_terminal = terminalMap(voucher, vm, map, dataMap, terminalManager,
						checking_type);
				terminalManager.addOrUpdateTicket(map_terminal);
				return printValidateMsg(dataMap);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			return new StringBuilder("通信失败,请重新消费!").toString();
		}
		return null;

	}

	public static Map<String, String> terminalMap(Voucher voucher, VoucherMerchant vm, Map<String, String> map,
			Map<String, String> dataMap, TerminalManager terminalManager, int checking_type) {
		float price = Float.valueOf(voucher.getPrice().toString());
		Map<String, String> map_terminal = new HashMap<String, String>();
		// 运营商信息
		map_terminal.put("voucher_value", voucher.getVoucherValue().toString());// 凭证编号
		map_terminal.put("trade_num", map.get("transactionID").toString());// 交易流水号
		map_terminal.put("sales_price", String.valueOf(price));// 销售单价
		map_terminal.put("settlement_price", voucher.getSupplierSettlementPrice().toString());// 结算单价
		map_terminal.put("terminal_num", map.get("deviceid"));// 终端编号
		map_terminal.put("order_num", voucher.getOrderId().toString());// 订单号
		// map_terminal.put("phone", voucher.getSendMobile().toString() == null ? "" : voucher.getSendMobile());// PHONE
		map_terminal.put("merchant_name", vm.getMerchantName());// 运营商名称
		map_terminal.put("use_time", map.get("use_time").toString());// 验证时间
		map_terminal.put("goods_id", voucher.getGoodsId());
		map_terminal.put("oper", map.get("is_reprint").toString());
		map_terminal.put("merchant_id", vm.getMerchantId());
		map_terminal.put("print_times",
				String.valueOf(voucher.getMaxUseTimes() - voucher.getFreezeNum() - voucher.getCancelNum()));
		map_terminal.put("checking_type", String.valueOf(checking_type));
		map_terminal.put("scenic_spot_id", vm.getScenicSpotId());
		map_terminal.put("scenic_spot_name", vm.getScenicSpotName());
		map_terminal.put("goods_name", voucher.getGoodsName());
		map_terminal.put("record_channel", vm.getMerchantName());
		if (checking_type == 2) {
			map_terminal.put("voucher_value", map.get("voucher_value").toString());
		}
		map_terminal.put("batch_no", map.get("batch_no"));
		return map_terminal;
	}
}
