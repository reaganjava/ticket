package com.pj.ebcenter.manager.hq.constant;

/**
 * <p>Description: </p>
 * @date 2013年11月25日
 * @author 蒋伟
 * @version 1.0
 * <p>Company:Mopon</p>
 * <p>Copyright:Copyright(c)2013</p>
 */
public interface StatusCode {

	/**
	 * 成功
	 */
	public String CODE_SUCCESS = "200";

	/**
	 * {@link #CODE_SUCCESS} 对应的错误消息
	 */
	public String MESSAGE_CODE_SUCCESS = "成功";
	public String MESSAGE_CODE_SUCCESS_UPDATE = "更新成功";
	public String MESSAGE_CODE_SUCCESS_CREATE = "新增成功";
	public String MESSAGE_CODE_SUCCESS_NO_DO = "提交数据与当前数据相同，无需操作";
	/**
	 * 系统数据错误
	 */
	public String CODE_ERROR_SYSTEM_DATA = "210";

	/**
	 * {@link #MESSAGE_CODE_ERROR_SYSTEM_DATA} 对应的错误消息
	 */
	public String MESSAGE_CODE_ERROR_SYSTEM_DATA = "系统数据错误";

	/**
	 * 系统错误
	 */
	public String CODE_ERROR_SYSTEM = "211";

	/**
	 * {@link #CODE_ERROR_SYSTEM} 对应的错误消息
	 */
	public String MESSAGE_CODE_ERROR_SYSTEM = "系统错误";

	/**
	 * 解析报文XML异常
	 */
	public String CODE_PARSE_XML_ERROR = "220";

	/**
	 * {@link #CODE_PARSE_XML_ERROR} 对应的错误消息
	 */
	public String MESSAGE_CODE_PARSE_XML_ERROR = "解析报文异常";

	/**
	 * 解析报文XML异常
	 */
	public String CODE_SIGNED_ERROR = "230";

	/**
	 * {@link #CODE_SIGNED_ERROR} 对应的错误消息
	 */
	public String MESSAGE_CODE_SIGNED_ERROR = "签名错误";

	/**
	 * 传入的凭证值在系统部存在
	 */
	public String CODE_VOUCHER_NOT_FOUND = "212";

	/**
	 * {@link #CODE_VOUCHER_NOT_FOUND} 对应的错误消息
	 */
	public String MESSAGE_CODE_VOUCHER_NOT_FOUND = "凭证值为空!";

	/**
	 * XML参数内容不正确
	 */
	public String CODE_PARAMETER_ERROR="234";
	/**
	 * {@link #CODE_PARAMETER_ERROR} 对应的错误消息
	 */
	public String MESSAGE_CODE_PARAMETER_ERROR="XML参数内容不正确";
	/**
	 * 报文的版本
	 */
	public String XML_VERSION = "1";

	interface Code {
		String error_code = "400"; // 没有找到改凭证记录!
		String success_code = "200";// 成功返回!
	}

	interface Message {
		String message_error_code = "没有找到改凭证记录!";
	}

	interface Voucher {
		int voucher_not_effective = 0;// 未生效
		int voucher_not_used = 1;// 未使用
		int voucher_has_used = 2;// 已使用
		int voucher_obsolete = 3;// 已作废
		int voucher_expired_retreat = 4;// 过期可退
		int voucher_expired_refund = 5;// 过期退款
		int voucher_postpone = 6;// 改期
	}

	interface VoucherText {
		String voucher_not_effective = "未生效";// 未生效
		String voucher_not_used = "未使用";// 未使用
		String voucher_has_used = "已使用";// 已使用
		String voucher_obsolete = "已作废";// 已作废
		String voucher_expired_retreat = " 过期可退";// 过期可退
		String voucher_expired_refund = "过期退款";// 过期退款
		String voucher_postpone = "改期";// 改期
	}
}
