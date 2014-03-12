package com.pj.ebcenter.manager.hq.constant;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>Copyright:Copyright(c)2012</p>
 * <p>Company:Mopon</p>
 * @date 2013年11月22日
 * @author 王方威
 * @version 1.0
 */
public class DateUtil {

	public static SimpleDateFormat dateFormat_sss = new SimpleDateFormat("yyyyMMddHHmmsssss");

	public static String fromatDate(Date date, SimpleDateFormat sdf) {
		
		date = (date == null ? getCurTime() : date);
		sdf = (sdf == null ? dateFormat_sss : sdf);
		return sdf.format(date);
	}

	public static Date getCurTime() {
		return new Date();
	}
}
