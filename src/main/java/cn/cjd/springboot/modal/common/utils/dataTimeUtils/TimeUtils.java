package cn.cjd.springboot.modal.common.utils.dataTimeUtils;

import java.util.Calendar;
import java.util.Date;

@SuppressWarnings("unused")
public class TimeUtils {

    /**
     * 获取前一天的最小时间 0时0分0秒
     */
    public static Date getBeforeDayMinTime(Date date) {

        Calendar calendar = Calendar.getInstance();

        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.add(calendar.DATE, -1);

        return calendar.getTime();

    }

    /**
     * 获取前一天的最大时间 23时59分59秒
     */
    public static Date getBeforeDayMaxTime(Date date) {

        Calendar calendar = Calendar.getInstance();

        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MINUTE, 59);
        calendar.add(calendar.DATE, -1);

        return calendar.getTime();
    }

    /**
     * 年月日时分秒
     */
    public static String yyyyMMdd_HHmmSS() {

        Calendar calendar = Calendar.getInstance();

        int year = calendar.get(Calendar.YEAR);
        int mouth = calendar.get(Calendar.MONTH) + 1;
        int date = calendar.get(Calendar.DATE);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        String mouths = String.valueOf(mouth);
        if (mouth <10) {
            mouths = "0"+mouth;
        }
        String dates = String.valueOf(date);
        if (date <10) {
            dates = "0"+date;
        }
        String hours = String.valueOf(hour);
        if (hour <10) {
            hours = "0"+hour;
        }
        String minutes = String.valueOf(minute);
        if (minute <10) {
            minutes = "0"+minute;
        }
        String seconds = String.valueOf(second);
        if (second <10) {
            seconds = "0"+second;
        }

        return year + mouths + dates + "_" + hours + minutes + seconds;
    }

}
