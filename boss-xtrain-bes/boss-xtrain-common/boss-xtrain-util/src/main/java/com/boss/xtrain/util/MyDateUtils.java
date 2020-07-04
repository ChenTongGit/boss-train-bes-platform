package com.boss.xtrain.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class MyDateUtils extends DateUtils {
    /**
     * 仅显示年月日，例如 2015-08-11.
     */
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    /**
     * 显示年月日时分秒，例如 2015-08-11 09:51:53.
     */
    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 仅显示时分秒，例如 09:51:53.
     */
    public static final String TIME_FORMAT = "HH:mm:ss";

    /**
     * 字符串转换成年月日时分秒
     * @param str
     * @return data
     */
    public static Date parseDateTime(String str) {
        Date date = new Date();
        try{
            date = DateUtils.parseDate(str,DATETIME_FORMAT);
        }catch (ParseException e){
            log.error(e.getMessage());
        }
        return date;
    }

    /**字符串转换成年月日
     * @param str
     * @return
     */
    public static Date parseDate(String str){
        Date date = new Date();
        try{
            date = DateUtils.parseDate(str,DATE_FORMAT);
        }catch (ParseException e){
            log.error(e.getMessage());
        }
        return date;
    }

    /**字符串转换成时分秒
     * @param str
     * @return
     */
    public static Date parseTime(String str){
        Date date = new Date();
        try{
            date = DateUtils.parseDate(str,TIME_FORMAT);
        }catch (ParseException e){
            log.error(e.getMessage());
        }
        return date;
    }

    /**返回当前系统年月日时分秒
     * @return
     */
    public static String getCurrentDateTime(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATETIME_FORMAT);
        return simpleDateFormat.format(new Date());
    }

    /**返回年月日的字符串
     * @return
     */
    public static String getCurrentDate(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
        return simpleDateFormat.format(new Date());
    }

    /**返回时分秒
     * @return
     */
    public static String getCurrentTime(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TIME_FORMAT);
        return simpleDateFormat.format(new Date());
    }

    /**判断是否为空
     * @param date
     * @return
     */
    public static boolean isEmpty(Date date){
        return  date==null;
    }

    /**判断两个日期是否为同一天
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameDate(Date date1, Date date2){
        return DateUtils.isSameDay(date1,date2);
    }

    /**判断两个日期以及时分秒是否相同
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameDateTime(Date date1, Date date2){
        return DateUtils.isSameInstant(date1,date2);
    }

    /**增加天
     * @param date
     * @param amount
     * @return
     */
    public static Date addDays(Date date,int amount){
        DateUtils.addDays(date,amount);
        return date;
    }
    public static Date addMouths(Date date, int amount){
        DateUtils.addMonths(date,amount);
        return date;
    }
    public static Date addYears(Date date,int amount){
        DateUtils.addYears(date,amount);
        return date;
    }
    public static Date addSeconds(Date date,int amount){
        DateUtils.addSeconds(date,amount);
        return date;
    }
    public static Date addMinutes(Date date, int amount){
        DateUtils.addMinutes(date,amount);
        return date;
    }
    public static Date addHours(Date date,int amount){
        DateUtils.addHours(date,amount);
        return date;
    }
}
