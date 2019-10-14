package com.wanandroid.app.chwanandroid.base.basehttp;

/**
 * create time on  2019/7/16
 * function:
 */
public abstract class BaseApi {

    //是否需要缓存
    private boolean cache = false;

    //方法-如果需要缓存必须设置这个参数；不需要不用設置
    private String method = "";

    //基础url
    private String baseUrl = "";

    //retry次数
    private int retryCount = 1;

    //retry延迟
    private long retryDelay = 100;

    //retry叠加延迟
    private long retryIncreaseDelay = 100;

    //缓存url-可手动设置
    private String cacheUrl;

    //有网情况下的本地缓存时间默认60秒
    private static final int cookieNetWorkTime = 60;

    //无网络的情况下本地缓存时间默认30天
    private static final int cookieNoNetWorkTime = 24 * 60 * 60 * 30;

    public static int getCookieNetWorkTime() {
        return cookieNetWorkTime;
    }

    public static int getCookieNoNetWorkTime() {
        return cookieNoNetWorkTime;
    }

    public boolean isCache() {
        return cache;
    }

    public void setCache(boolean cache) {
        this.cache = cache;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String url) {
        this.baseUrl = url;
    }


    public int getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }

    public long getRetryDelay() {
        return retryDelay;
    }

    public void setRetryDelay(long retryDelay) {
        this.retryDelay = retryDelay;
    }

    public long getRetryIncreaseDelay() {
        return retryIncreaseDelay;
    }

    public void setRetryIncreaseDelay(long retryIncreaseDelay) {
        this.retryIncreaseDelay = retryIncreaseDelay;
    }

    public String getCacheUrl() {
        return cacheUrl;
    }

    public void setCacheUrl(String cacheUrl) {
        this.cacheUrl = cacheUrl;
    }
}
