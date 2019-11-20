package com.hwy.cache.common;

/**
 * @author hwy
 * @program cache
 * @date 2019/7/12 16:59
 */
public enum Cache {
    /**
     * 用户cache
     */
    USERCACHE("userCache");

    private Cache(String cacheName) {
        this.cacheName = cacheName;
    }
    private String cacheName;

    public String getCacheName() {
        return cacheName;
    }

    public void setCacheName(String cacheName) {
        this.cacheName = cacheName;
    }
}
