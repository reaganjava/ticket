package com.pj.ebcenter.ticket.pub.constant;

/**
 * <p>Description:凭证状态常量(	0:未生效   1.未使用  2.已使用  ,3:已作废 4：过期可退 5:过期退款 ,6:改期,7.部分使用)</p>
 * @date 2013年10月31日
 * @author 蒋伟
 * @version 1.0
 * <p>Company:Mopon</p>
 * <p>Copyright:Copyright(c)2013</p>
 */
public class VoucherConstant {
	public static String  voucher_not_effective = "0";
	public static String  voucher_not_used = "1";
	public static String  voucher_has_used = "2";
	public static String  voucher_obsolete = "3";
	public static String  voucher_expired_retreat = "4";
	public static String  voucher_expired_refund = "5";
	public static String  voucher_postpone = "6";
	public static String  voucher_part_used = "7";
}
