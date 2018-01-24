package com.rui.web.controller.robot.util;

import java.util.Date;

/**
 * base64
 * @author : zhuxueke
 * @since : 2018-01-24 9:55
 **/
public class Base64Utils {
    /**
     * 要加密的字符串
     * @author : zhuxueke
     * @since : 2018/1/24 9:27
     */
    public static String getStr(long time){
        return System.getenv("USERNAME") + time;
    }
}
