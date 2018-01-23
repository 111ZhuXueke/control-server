package com.rui.web.common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author : zhuxueke
 * @since : 2018-01-23 15:48
 **/
public class DateUtils {
    /**
     * 获取未来时间
     * @author : zhuxueke
     * @since : 2018/1/23 15:49
     */
    public static long getFutureDate(int minuate){
        Calendar now=Calendar.getInstance();
        now.add(Calendar.MINUTE,minuate);
        return now.getTimeInMillis();
    }

    public static void main(String[] args){
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(getFutureDate(30))));
    }
}
