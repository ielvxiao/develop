package com.lvxiao.spring.boot.service;

/**
 * @author lvxiao
 * @date 2020/7/31
 */

public interface CacheService {
    String caffeineCache(int length);
    String redisCache(int length);
}
