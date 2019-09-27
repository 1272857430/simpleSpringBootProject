package com.modal.common.utils.dataTimeUtils;

import com.modal.common.utils.simpleUtils.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@SuppressWarnings("unused")
public class DateUtil
{
    private static final long TicksPerSecond = 1000;

    private static final long TicksPerMinute = TicksPerSecond * 60;

    private static final long TicksPerHour = TicksPerMinute * 60;

    private static final long TicksPerDay = TicksPerHour * 24;

    private static final long LangTicksDifference = 62135625600000L;

    private static final int MinYear = 1;

    private static final int MaxYear = 9999;

    public static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    
    public static final String FORMAT_YYYYMMDDHHMMSS = "yyyyMMddHHmmss"; //20170105223502
    
    public static final String FORMAT_YYYYMMDD = "yyyyMMdd"; //20170105
    
    public static List<String> workDateList = new ArrayList<String>();
    
    public static List<String> noWorkDateList = new ArrayList<String>();
    
    static{
        //1月22日（星期日）、2月4日（周六）上班     4月1日（周六）上班 5月27日（星期六）上班 9月30日（星期六）上班  
        workDateList.add("2017-01-22");
        workDateList.add("2017-02-04");
        workDateList.add("2017-04-01");
        workDateList.add("2017-05-27");
        workDateList.add("2017-09-30");
        /**
                    清明节 4月2日~4月4日     共3天
                    劳动节 4月29日~5月1日  与周末连休   共3天
                    端午节 5月28日~5月30日 
                    国庆节 10月1日~10月8日 
         */
        noWorkDateList.add("2017-01-25");
        noWorkDateList.add("2017-01-26");
        noWorkDateList.add("2017-01-27");
        noWorkDateList.add("2017-01-28");
        noWorkDateList.add("2017-01-29");
        noWorkDateList.add("2017-01-30");
        noWorkDateList.add("2017-01-31");
        noWorkDateList.add("2017-02-01");
        noWorkDateList.add("2017-04-02");
        noWorkDateList.add("2017-04-03");
        noWorkDateList.add("2017-04-04");
        noWorkDateList.add("2017-05-01");
        noWorkDateList.add("2017-05-28");
        noWorkDateList.add("2017-05-29");
        noWorkDateList.add("2017-05-30");
        noWorkDateList.add("2017-10-01");
        noWorkDateList.add("2017-10-02");
        noWorkDateList.add("2017-10-03");
        noWorkDateList.add("2017-10-04");
        noWorkDateList.add("2017-10-05");
        noWorkDateList.add("2017-10-06");
        noWorkDateList.add("2017-10-07");
        noWorkDateList.add("2017-10-08");
    }

    /**
     * 获取当前时间的 Date。
     * @return 当前时间的 Date。
     */
    public static Date getNow()
    {
        return new Date();
    }
    
    public static String getNowFormate()
    {
    	Date date = getNow();
    	return formatDatetime(date);
    }

    /**
     * 将日期和时间的字符串表示形式转换为它的等效 Date。
     * @param s 包含要转换的日期和时间的字符串。
     * @param format 指定 Date 格式的字符串。
     * @return 日期的字符串表示形式。
     */
    public static Date parse(String s, String format)
    {
        if (StringUtils.isNullOrEmpty(s))
        {
            return null;
        }
        DateFormat df = new SimpleDateFormat(format);
        try
        {
            return df.parse(s);
        }
        catch (ParseException e)
        {
            throw new RuntimeException("不能使用日期格式“" + format + "”解析：" + s);
        }
    }
    
    public static Date autoParse(String s)
    {
        if (StringUtils.isNullOrEmpty(s))
        {
            return null;
        }
        String format = analyseFormat(s);
        DateFormat df = new SimpleDateFormat(format);
        try
        {
            return df.parse(s);
        }
        catch (ParseException e)
        {
            throw new RuntimeException("不能使用日期格式“" + format + "”解析：" + s);
        }
    }

    private static String analyseFormat(String s)
    {
        /**
         *  public static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
            public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
            public static final String FORMAT_YYYYMMDDHHMMSS = "yyyyMMddHHmmss"; //20170105223502
            public static final String FORMAT_YYYYMMDD = "yyyyMMdd"; //20170105
         */
        if (s.indexOf("-") > 0)
        {
            if (s.length() > 11)
            {
                return DateUtil.DEFAULT_DATETIME_FORMAT;
            }
            else
            {
                return DateUtil.DEFAULT_DATE_FORMAT;
            }
        }
        else
        {
            if (s.trim().length() > 8)
            {
                return DateUtil.FORMAT_YYYYMMDDHHMMSS;
            }
            else
            {
                return DateUtil.FORMAT_YYYYMMDD;
            }
        }
    }

    /**
     * 使用指定格式将日期转换为它的字符串表示形式。
     * @param date 日期，非 null。
     * @param format 指定返回格式的字符串。
     * @return 日期的字符串表示形式。
     */
    public static String format(Date date, String format)
    {
        if (date == null)
        {
            return null;
        }
        return new SimpleDateFormat(format).format(date);
    }
    
    
    /**
     * 默认标准时间格式 格式化
     * @param date 
     * @return
     */
    public static String formatDatetime(Date date){
        return format(date, DEFAULT_DATETIME_FORMAT);
    }
    
    /**
     * 默认标准日期格式 格式化
     * @param date 
     * @return
     */
    public static String formatDate(Date date){
        return format(date, DEFAULT_DATE_FORMAT);
    }

    /**
     * 返回指定的年份是否为闰年的指示。
     * @param year 四位数年份。
     * @return 如果 year 为闰年，则为 true；否则为 false。
     */
    public static boolean isLeapYear(int year)
    {
        if ((year < MinYear) || (year > MaxYear))
        {
            throw new RuntimeException();
        }
        if (0 != (year % 4))
        {
            return false;
        }
        if (0 == (year % 100))
        {
            return 0 == (year % 400);
        }
        return true;
    }

    /**
     * 在日期上增加年数。
     * @param date 日期，非 null。
     * @param amount 要增加的数量，可以为负数。
     * @return 增加年数后的新日期。
     */
    public static Date addYears(Date date, int amount)
    {
        return add(date, Calendar.YEAR, amount);
    }

    /**
     * 在日期上增加月数。
     * @param date 日期，非 null。
     * @param amount 要增加的数量，可以为负数。
     * @return 增加月数后的新日期。
     */
    public static Date addMonths(Date date, int amount)
    {
        return add(date, Calendar.MONTH, amount);
    }

    /**
     * 在日期上增加周数。
     * @param date 日期，非 null。
     * @param amount 要增加的数量，可以为负数。
     * @return 增加周数后的新日期。
     */
    public static Date addWeeks(Date date, int amount)
    {
        return add(date, Calendar.WEEK_OF_YEAR, amount);
    }

    /**
     * 在日期上增加日数。
     * @param date 日期，非 null。
     * @param amount 要增加的数量，可以为负数。
     * @return 增加日数后的新日期。
     */
    public static Date addDays(Date date, int amount)
    {
        return add(date, Calendar.DAY_OF_MONTH, amount);
    }

    /**
     * 在日期上增加小时数。
     * @param date 日期，非 null。
     * @param amount 要增加的数量，可以为负数。
     * @return 增加小时数后的新日期。
     */
    public static Date addHours(Date date, int amount)
    {
        return add(date, Calendar.HOUR_OF_DAY, amount);
    }

    /**
     * 在日期上增加分钟数。
     * @param date 日期，非 null。
     * @param amount 要增加的数量，可以为负数。
     * @return 增加分钟数后的新日期。
     */
    public static Date addMinutes(Date date, int amount)
    {
        return add(date, Calendar.MINUTE, amount);
    }

    /**
     * 在日期上增加秒数。
     * @param date 日期，非 null。
     * @param amount 要增加的数量，可以为负数。
     * @return 增加秒数后的新日期。
     */
    public static Date addSeconds(Date date, int amount)
    {
        return add(date, Calendar.SECOND, amount);
    }

    /**
     * 在日期上增加毫秒数。
     * @param date 日期，非 null。
     * @param amount 要增加的数量，可以为负数。
     * @return 增加毫秒数后的新日期。
     */
    public static Date addMilliseconds(Date date, int amount)
    {
        return add(date, Calendar.MILLISECOND, amount);
    }

    /**
     * 根据指定 DatePart 截断日期。 例如，如果你的日期是 28 Mar 2002 13:45:01.231， 如果 datePart 为
     * Hour，它将返回 28 Mar 2002 13:00:00.000； 如果 datePart 为 Month，它将返回 进程与线程.txt Mar 2002
     * 0:00:00.000。
     * @param date 日期，非 null。
     * @param datePart 保留的部分。
     * @return 截断后的新日期。
     */

    public static Date truncate(Date date, DatePart datePart)
    {
        long data = date.getTime();
        switch (datePart)
        {
            case year:
                return new Date(data - (data + LangTicksDifference) % TicksPerDay - (get(date, Calendar.DAY_OF_YEAR) - 1) * TicksPerDay);
            case month:
                return new Date(data - (data + LangTicksDifference) % TicksPerDay - (get(date, Calendar.DAY_OF_MONTH) - 1) * TicksPerDay);
            case day:
                return new Date(data - (data + LangTicksDifference) % TicksPerDay);
            case hour:
                return new Date(data - data % TicksPerHour);
            case minute:
                return new Date(data - data % TicksPerMinute);
            case second:
                return new Date(data - data % TicksPerSecond);
            case millisecond:
                return new Date(data);
            default:
                return new Date(data - data % TicksPerDay);
        }
    }

    /**
     * 获取日期的年份。
     * @param date 日期，非 null。
     * @return 日期的年份。
     */
    public static int getYear(Date date)
    {
        return get(date, Calendar.YEAR);
    }

    /**
     * 给日期设置一个新的年份。
     * @param date 日期，非 null。
     * @param amount 要设置的年份。
     * @return 设置年份后的新日期。
     */
    public static Date setYear(Date date, int amount)
    {
        return set(date, Calendar.YEAR, amount);
    }

    /**
     * 获取日期的月份。
     * @param date 日期，非 null。
     * @return 日期的月份。
     */
    public static int getMonth(Date date)
    {
        return get(date, Calendar.MONTH);
    }

    /**
     * 给日期设置一个新的月份。
     * @param date 日期，非 null。
     * @param amount 要设置的月份。
     * @return 设置月份后的新日期。
     */
    public static Date setMonth(Date date, int amount)
    {
        return set(date, Calendar.MONTH, amount);
    }

    /**
     * 获取日期的月中的第几天。
     * @param date 日期，非 null。
     * @return 日期的月中的第几天。
     */
    public static int getDay(Date date)
    {
        return get(date, Calendar.DAY_OF_MONTH);
    }

    /**
     * 给日期设置一个新的月中的第几天。
     * @param date 日期，非 null。
     * @param amount 要设置的月中的第几天。
     * @return 设置月中的第几天后的新日期。
     */
    public static Date setDay(Date date, int amount)
    {
        return set(date, Calendar.DAY_OF_MONTH, amount);
    }

    /**
     * 获取日期的小时部份。
     * @param date 日期，非 null。
     * @return 日期的小时部份。
     */
    public static int getHour(Date date)
    {
        return get(date, Calendar.HOUR_OF_DAY);
    }

    /**
     * 给日期设置一个新的小时部份。
     * @param date 日期，非 null。
     * @param amount 要设置的小时部份。
     * @return 设置小时部份后的新日期。
     */
    public static Date setHour(final Date date, int amount)
    {
        return set(date, Calendar.HOUR_OF_DAY, amount);
    }

    /**
     * 获取日期的分钟部份。
     * @param date 日期，非 null。
     * @return 日期的分钟部份。
     */
    public static int getMinute(Date date)
    {
        return get(date, Calendar.MINUTE);
    }

    /**
     * 给日期设置一个新的分钟部份。
     * @param date 日期，非 null。
     * @param amount 要设置的分钟部份。
     * @return 设置分钟部份后的新日期。
     */
    public static Date setMinute(Date date, int amount)
    {
        return set(date, Calendar.MINUTE, amount);
    }

    /**
     * 获取日期的秒部份。
     * @param date 日期，非 null。
     * @return 日期的秒部份。
     */
    public static int getSecond(Date date)
    {
        return get(date, Calendar.SECOND);
    }

    /**
     * 给日期设置一个新的秒部份。
     * @param date 日期，非 null。
     * @param amount 要设置的秒部份。
     * @return 设置秒部份后的新日期。
     */
    public static Date setSecond(Date date, int amount)
    {
        return set(date, Calendar.SECOND, amount);
    }

    /**
     * 获取日期的毫秒部份。
     * @param date 日期，非 null。
     * @return 日期的毫秒部份。
     */
    public static int getMillisecond(Date date)
    {
        return get(date, Calendar.MILLISECOND);
    }

    /**
     * 获取二个日期的相差天数
     * @param startDate
     * @param endDate
     * @return
     */
    public static long getDifferenceDay(Date startDate, Date endDate)
    {
        long DAY = 24L * 60L * 60L * 1000L;
        return (endDate.getTime() - startDate.getTime()) / DAY;
    }

    /**
     * 给日期设置一个新的毫秒部份。
     * @param date 日期，非 null。
     * @param amount 要设置的毫秒部份。
     * @return 设置毫秒部份后的新日期。
     */
    public static Date setMillisecond(Date date, int amount)
    {
        return set(date, Calendar.MILLISECOND, amount);
    }

    private static Date add(Date date, int calendarField, int amount)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(calendarField, amount);
        return c.getTime();
    }

    private static int get(Date date, int calendarField)
    {
        Calendar c = Calendar.getInstance();
        c.setLenient(false);
        c.setTime(date);
        return c.get(calendarField);
    }

    private static Date set(Date date, int calendarField, int amount)
    {
        Calendar c = Calendar.getInstance();
        c.setLenient(false);
        c.setTime(date);
        c.set(calendarField, amount);
        return c.getTime();
    }

    public static String getDatePath()
    {
        return format(getNow(), "yyyyMMdd");
    }

    public static boolean isWorkTime(Date date)
    {
        String dateStr = format(date, DEFAULT_DATE_FORMAT);
        //如果是法定假期
        if (noWorkDateList.contains(dateStr))
        {
            return false;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        //如果是周末
        if(cal.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY||cal.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY)
        {
            //是周末而且不是工作日
            if (!workDateList.contains(dateStr))
            {
                return false;
            }
        }
        int houre = cal.get(Calendar.HOUR_OF_DAY);
        //上班时间9点-18点
        if (houre>18 || houre < 9)
        {
            return false;
        }
        //默认上班
        return true;
    }
    
    public static void main(String[] args)
    {
//        Date currentDate = new Date();
//        boolean isWorkTime = DateUtil.isWorkTime(currentDate);
        long date = System.currentTimeMillis();
        date = date + DateUtil.TicksPerDay*8 ;
        Calendar calendar = Calendar.getInstance(); //.setTimeInMillis(date);
        calendar.setTimeInMillis(date);
        Date dateTime = calendar.getTime();
        System.out.println(DateUtil.format(dateTime, DEFAULT_DATETIME_FORMAT));
        System.out.println(inSpringFestival());
    }

    public static boolean inSpringFestival()
    {
        long time = System.currentTimeMillis();
        return inSpringFestival(time);
    }
    
    /**
     * 春节
     * @return
     */
    public static boolean inSpringFestival(long time)
    {
        //2017-02-02 23:59前为春节
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2017);
        calendar.set(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 2);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        long lastTime = calendar.getTimeInMillis();
        if (time < lastTime)
        {
            return true;
        }
        return false;
    }
}
