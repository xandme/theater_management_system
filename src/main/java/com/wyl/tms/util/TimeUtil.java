package com.wyl.tms.util;

import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * 时间转换公共方法
 */
public class TimeUtil {

    private static ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    /*
     * 字符串转date
     */
    public static Date dateFormat(String time) {
        if (!StringUtils.hasText(time)) {
            return new Date();
        }
        try {
            return threadLocal.get().parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();
    }

    /*
     * 时间戳转date
     */
    public static Date unixTime2Date(long timeStamp) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return format.parse(format.format(timeStamp * 1000));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
     * date转时间戳 单位 秒
     */
    public static long dateString2UnixTimeInSeconds(String time) {
        try {
            Date parse = threadLocal.get().parse(time);
            return parse.getTime() / 1000;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static String date2String(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    public static String data2StringNoDay(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        return sdf.format(date);
    }

    public static String date2StringNoYear(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
        return sdf.format(date);
    }

    public static String date2StringOnlyYear(Date date){
        return new SimpleDateFormat("yyyy").format(date);
    }

    public static String date2StringYearMonth(Date date){
        return new SimpleDateFormat("yyyy-MM").format(date);
    }

    public static String dateTime2String(Date date) {
        SimpleDateFormat sdf = null;
        try {
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date string2DateTime(String dateStr) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            date = sf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date stringFull2DateTime(String dateStr) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        try {
            date = sf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    //获取当前日期前{beforDate}天
    public static String getDataStrBeforeN(int beforDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(getDataBeforeN(beforDate));
    }

    //获取当前日期前{beforDate}天
    public static Date getDataBeforeN(int beforDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, beforDate * -1);
        date = calendar.getTime();
        return date;
    }

    //获取指定日期前{beforDate}天
    public static Date getDateBeforeN(Date date, int beforDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, beforDate * -1);
        date = calendar.getTime();
        return date;
    }

    //获取前月的第一天
    public static String getFirstDayOfMonth() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal_1 = Calendar.getInstance();//获取当前日期
        cal_1.add(Calendar.MONTH, 0);
        cal_1.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        return format.format(cal_1.getTime());
    }


    /**
     * 获取当前时间
     */
    public static String getNowTime() {
        Calendar calendar = Calendar.getInstance();
        return threadLocal.get().format(calendar.getTime());
    }

    /**
     * 获取本月初时间
     */
    public static String getBeginThisMonth() {
        return getBeginOffsetMonthStr(0);
    }

    /**
     * 获取本月末时间
     */
    public static String getEndThisMonth() {
        return getEndOffsetMonthStr(0);
    }

    /**
     * 获取当前偏移n个月的初时间（字符串）
     */
    public static String getBeginOffsetMonthStr(int monthOffset) {
        return threadLocal.get().format(getBeginOffsetMonth(monthOffset));
    }

    /**
     * 获取当前偏移n个月的月末时间（字符串）
     */
    public static String getEndOffsetMonthStr(int monthOffset) {
        return threadLocal.get().format(getEndOffsetMonth(monthOffset));
    }
    /**
     * 获取当前偏移n个月的初时间
     */
    public static Date getBeginOffsetMonth(int monthOffset) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.add(Calendar.MONTH,monthOffset);
        return calendar.getTime();
    }

    /**
     * 获取当前偏移n个月的月末时间
     */
    public static Date getEndOffsetMonth(int monthOffset) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MONTH, 1+monthOffset);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    public static Date getOffsetDateByYear(Date originalTime,int yearOffset){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(originalTime);
        calendar.add(Calendar.YEAR, yearOffset);
        return calendar.getTime();
    }

    public static Date getOffsetDateByMonth(Date originalTime,int monthOffset){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(originalTime);
        calendar.add(Calendar.MONTH, monthOffset);
        return calendar.getTime();
    }

    public static Date getOffsetDateByDay(Date originalTime,int dayOffset){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(originalTime);
        calendar.add(Calendar.DAY_OF_YEAR, dayOffset);
        return calendar.getTime();
    }

    public static String getOffsetDateByYearStr(Date originalTime,int yearOffset){
        return threadLocal.get().format(getOffsetDateByYear(originalTime,yearOffset));
    }

    public static String getOffsetDateByMonthStr(Date originalTime,int monthOffset){
        return threadLocal.get().format(getOffsetDateByMonth(originalTime,monthOffset));
    }

    public static String getOffsetDateByDayStr(Date originalTime,int dayOffset){
        return threadLocal.get().format(getOffsetDateByDay(originalTime,dayOffset));
    }

    /**
     * 获取指定月份倒数{reciprocalDay}的时间
     *
     * @param month         月份
     * @param reciprocalDay 倒数天数
     * @param isZero        true:00:00:00 false:23:59:59
     * @return String
     */
    public static String getDateReciprocal(int month, int reciprocalDay, boolean isZero) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        calendar.add(Calendar.DAY_OF_MONTH, 1 - reciprocalDay);
        if (isZero) {
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
        } else {
            calendar.set(Calendar.HOUR_OF_DAY, 23);
            calendar.set(Calendar.MINUTE, 59);
            calendar.set(Calendar.SECOND, 59);
        }
        return threadLocal.get().format(calendar.getTime());
    }


    private static void handleHMS(Calendar calendar,boolean isZero){
        if (isZero) {
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
        } else {
            calendar.add(Calendar.MONTH, 1);
            calendar.add(Calendar.DAY_OF_MONTH, -1);
            calendar.set(Calendar.HOUR_OF_DAY, 23);
            calendar.set(Calendar.MINUTE, 59);
            calendar.set(Calendar.SECOND, 59);
        }
    }
    /**
     * 获取指定年份月份月初或月末的时间
     *
     * @param year   年份
     * @param month  月份
     * @param isZero true:月初00:00:00 false:月末 23:59:59
     * @return String
     */
    public static String getDateFromYearAndMonth(int year, int month, boolean isZero) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        handleHMS(calendar,isZero);
        return threadLocal.get().format(calendar.getTime());
    }

    public static String getDateFromYearMonthAndDay(int year, int month, int day, boolean isZero) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        handleHMS(calendar,isZero);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        return threadLocal.get().format(calendar.getTime());
    }

    /**
     * 获取当前，财年初时间(4.1)
     */
    public static String getBeginFiscalYear() {
        return getBeginFiscalYearStr(new Date());
    }

    /**
     * 获取当前，财年末时间(4.1)
     */
    public static String getEndFiscalYearStr() {
        return getEndFiscalYearStr(new Date());
    }

    /**
     * 获取指定时间，财年初时间(4.1)
     */
    public static String getBeginFiscalYearStr(Date date) {

        return threadLocal.get().format(getBeginFiscalYear(date));
    }

    public static Date getBeginFiscalYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if (calendar.get(Calendar.MONTH) + 1 < 4) {
            calendar.add(Calendar.YEAR, -1);
        }
        calendar.set(Calendar.MONTH, 4 - 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取指定时间，财年末时间(4.1)
     */
    public static String getEndFiscalYearStr(Date date) {
        return threadLocal.get().format(getEndFiscalYear(date));
    }

    public static Date getEndFiscalYear(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if (calendar.get(Calendar.MONTH) + 1 >= 4) {
            calendar.add(Calendar.YEAR, 1);
        }
        calendar.set(Calendar.MONTH, 4 - 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.add(Calendar.SECOND, -1);
        return calendar.getTime();
    }

    /**
     * 判断字符串的时间类型（-1 时间戳,1 时间字符串,0 非时间字符串)
     */
    public static int getDateStringType(String dateStr) {

        String isDateTimeStr = "^\\d+$";
        String isTimeStampStr = "(^\\d{4}-[01][0-9]$)|(^\\d{4}-[01][0-9]-[0-3][0-9]$)|(^\\d{4}-[01][0-9]-[0-3][0-9]\\s+[0-2][0-9](:[0-6][0-9]){2}$)";

        if (Pattern.matches(isDateTimeStr, dateStr)) {
            return -1;
        } else if (Pattern.matches(isTimeStampStr, dateStr)) {
            return 1;
        } else {
            return 0;
        }
    }

    public static Date getEndOfMonthBy(Date currentDate){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    public static Date getBeginOfMonthBy(Date currentDate){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取时间差字符串（格式 n天n时n分n秒）
     * @param startTime
     * @param endTime
     * @return
     */
    public static String getTimeDifStr(Date startTime,Date endTime){
        long difMs=endTime.getTime() - startTime.getTime();
        /*
         * 毫秒转化时分秒毫秒
         */
        Integer ss = 1000;
        Integer mi = ss * 60;
        Integer hh = mi * 60;
        Integer dd = hh * 24;

        Long day = difMs / dd;
        Long hour = (difMs - day * dd) / hh;
        Long minute = (difMs - day * dd - hour * hh) / mi;
        Long second = (difMs - day * dd - hour * hh - minute * mi) / ss;

        return day+"天" + hour +"时" + minute+ "分" + second + "秒";
    }

    public static void main(String[] args) {
        Date d = getBeginOffsetMonth(0);
        System.out.println(TimeUtil.dateTime2String(d));
        System.out.println(getOffsetDateByYearStr(d,-2));
        System.out.println(getOffsetDateByMonthStr(d,-2*12));
        System.out.println(getOffsetDateByDayStr(d,-2*365));

    }
}
