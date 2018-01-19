package com.rui.web.controller.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : zhuxueke
 * @since : 2017-12-13 14:29
 **/
public class AdminBaseController {

    private static Logger logger = LoggerFactory.getLogger(AdminBaseController.class);

    /**
     * 获取当前登录用户信息
     * @author : zhuxueke
     * @since : 2017/12/13 14:39
     */
//    protected AdminModel<UserDomain> getAdmin(){
//        AdminModel<UserDomain> adminModel = null;
//        try{
//            // ...
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return adminModel;
//    }

    /**
     * success
     * @author : zhuxueke
     * @since : 2018/1/12 11:21
     */
    protected String successObjectStr(String message) {
//        if (object == null) {
//            ExceptionUtils.throwBaseException("参数异常");
//        }
//        Map<String, Object> map = new HashMap<>();
//        map.put("ok", 200);
//        map.put("message", message);
        JSONObject json = new JSONObject();
        json.put("ok",200);
        json.put("message",message);
        return json.toJSONString();
    }

    /**
     * error
     * @author : zhuxueke
     * @since : 2018/1/12 11:21
     */
    protected String errorObjectStr(String message) {
//        if (object == null) {
//            ExceptionUtils.throwBaseException("参数异常");
//        }
        Map<String, Object> map = new HashMap<>();
        map.put("error", 300);
        map.put("message", message);
        return toJSONFormatString(map);
    }

    protected String toJSONFormatString(Object object) {
        return JSON.toJSONString(object, SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
    }
}
