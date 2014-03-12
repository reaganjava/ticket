/**
 * 版权 (c) 2010 公司名称
 * 保留所有权利。
 */

package com.pj.ebcenter.manager.hq.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.SimpleTimeZone;

import org.apache.commons.lang.StringUtils;

/**
 * 描述：日期处理常用类
 * 
 * @author guosl 创建时间：Jan 13, 2010
 */

public class DateUtils {
	public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	public static SimpleDateFormat dateFormatTODB = new SimpleDateFormat("yyyyMMdd");
	public static SimpleDateFormat dateFormatMess = new SimpleDateFormat("yyyy/MM/dd");
	public static SimpleDateFormat dataTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static SimpleDateFormat dateFormat_sss = new SimpleDateFormat("yyyyMMddHHmmsssss");

	/**
	 * 
	 * 方法用途:格式化日期：yyyyMMddHHmmsssss <br>
	 * 实现步骤: <br>
	 * @param date
	 * @return
	 */
	public static String fromatDate(Date date, SimpleDateFormat sdf) {
		date = (date == null ? getCurTime() : date);

		sdf = (sdf == null ? dateFormat_sss : sdf);
		return sdf.format(date);
	}

	public static Date getCurTime() {
		return new Date();
	}

	/**
	 * 
	 * 功能：解析数据库中的日期字符串 格式:yyyy-MM-dd
	 * 
	 * @param dateStr
	 * @return
	 */
	public static Date parseDate(String dateStr) {
		Date date = null;
		try {
			date = dateFormat.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 
	 * 功能：格式化日期字符串 例如：2008-8-8 转换为2008-08-08
	 * 
	 * @param dateStr
	 * @return
	 */
	public static String getDateStrFormat(String dateStr) {
		try {
			Date date = dateFormat.parse(dateStr);
			return dateFormat.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * 功能：解析数据库中的时间字符串 格式:yyyy-MM-dd HH:mm:ss
	 * 
	 * @param dateStr
	 * @return
	 */
	public static Date parseDateTime(String dateTimeStr) {
		Date date = null;
		try {
			date = dataTimeFormat.parse(dateTimeStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 
	 * 功能：解析数据库中的时间字符串 格式:yyyy/MM/dd HH:mm:ss
	 * 
	 * @param dateStr
	 * @return
	 */
	public static Date parseDateTimeToMess(String dateTimeStr) {
		Date date = null;
		try {
			date = dateFormatMess.parse(dateTimeStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 计算两个日期之间的天数
	 * 
	 * @param startDate
	 *          开始时间
	 * @param endDate
	 *          结束时间
	 * @return
	 */
	public static int calcDays(String startDate, String endDate) {
		int days = 1;
		try {
			long start = dateFormat.parse(startDate).getTime();
			long end = dateFormat.parse(endDate).getTime();
			days = (int) ((end - start) / (24 * 60 * 60 * 1000));
		} catch (ParseException e) {
			e.printStackTrace();
			return -1;
		}
		return days;
	}

	/**
	 * 计算两个日期之间的天数
	 * 
	 * @param startDate
	 *          开始时间
	 * @param endDate
	 *          结束时间
	 * @return
	 */
	public static long calcDaysTime(String startDate, String endDate) {
		long days = 1;
		try {
			long start = dataTimeFormat.parse(startDate).getTime();
			long end = dataTimeFormat.parse(endDate).getTime();
			days = (end - start);
		} catch (ParseException e) {
			e.printStackTrace();
			return -1;
		}
		return days;
	}

	/**
	 * 功能：指定日期加上指定天数
	 * 
	 * @param date
	 *          日期
	 * @param day
	 *          天数
	 * @return 返回相加后的日期
	 */
	public static Date addDate(Date date, int day) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(getMillis(date) + ((long) day) * 24 * 3600 * 1000);
		return c.getTime();
	}

	/**
	 * 功能：指定日期减去指定天数
	 * 
	 * @param date
	 * @param day
	 * @return
	 */
	public static Date diffDate(Date date, int day) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(getMillis(date) - ((long) day) * 24 * 3600 * 1000);
		return c.getTime();
	}

	/**
	 * 功能：指定日期加上指定分钟
	 * 
	 * @param date
	 *          日期
	 * @param minute
	 *          分钟
	 * @return 返回相加后的日期
	 */
	public static Date addMinute(Date date, int minute) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(getMillis(date) + (minute * 60 * 1000));
		return c.getTime();
	}

	/**
	 * 
	 * 功能：分钟相差 minute的时间值
	 * 
	 * @param date
	 * @param minute
	 * @return
	 */
	public static Date getDateByMinuteAdd(Date date, int minute) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, minute);
		return calendar.getTime();
	}

	/**
	 * 功能:两个日期相隔天数
	 * 
	 * @param startDate
	 *          开始日期
	 * @param endDate
	 *          结束日期
	 * @return 返回相减后的日期
	 */
	public static int diffDate(Date startDate, Date endDate) {
		return (int) ((getMillis(endDate) - getMillis(startDate)) / (24 * 3600 * 1000));
	}

	/**
	 * 功能：传入时间按所需格式返回时间字符串
	 * 
	 * @param date
	 *          java.util.Date格式
	 * @param format
	 *          yyyy-MM-dd HH:mm:ss | yyyy年MM月dd日 HH时mm分ss秒
	 * @return
	 */
	public static String format(Date date, String format) {
		String result = "";
		try {
			if (date == null) {
				date = new Date();// 如果时间为空,则默认为当前时间
			}
			if (StringUtils.isBlank(format)) {// 默认格式化形式
				format = "yyyy-MM-dd";
			}
			DateFormat df = new SimpleDateFormat(format);
			result = df.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 功能：传入时间字符串按所需格式返回时间
	 * 
	 * @param dateStr
	 *          时间字符串
	 * @param format
	 *          跟传入dateStr时间的格式必须一样 yyyy-MM-dd HH:mm:ss | yyyy年MM月dd日 HH时mm分ss秒
	 * @return
	 * @throws ParseException
	 */
	public static Date format(String dateStr, String format) throws ParseException {
		if (StringUtils.isBlank(dateStr)) {
			return new Date();
		}
		if (StringUtils.isBlank(format)) {
			format = "yyyy-MM-dd";
		}
		Date date = null;
		DateFormat f = new SimpleDateFormat(format);
		date = f.parse(dateStr);
		return date;

	}

	/**
	 * 功能：时间字符串格式转换
	 * 
	 * @param dateStr
	 *          时间字符串
	 * @param format
	 *          时间字符串的格式
	 * @param toFormat
	 *          格式为的格式
	 * @return
	 * @throws ParseException
	 */
	public static String format(String dateStr, String format, String toFormat) throws ParseException {
		return format(format(dateStr, format), toFormat);
	}

	/**
	 * 功能：格式化rss的时间 输入:
	 * 
	 * @param date
	 * @return
	 */
	public static String formatRssDate(Date date) {
		if (date == null) {
			date = new Date();// 如果时间为空,则默认为当前时间
		}
		SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
		SimpleTimeZone zone = new SimpleTimeZone(8, "GMT");
		sdf.setTimeZone(zone);
		return sdf.format(date);
	}

	/**
	 * 功能：返回年
	 * 
	 * @param date
	 * @return
	 */
	public static int getYear(Date date) {
		if (date == null) {
			date = new Date();
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.YEAR);

	}

	/**
	 * 功能：返回短格式的年,如2011年,返回11
	 * 
	 * @param date
	 * @return
	 */
	public static int getSimpleYear(Date date) {
		String year = String.valueOf(getYear(date));
		return Integer.parseInt(year.substring(2, 4));
	}

	/**
	 * 功能：返回月
	 * 
	 * @param date
	 * @return
	 */
	public static int getMonth(Date date) {
		if (date == null) {
			date = new Date();
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.MONTH) + 1;
	}

	/**
	 * 功能：返回日
	 * 
	 * @param date
	 * @return
	 */
	public static int getDay(Date date) {
		if (date == null) {
			date = new Date();
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 功能：返回小时
	 * 
	 * @param date
	 * @return
	 */
	public static int getHour(Date date) {
		if (date == null) {
			date = new Date();
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * 功能：返回分
	 * 
	 * @param date
	 * @return
	 */
	public static int getMinute(Date date) {
		if (date == null) {
			date = new Date();
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.MINUTE);
	}

	/**
	 * 功能：返回星期 1：星期一，2:星期二 ... 6:星期六 7:星期日
	 * 
	 * @param date
	 * @return
	 */
	public static int getChinaWeek(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int week = c.get(Calendar.DAY_OF_WEEK) - 1;
		if (week == 0) {
			return 7;
		} else {
			return week;
		}
	}

	/**
	 * 功能：返回秒
	 * 
	 * @param date
	 * @return
	 */
	public static int getSecond(Date date) {
		if (date == null) {
			date = new Date();
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.SECOND);
	}

	/**
	 * 功能：返回毫秒
	 * 
	 * @param date
	 * @return
	 */
	public static long getMillis(Date date) {
		if (date == null) {
			date = new Date();
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.getTimeInMillis();
	}

	/**
	 * 功能：获取当前月的第一天日期
	 * 
	 * @return
	 */
	public static Date getMonFirstDay() {
		Date date = new Date();
		Calendar c = Calendar.getInstance();
		c.set(getYear(date), getMonth(date) - 1, 1);
		return c.getTime();
	}

	/**
	 * 功能：获取当前月的最后一天日期
	 * 
	 * @return
	 */
	public static Date getMonLastDay() {
		Date date = new Date();
		Calendar c = Calendar.getInstance();
		c.set(getYear(date), getMonth(date), 1);

		c.setTimeInMillis(c.getTimeInMillis() - (24 * 3600 * 1000));
		return c.getTime();
	}

	/**
	 * 功能：获取当前日期 格式:2008-02-02 23:11:10
	 * 
	 * @return
	 */
	public static String getCurrentDateTime() {
		Date date = new Date();
		return dataTimeFormat.format(date);
	}

	/**
	 * 功能：获取当前日期 格式:2010-10-10
	 * 
	 * @return
	 */
	public static String getCurrentDate() {
		Date date = new Date();
		return dateFormat.format(date);
	}

	/**
	 * 功能：获取当前日期 格式:20101010
	 * 
	 * @return
	 */
	public static String getCurrentDateTODB() {
		Date date = new Date();
		return dateFormatTODB.format(date);
	}

	/**
	 * 将星期几反转
	 * @param weeks
	 * @return
	 */
	public static String getWeekByDay(String weeks) {
		StringBuffer result = new StringBuffer();
		StringBuffer results = new StringBuffer();
		String resultss = new String();
		List<String> temp = new ArrayList<String>();
		if (null != weeks && !"".equals(weeks)) {
			if (!"0".equals(weeks)) {
				if (weeks.contains("7")) {
					weeks = weeks.replace("7", "0");
				}

				String[] s = weeks.split(",");
				String[] ss = new String[] { "0", "1", "2", "3", "4", "5", "6" };
				for (int j = 0; j < ss.length; j++) {
					for (int i = 0; i < s.length; i++) {
						if (s[i].equals(ss[j])) {
							result.append(j).append(",");
							break;
						}
					}

					temp.add(ss[j]);
				}

				if (null != result) {
					String[] t = result.toString().split(",");
					for (int i = 0; i < t.length; i++) {
						temp.remove(t[i]);
					}
				}

				if (null != temp) {
					for (int i = 0; i < temp.size(); i++) {
						results.append(temp.get(i)).append(",");
					}
				}

				if (null != results) {
					if (results.lastIndexOf(",") > 0) {
						resultss = results.toString().substring(0, results.lastIndexOf(","));
					}

					if (resultss.contains("0")) {
						resultss = resultss.replace("7", "0");
					}
				}

			} else {
				resultss = "0";
			}

		}

		if ("".equals(resultss)) {
			resultss = "0";
		}

		return resultss;
	}

	/**
	 * 将日期加上单引号
	 * @param dates
	 * @return
	 */
	public static String getSysmbol(String dates) {
		StringBuffer sb = new StringBuffer();
		if (null != dates && !"".equals(dates)) {
			String[] date = dates.split(",");
			for (int i = 0; i < date.length; i++) {
				if (i == date.length - 1) {
					sb.append("'").append(date[i]).append("'");

				} else {
					sb.append("'").append(date[i]).append("'").append(",");
				}

			}
		}
		return sb.toString();
	}

	/**
	 * 得到相邻日期内的包含星期几的总日期数.
	 * @param startDate
	 * @param endDate
	 * @param weeks
	 * @return
	 */
	public static String getDates(String startDate, String endDate, String weeks) {
		StringBuffer sb = new StringBuffer();
		Calendar cs = Calendar.getInstance();
		cs.setTime(parseDate(startDate));

		Calendar ce = Calendar.getInstance();
		ce.setTime(parseDate(endDate));

		int days = diffDate(cs.getTime(), ce.getTime());
		// System.out.println("相差天数年是:" + days + ",起始时间是:" + format(cs.getTime(),"yyyy-MM-dd") + ",结束时间是:" +
		// format(ce.getTime(),"yyyy-MM-dd"));
		// 求星期二星期四对应的日期

		if (null != weeks && !"".equals(weeks)) {
			if (weeks.contains("0")) {
				weeks = weeks.replace("0", "7");
			}
			String[] s = weeks.split(",");
			for (int j = 0; j < s.length; j++) {
				cs.setTime(parseDate(startDate));
				for (int i = 0; i < days; i++) {
					cs.set(Calendar.DAY_OF_MONTH, cs.get(Calendar.DAY_OF_MONTH) + 1);
					// System.out.println("当时日期是:"+format(cs.getTime(),"yyyy-MM-dd"));
					// System.out.println("星期:"+s[j]);

					if (Integer.parseInt(s[j]) == getChinaWeek(cs.getTime())) {
						// System.out.println("星期二的日期是:" + format(cs.getTime(),"yyyyMMdd"));
						sb.append(format(cs.getTime(), "yyyy-MM-dd")).append(",");
					}
				}
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) throws ParseException {

		System.out.println(fromatDate(null, null));
		/*
		 * String dateStr = "1899-12-30 16:30:32"; System.out.println(DateUtils.parseDateTime(dateStr));
		 * 
		 * System.out.println(DateUtils.format("1109", "MMyy", "MM/yy")); System.out.println(format(getMonFirstDay(),
		 * "yyyy-MM-dd"));
		 */
		// System.out.println(getDateStrFormat("1982-8-5"));
		// System.out.println(calcDays("2010-08-01","2010-08-02"));
		/*
		 * Date d = parseDate("2010-10-10"); int i = getChinaWeek(d); System.out.println(i);
		 */
		/*
		 * String period = "2010-10-08,2010-10-31|2010-10-03,2010-10-06|2010-09-01,2010-09-29"; String[] startEndDateArr
		 * = period.split("\\|");
		 * 
		 * for(int i=0;i<startEndDateArr.length;i++){ System.out.println(i+"==="+startEndDateArr[i]); }
		 */
		/*
		 * String[] firstSecondDateStr = "2010-10-08,".split(",");
		 * 
		 * for(int i=0;i<firstSecondDateStr.length;i++){ System.out.println(i+"==="+firstSecondDateStr[i]); }
		 */

		// System.out.println(getCurrentDateTODB());
		// System.out.println("dd:"+getWeekByDay("1,2,6"));
		// System.out.println("dd:"+getSysmbol("2013-06-07,2013-06-12,2013-06-19"));

		// DateFormat df = DateFormat.getDateInstance();
		// try {
		// System.out.println(format(addDate(df.parse("2013-06-05 17:07:40"),30),"yyyy/MM/dd"));
		// } catch (ParseException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		// System.out.println(format(parseDateTime("2013-06-05 17:07:40"),"yyyy/MM/dd"));
		//
		// System.out.println(getChinaWeek(new Date()));
		//
		// Calendar cs = Calendar.getInstance();
		// cs.setTime(parseDateTime("2013-06-05 17:07:40"));
		//
		// Calendar ce = Calendar.getInstance();
		// ce.setTime(parseDateTime("2013-06-25 17:07:40"));
		//
		// int days = diffDate(cs.getTime(),ce.getTime());
		// System.out.println("相差天数年是:" + days + ",起始时间是:" + cs.getTime() + ",结束时间是:" + ce.getTime());
		// //求星期二星期四对应的日期
		// for(int i=0;i<days;i++)
		// {
		// cs.set(Calendar.DAY_OF_MONTH, cs.get(Calendar.DAY_OF_MONTH)+1);
		// // System.out.println(format(cs.getTime(),"yyyyMMdd"));
		// // System.out.println("星期:"+getChinaWeek(cs.getTime()));
		//
		// if(2 == getChinaWeek(cs.getTime()))
		// {
		// System.out.println("星期二的日期是:" + format(cs.getTime(),"yyyyMMdd"));
		// }
		// }

		// System.out.println(getDates("2013-06-20","2013-07-20","0,2,6"));
		System.out.println(DateUtils.format(DateUtils.parseDateTime("2013-06-20 13:40:88"), "yyyy/MM/dd"));

		// for (int i = 0; i < 469; i++) {
		// String end_date = "2013-08-13 22:30:00";
		// Calendar now = Calendar.getInstance();
		// String now_date = DateUtils.format(now.getTime(), "yyyy-MM-dd HH:mm:ss");
		//
		// // 判断结束时间 是否<=当前时间.
		// long day = DateUtils.calcDaysTime(end_date, now_date);
		// if (day >= 0) {
		// System.out.println(day +":"+true);
		// }
		// else
		// {
		// System.out.println(day +":"+ false);
		// }
		// }

	}
}
