package com.lvxiao.algorithm.caffeine;

import java.util.concurrent.TimeUnit;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;

/**
 * @author lvxiao <lvxiao@kuaishou.com>
 * Created on 2021-02-07
 */
public class CacheTest {

    private static final LoadingCache<Integer, Integer> LOADING_CACHE = Caffeine.newBuilder()
            .maximumSize(10)
            .expireAfterAccess(1, TimeUnit.SECONDS)
            .build(k -> {
                Thread.sleep(5000);
                return k + 100;
            });

    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        System.out.println(LOADING_CACHE.get(10));
        System.out.println("耗时:" + (System.currentTimeMillis() - l));
        System.out.println(LOADING_CACHE.get(10));
        System.out.println("耗时:" + (System.currentTimeMillis() - l));
    }
}
