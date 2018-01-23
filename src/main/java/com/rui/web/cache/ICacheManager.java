package com.rui.web.cache;

import java.util.Map;
import java.util.Set;

/**
 * 缓存接口 / java 老套路
 * @author : zhuxueke
 * @since : 2018-01-23 10:24
 **/
public interface ICacheManager {

    /**
     * 存入缓存
     * @author : zhuxueke
     * @since : 2018/1/23 10:31
     */
    void putCache(String key, EntityCache value);

    /**
     * 存入缓存
     * @author : zhuxueke
     * @since : 2018/1/23 10:31
     */
    void putCache(String key, Object dates, Long timeOut);

    /**
     * 获取缓存数据
     * @author : zhuxueke
     * @since : 2018/1/23 10:33
     */
    EntityCache getCacheByKey(String key);

    /**
     * 获取缓存数据
     * @author : zhuxueke
     * @since : 2018/1/23 10:34
     */
    Object getCacheDataByKey(String key);

    /**
     * 获取所有缓存数据
     * @author : zhuxueke
     * @since : 2018/1/23 10:35
     */
    Map<String, EntityCache> getCacheAll();

    /**
     * 判断是否在缓存中
     * @author : zhuxueke
     * @since : 2018/1/23 10:35
     */
    boolean isContain(String key);

    /**
     * 清空缓存
     * @author : zhuxueke
     * @since : 2018/1/23 10:45
     */
    void clearAll();

    /**
     * 清楚对应数据
     * @author : zhuxueke
     * @since : 2018/1/23 10:36
     */
    void clearByKey(String key);

    /**
     * 缓存是否超时失效
     * @author : zhuxueke
     * @since : 2018/1/23 10:37
     */
    boolean isTimeOut(String key);

    /**
     * 获取所有键
     * @author : zhuxueke
     * @since : 2018/1/23 10:37
     */
    Set<String> getAllKey();
}
