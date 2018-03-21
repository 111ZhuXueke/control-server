package com.rui.web.cache;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * CacheManager 的实现类
 * @author : zhuxueke
 * @since : 2018-01-23 10:39
 **/
public class CacheManagerImpl implements ICacheManager {
    private static Map<String,EntityCache> cacheMap = new ConcurrentHashMap<String, EntityCache>();
    @Override
    public void putCache(String key, EntityCache value) {
        cacheMap.put(key,value);
    }

    @Override
    public void putCache(String key, Object dates, Long timeOut) {
        timeOut = timeOut > 0 ? timeOut : 0L;
        putCache(key, new EntityCache(dates,timeOut,System.currentTimeMillis()));
    }

    @Override
    public EntityCache getCacheByKey(String key) {
        if(this.isContain(key)){
            return cacheMap.get(key);
        }
        return null;
    }

    @Override
    public Object getCacheDataByKey(String key) {
        if(this.isContain(key)){
            return cacheMap.get(key).getDatas();
        }
        return null;
    }

    public static Map<String, EntityCache> getCacheMap() {
        return cacheMap;
    }

    public static void setCacheMap(Map<String, EntityCache> cacheMap) {
        CacheManagerImpl.cacheMap = cacheMap;
    }

    @Override
    public Map<String, EntityCache> getCacheAll() {

        return cacheMap;
    }

    @Override
    public boolean isContain(String key) {
        if(isTimeOut(key)){
            cacheMap.clear();
            return false;
        }
        return cacheMap.containsKey(key);
    }

    @Override
    public void clearAll() {
        cacheMap.clear();
    }

    @Override
    public void clearByKey(String key) {
        cacheMap.remove(key);
    }

    @Override
    public boolean isTimeOut(String key) {
        if (!cacheMap.containsKey(key)){
            return true;
        }
        EntityCache cache = cacheMap.get(key);
        long timeOut = cache.getTimeOut();
        long lastRefeshTime = cache.getLastRefeshTime();
        if(timeOut == 0 || System.currentTimeMillis() - lastRefeshTime >= timeOut){
            return true;
        }
        return false;
    }

    @Override
    public Set<String> getAllKey() {
        return cacheMap.keySet();
    }
}
