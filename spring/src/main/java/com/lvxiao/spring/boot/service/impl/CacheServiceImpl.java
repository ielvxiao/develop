package com.lvxiao.spring.boot.service.impl;

import com.lvxiao.spring.boot.config.CacheManagerConfiguration;
import com.lvxiao.spring.boot.service.CacheService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author lvxiao
 * @date 2020/7/31
 */
@Service
public class CacheServiceImpl implements CacheService {

    @Override
    @Cacheable(key = "#length",cacheNames = "string",cacheManager = CacheManagerConfiguration.CacheName.CAFFEINE_CACHE_MANAGER)
    public String caffeineCache(int length) {
        return randomString(length);
    }

    @Cacheable(key = "#length",cacheNames = "string",cacheManager = CacheManagerConfiguration.CacheName.REDIS_CACHE_MANAGER)
    @Override
    public String redisCache(int length) {
        return randomString(length);
    }

    public String randomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
