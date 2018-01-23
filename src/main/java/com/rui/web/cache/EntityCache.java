package com.rui.web.cache;

/**
 * 缓存
 * @author : zhuxueke
 * @since : 2018-01-23 10:21
 **/
public class EntityCache {
    /**
     * 要保存的数据
     * @author : zhuxueke
     * @since : 2018/1/23 10:21
     */
    private Object datas;
    /**
     * 超时时间
     * @author : zhuxueke
     * @since : 2018/1/23 10:22
     */
    private Long timeOut;

    /**
     * 刷新时间
     * @author : zhuxueke
     * @since : 2018/1/23 10:22
     */
    private Long lastRefeshTime;

    public EntityCache(Object datas, Long timeOut, Long lastRefeshTime) {
        this.datas = datas;
        this.timeOut = timeOut;
        this.lastRefeshTime = lastRefeshTime;
    }

    public Object getDatas() {
        return datas;
    }

    public void setDatas(Object datas) {
        this.datas = datas;
    }

    public Long getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Long timeOut) {
        this.timeOut = timeOut;
    }

    public Long getLastRefeshTime() {
        return lastRefeshTime;
    }

    public void setLastRefeshTime(Long lastRefeshTime) {
        this.lastRefeshTime = lastRefeshTime;
    }
}
