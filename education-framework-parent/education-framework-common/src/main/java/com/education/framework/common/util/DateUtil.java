package com.education.framework.common.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * 日期工具类。<br>
 *
 * @author zhou jintong
 * @version 1.0
 */
public class DateUtil {
	
	 private static final Logger LOGGER = Logger.getLogger(DateUtil1.class);

     public static final String SIMPLE_FORM = "yyyy-MM-dd";
     public static final String DATE_FULL_PATTERN = "yyyy-MM-dd HH:mm:ss.SSS";
     public static final String DATE_NORMAL_PATTERN = "yyyy-MM-dd HH:mm:ss";
    
     private static final String[] COMMON_DATE_FORMAT = new String[] { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss",
            "yyyy-MM-dd HH:mm:ss.SSS" };
	    
	/**
	 * 按照指定的格式返回日期字符串. 默认 "yyyy-MM-dd"
	 * 
	 * @param Date
	 * @param String
	 */
	public static String formatDate(Date date, String pattern) {
		if (date == null)
			return "";
		if (pattern == null)
			pattern = "yyyy-MM-dd";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return (sdf.format(date));
	}
     /**
	     * 转日期
	     * 
	     * @param date
	     * @param format
	     * @return
	     */
	    public static Date formatToDate(Date date, String format) {
	        if (date != null) {
	            SimpleDateFormat myFormatter = new SimpleDateFormat(format);
	            String prDate = myFormatter.format(date);
	            return parse(prDate, format);
	        }
	        return null;
	    }

	/**
	 * yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 * @return
	 */
	public static String formatDateTime(Date date) {
		return (formatDate(date, "yyyy-MM-dd HH:mm:ss"));
	}

	/**
	 * 当前时间 yyyy-MM-dd HH:mm:ss
	 * 
	 * @return
	 */
	public static String formatDateTime() {
		return (formatDate(now(), "yyyy-MM-dd HH:mm:ss"));
	}

	/**
	 * 当前时间 yyyyMMddHHmmss
	 * 
	 * @return
	 */
	public static String formatDateTime2() {
		return formatDateTime2(now());
	}

	/**
	 * 当前时间 yyyyMMddHHmmss
	 * 
	 * @param 传入参数为时间类型，当入参为null时返回null
	 * @return yyyyMMddHHmmss 时间格式字符串
	 */
	public static String formatDateTime2(Date date) {
		if (date == null) {
			return null;
		}
		return (formatDate(date, "yyyyMMddHHmmss"));
	}

	/**
	 * yyyy-MM-dd
	 * 
	 * @param date
	 * @return
	 */
	public static String formatDate(Date date) {
		return (formatDate(date, "yyyy-MM-dd"));
	}

	/**
	 * 当前日期 yyyy-MM-dd
	 * 
	 * @return
	 */
	public static String formatDate() {
		return (formatDate(now(), "yyyy-MM-dd"));
	}

	/**
	 * 当前日期 yyyyMMdd
	 * 
	 * @return
	 */
	public static String formatDate2() {
		return (formatDate(now(), "yyyyMMdd"));
	}

	/**
	 * HH:mm:ss
	 * 
	 * @param date
	 * @return
	 */
	public static String formatTime(Date date) {
		return (formatDate(date, "HH:mm:ss"));
	}

	/**
	 * 当前时间 HH:mm:ss
	 * 
	 * @return
	 */
	public static String formatTime() {
		return (formatDate(now(), "HH:mm:ss"));
	}

	/**
	 * 当前时间 HHmmss
	 * 
	 * @return
	 */
	public static String formatTime2() {
		return (formatDate(now(), "HHmmss"));
	}

	/**
	 * 当前时间 Date类型
	 * 
	 * @return
	 */
	public static Date now() {
		return (new Date());
	}

	/**
	 * yyyy-MM-dd HH:mm:ss 转Date
	 * 
	 * @param datetime
	 * @return
	 */
	public static Date parseDateTime(String datetime) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if ((datetime == null) || (datetime.equals(""))) {
			return null;
		} else {
			try {
				return formatter.parse(datetime);
			} catch (ParseException e) {
				return parseDate(datetime);
			}
		}
	}

	/**
	 * yyyy-MM-dd 转Date
	 * 
	 * @param date
	 * @return
	 */
	public static Date parseDate(String date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		if ((date == null) || (date.equals(""))) {
			return null;
		} else {
			try {
				return formatter.parse(date);
			} catch (ParseException e) {
				return null;
			}
		}
	}

	public static Date parseDate(String date, String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);

		if ((date == null) || (date.equals(""))) {
			return null;
		} else {
			try {
				return formatter.parse(date);
			} catch (ParseException e) {
				return null;
			}
		}
	}

	public static Date parseDate(Date datetime) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		if (datetime == null) {
			return null;
		} else {
			try {
				return formatter.parse(formatter.format(datetime));
			} catch (ParseException e) {
				return null;
			}
		}
	}

	public static String formatDate(Object o) {
		if (o == null)
			return "";
		if (o.getClass() == String.class)
			return formatDate((String) o);
		else if (o.getClass() == Date.class)
			return formatDate((Date) o);
		else if (o.getClass() == Timestamp.class) {
			return formatDate(new Date(((Timestamp) o).getTime()));
		} else
			return o.toString();
	}

	public static String formatDateTime(Object o) {
		if (o.getClass() == String.class)
			return formatDateTime((String) o);
		else if (o.getClass() == Date.class)
			return formatDateTime((Date) o);
		else if (o.getClass() == Timestamp.class) {
			return formatDateTime(new Date(((Timestamp) o).getTime()));
		} else
			return o.toString();
	}

	/**
	 * 给时间加上或减去指定毫秒，秒，分，时，天、月或年等，返回变动后的时间
	 *
	 * @param date
	 *            要加减前的时间，如果不传，则为当前日期
	 * @param field
	 *            时间域，有Calendar.MILLISECOND,Calendar.SECOND,Calendar.MINUTE,<br>
	 *            Calendar.HOUR,Calendar.DATE, Calendar.MONTH,Calendar.YEAR
	 * @param amount
	 *            按指定时间域加减的时间数量，正数为加，负数为减。
	 * @return 变动后的时间
	 */
	public static Date add(Date date, int field, int amount) {
		if (date == null) {
			date = new Date();
		}

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(field, amount);

		return cal.getTime();
	}

	public static Date addMilliSecond(Date date, int amount) {
		return add(date, Calendar.MILLISECOND, amount);
	}

	public static Date addSecond(Date date, int amount) {
		return add(date, Calendar.SECOND, amount);
	}

	public static Date addMiunte(Date date, int amount) {
		return add(date, Calendar.MINUTE, amount);
	}

	public static Date addHour(Date date, int amount) {
		return add(date, Calendar.HOUR, amount);
	}

	public static Date addDay(Date date, int amount) {
		return add(date, Calendar.DATE, amount);
	}

	public static Date addMonth(Date date, int amount) {
		return add(date, Calendar.MONTH, amount);
	}

	public static Date addYear(Date date, int amount) {
		return add(date, Calendar.YEAR, amount);
	}

	public static Date getDate() {
		return parseDate(formatDate());
	}

	public static Date getDateTime() {
		return parseDateTime(formatDateTime());
	}

	public static boolean between(Date date, int offset, TimeUnit unit) {
		return System.currentTimeMillis() - date.getTime() <= unit.toMillis(offset);
	}

	public static Date addDateHours(Date date,int offset){
		Date temp = now();//取时间
		Calendar   calendar   =   new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(calendar.HOUR_OF_DAY,offset);//把日期往后增加小时数.整数往后推,负数往前移动
		temp = calendar.getTime();   //这个时间就是日期往后增加小时数的结果
		return temp;
	}
	  

	    public static String getCurrentDayAsString() {
	        Calendar c = Calendar.getInstance();
	        DateTimeFormatter fmt = DateTimeFormat.forPattern(SIMPLE_FORM);
	        DateTimeFormatter chinaFmt = fmt.withLocale(Locale.CHINA);
	        return chinaFmt.print(c.getTimeInMillis());
	    }

	    /**
	     * day为天数 日期相加天数和
	     * 
	     * @param date
	     * @param day
	     * @return
	     */
//	    public static Date addDay(Date date, int day) {
//	        if (day < 0) {
//	            return new DateTime(date).minusDays(Math.abs(day)).toDate();
//	        } else {
//	            return new DateTime(date).plusDays(day).toDate();
//	        }
//	    }

	    public static Date addDay(String date, int day) {
	        try {
	            return addDay(DateUtils.parseDate(date, COMMON_DATE_FORMAT), day);
	        } catch (ParseException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

	    public static Date parse(String date) {
	        try {
	            return DateUtils.parseDate(date, COMMON_DATE_FORMAT);
	        } catch (ParseException e) {
	            LOGGER.error("Error to parse string {" + date + "} as date.");
	            throw new IllegalArgumentException("Error to parse string " + date + " as date.");
	        }
	    }

	    public static Date parse(String date, String format) {
	        if (StringUtils.isEmpty(date)) {
	            return null;
	        }
	        try {
	            return new SimpleDateFormat(format).parse(date);
	        } catch (ParseException e) {
	            LOGGER.error("Error to parse string {" + date + "} as date.");
	            throw new IllegalArgumentException("Error to parse string " + date + " as date.");
	        }
	    }

	    /**
	     * @param date
	     * @return
	     */
	    public static Date toStartOfDay(Date date) {
	        return new DateTime(date).withTimeAtStartOfDay().toDate();
	    }

	    /**
	     * 用于VM页面上格式时间 method: DateUtil format
	     * 
	     * @param date
	     * @param format
	     * @return String 创建日期： 2012-10-8 Copyright(C) 2012, by YJH.
	     */
	    public static String format(Date date, String format) {
	        if (date != null) {
	            SimpleDateFormat myFormatter = new SimpleDateFormat(format);
	            return myFormatter.format(date);
	        }
	        return null;
	    }

	  
	    /**
	     * 根据传入的时间加上天数后计算出结果时间
	     * 
	     * @param date
	     * @param amount
	     * @return
	     */
	    public static Date addDate(Date date, int amount) {
	        GregorianCalendar calendar = new GregorianCalendar();
	        calendar.setTime(date);
	        calendar.add(Calendar.DATE, amount);
	        return new Date(calendar.getTime().getTime());
	    }

	    /**
	     * 根据传入的时间加上月数后计算出结果时间
	     * 
	     * @param date
	     * @param amount
	     * @return
	     */
//	    public static Date addMonth(Date date, int amount) {
//	        return new DateTime(date).plusMonths(amount).toDate();
//	    }

	    /**
	     * * 两个时间之间的天数
	     * 
	     * @param startDate
	     * @param endDate
	     * @return
	     */
	    public static long getDaysBetween(Date startDate, Date endDate) {
	        return Days.daysBetween(new DateTime(startDate).withTimeAtStartOfDay(),
	                new DateTime(endDate).withTimeAtStartOfDay()).getDays();
	    }

	    /**
	     * 获取年份
	     * 
	     * @param date
	     * @return
	     */
	    public static int getYear(Date date) {
	        if (date == null) {
	            return new DateTime().getYear();
	        } else {
	            return new DateTime(date).getYear();
	        }
	    }

	    /**
	     * 获取月份
	     * 
	     * @param date
	     * @return
	     */
	    public static int getMonth(Date date) {
	        if (date == null) {
	            return new DateTime().getMonthOfYear();
	        } else {
	            return new DateTime(date).getMonthOfYear();
	        }

	    }

	    /**
	     * 获取天
	     * 
	     * @param date
	     * @return
	     */
	    public static int getDay(Date date) {
	        if (date == null) {
	            return new DateTime().getDayOfMonth();
	        } else {
	            return new DateTime(date).getDayOfMonth();
	        }
	    }

	    /**
	     * 获取小时
	     * 
	     * @param date
	     * @return
	     */
	    public static int getHour(Date date) {
	        if (date == null) {
	            return new DateTime().getHourOfDay();
	        } else {
	            return new DateTime(date).getHourOfDay();
	        }
	    }

	    /**
	     * 获取分钟
	     * 
	     * @param date
	     * @return
	     */
	    public static int getMin(Date date) {
	        if (date == null) {
	            return new DateTime().getMinuteOfHour();
	        } else {
	            return new DateTime(date).getMinuteOfHour();
	        }
	    }

	    /**
	     * 判断一个如期是否在两个日期之间，算头不算尾 test<=begin && test<end
	     * 
	     * @author wangyong08
	     * @date 20150710
	     * @param Date
	     *            test 被判断的日期
	     * @param Date
	     *            begin 开始日期
	     * @param Date
	     *            end 结束日期
	     */
	    public static boolean isBetween(Date test, Date begin, Date end) {

	        Date realBegin = DateUtil1.addDay(begin, -1);
	        if (test.after(realBegin) && test.before(end)) {
	            return true;
	        } else {
	            return false;
	        }
	    }

	    /**
	     * 日期比较函数
	     * 
	     * @author wangyong08
	     * @param dateFirst
	     * @param dateSecond
	     * @return
	     */
	    public static int dateCompare(Date dateFirst, Date dateSecond) {
	        long first = dateFirst.getTime();
	        long second = dateSecond.getTime();
	        if (first > second) {
	            return 1;
	        } else if (first < second) {
	            return -1;
	        } else {
	            return 0;
	        }
	    }

	    /**
	     * 获取两个日期之间的天数差，second - first
	     * 
	     * @param first
	     *            减数
	     * @param second
	     *            被减数
	     * @return
	     */
	    public static int daysBetween(Date first, Date second) {
	        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	        try {
	            first = df.parse(df.format(first));
	            second = df.parse(df.format(second));
	            Calendar cale = Calendar.getInstance();
	            cale.setTime(first);
	            long timeFirst = cale.getTimeInMillis();
	            cale.setTime(second);
	            long timeSecond = cale.getTimeInMillis();
	            long days = (timeSecond - timeFirst) / (1000 * 3600 * 24);
	            return Integer.parseInt(String.valueOf(days));
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	        return 0;
	    }

	    /**
	     * 格式化标准的YYYY-MM-DD
	     * 
	     * @param Date
	     *            date
	     * @throws ParseException
	     */
	    public static Date getFormalYMD(Date date) throws ParseException {
	        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	        String tmp = format.format(date);
	        date = format.parse(tmp);
	        return date;
	    }

	    /**
	     * 判断一个日期是否是当天
	     * 
	     * @param Date
	     *            date
	     */
	    @SuppressWarnings("deprecation")
	    public static boolean isToday(Date date) {
	        Date now = new Date();
	        if (date.getYear() == now.getYear() && date.getMonth() == now.getMonth() && date.getDay() == now.getDay()) {
	            return true;
	        }
	        return false;
	    }

	    /**
	     * 得到今天的开始时间
	     * 
	     * @return String
	     */
	    @SuppressWarnings("deprecation")
	    public static String getTodayStartTime() {
	        Calendar todayStart = Calendar.getInstance();
	        todayStart.set(Calendar.HOUR, 0);
	        todayStart.set(Calendar.MINUTE, 0);
	        todayStart.set(Calendar.SECOND, 0);
	        todayStart.set(Calendar.MILLISECOND, 0);
	        return todayStart.getTime().toLocaleString();
	    }

	    /**
	     * 得到今天的最后时间
	     * 
	     * @return String
	     */
	    @SuppressWarnings("deprecation")
	    public static String getTodayEndTime() {
	        Calendar todayEnd = Calendar.getInstance();
	        todayEnd.set(Calendar.HOUR, 23);
	        todayEnd.set(Calendar.MINUTE, 59);
	        todayEnd.set(Calendar.SECOND, 59);
	        todayEnd.set(Calendar.MILLISECOND, 999);
	        return todayEnd.getTime().toLocaleString();
	    }

	    /**
	     * 得到指定日期的开始时间
	     * 
	     * @return String
	     */
	    public static Date getTheDayStartTime(Date date) {
	        Calendar todayStart = Calendar.getInstance();
	        todayStart.setTime(date);
	        todayStart.set(Calendar.HOUR, 0);
	        todayStart.set(Calendar.MINUTE, 0);
	        todayStart.set(Calendar.SECOND, 0);
	        todayStart.set(Calendar.MILLISECOND, 0);
	        return todayStart.getTime();
	    }

	    /**
	     * 得到指定日期的最后时间
	     * 
	     * @return String
	     */
	    public static Date getTheDayEndTime(Date date) {
	        Calendar c2 = new GregorianCalendar();
	        c2.setTime(date);
	        c2.set(Calendar.HOUR_OF_DAY, 23);
	        c2.set(Calendar.MINUTE, 59);
	        c2.set(Calendar.SECOND, 59);
	        return c2.getTime();
	    }

	    /**
	     * 得到指定年的最后时间
	     * 
	     * @return String
	     */
	    public static Date getTheYearEndTime(int year) {
	        Calendar calendar = Calendar.getInstance();
	        calendar.clear();
	        calendar.set(Calendar.YEAR, year);
	        calendar.roll(Calendar.DAY_OF_YEAR, -1);
	        Date currYearLast = calendar.getTime();
	        return calendar.getTime();
	    }

	    /**
	     * 得到指定月的最后时间
	     * 
	     * @return String
	     */
	    public static Date getTheMonthEndTime(Date date) {
	        Calendar c2 = new GregorianCalendar();
	        c2.setTime(date);
	        c2.add(Calendar.MONTH, 1);
	        c2.set(Calendar.DAY_OF_MONTH, 1);
	        c2.add(Calendar.DATE, -1);
	        return c2.getTime();
	    }

	    /**
	     * 获得指定小时的最后时间
	     * 
	     * @param date
	     * @return
	     */
	    public static Date getTheHourEndTime(Date date) {
	        Calendar c2 = new GregorianCalendar();
	        c2.setTime(date);
	        c2.set(Calendar.MINUTE, 59);
	        c2.set(Calendar.SECOND, 59);
	        return c2.getTime();
	    }

	    /**
	     * 获得指定分钟的最后时间
	     * 
	     * @param date
	     * @return
	     */
	    public static Date getTheMinEndTime(Date date) {
	        Calendar c2 = new GregorianCalendar();
	        c2.setTime(date);
	        c2.set(Calendar.SECOND, 59);
	        return c2.getTime();
	    }

	    /**
	     * 比较日期的大小(日期以格式yyyy-MM-dd进行比较)
	     * 
	     * @date 2015-07-31 10:10
	     * @param dateFirstStr
	     * @param dateSecond
	     * @return 1:dateFirstStr>dateSecond; -1:dateFirstStr<dateSecond;
	     *         0:dateFirstStr=dateSecond;
	     */
	    public static int doCompareTo(String dateFirstStr, Date dateSecond) {
	        Date dateFirst = DateUtil1.parse(dateFirstStr, DateUtil1.SIMPLE_FORM);
	        Date newDateSecond = DateUtil1.parse(DateUtil1.format(dateSecond, DateUtil1.SIMPLE_FORM), DateUtil1.SIMPLE_FORM);
	        int num = DateUtil1.dateCompare(dateFirst, newDateSecond);
	        if (num == 1) {
	            return 1;
	        } else if (num == -1) {
	            return -1;
	        }
	        return 0;
	    }

	    /**
	     * 计算账单日
	     * 
	     * @param busTime
	     * @param billDay
	     * @return
	     */
	    public static Date getBillDate(Date busTime, int billDay) {
	        if (DateUtil1.getDay(busTime) > billDay) {
	            return DateUtil1.parse(DateUtil1.getYear(busTime) + "-" + (DateUtil1.getMonth(null) + 1) + "-" + billDay,
	                    "yyyy-MM-dd");
	        } else {
	            return DateUtil1.parse(DateUtil1.getYear(busTime) + "-" + DateUtil1.getMonth(null) + "-" + billDay,
	                    "yyyy-MM-dd");
	        }
	    }

	    /**
	     * 获取num个月前的时间
	     * 
	     * @param date
	     * @param num
	     * @return
	     */
	    public static Date getNewMonth(Date date, int num) {
	        Calendar c = Calendar.getInstance();
	        c.setTime(date);
	        c.add(c.MONTH, num);
	        return c.getTime();
	    }

	    /**
	     * 获取num天前的时间
	     * 
	     * @param date
	     * @param num
	     * @return
	     */
	    public static Date getNewDay(Date date, int num) {
	        Calendar c = Calendar.getInstance();
	        c.setTime(date);
	        c.add(c.DAY_OF_MONTH, num);
	        return c.getTime();
	    }

	    /**
	     * 获取num小时的时间
	     * 
	     * @param date
	     * @param num
	     * @return
	     */
	    public static Date getNewHour(Date date, int num) {
	        Calendar c = Calendar.getInstance();
	        c.setTime(date);
	        c.add(c.HOUR_OF_DAY, num);
	        return c.getTime();
	    }

	    /**
	     * 获取num分钟前的时间
	     * 
	     * @param date
	     * @param num
	     * @return
	     */
	    public static Date getNewMin(Date date, int num) {
	        Calendar c = Calendar.getInstance();
	        c.setTime(date);
	        c.add(c.MINUTE, num);
	        return c.getTime();
	    }

	    /**
	     * 构造时间，是时间的分钟是10的倍数
	     * 
	     * @param date
	     * @return
	     */
	    public static Date structTime(Date date) {
	        Calendar c = Calendar.getInstance();
	        c.setTime(date);
	        // 获取分钟
	        int num = DateUtil1.getMin(date);
	        if (num < 10) {
	            c.set(Calendar.MINUTE, 00);
	        } else if (num < 20) {
	            c.set(Calendar.MINUTE, 10);
	        } else if (num < 30) {
	            c.set(Calendar.MINUTE, 20);
	        } else if (num < 40) {
	            c.set(Calendar.MINUTE, 30);
	        } else if (num < 50) {
	            c.set(Calendar.MINUTE, 40);
	        } else if (num >= 50) {
	            c.set(Calendar.MINUTE, 50);
	        }
	        return c.getTime();
	    }

}