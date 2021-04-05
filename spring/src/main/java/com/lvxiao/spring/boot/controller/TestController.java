package com.lvxiao.spring.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lvxiao.Starter;
import com.lvxiao.spring.boot.service.CacheService;
import com.lvxiao.spring.boot.service.impl.TestLazyServiceImpl;

/**
 * @author lvxiao
 * @date 2020/7/31
 */
@RestController
public class TestController {
    @Autowired
    private Starter starter;
    @Autowired
    private CacheService cacheService;
    @Autowired
    private TestLazyServiceImpl testLazyService;

    @GetMapping({"/", "/index"})
    @ResponseBody
    public String index() {
        return starter.toString();
    }

    @GetMapping("/caffeine")
    @ResponseBody
    public String caffeine(int length) {
        long begin = System.currentTimeMillis();
        String str = cacheService.caffeineCache(length);
        System.out.println("caffeine生成随机字符串用时："+(System.currentTimeMillis()-begin));
        return str;
    }

    @GetMapping("/redis")
    @ResponseBody
    public String redis(int length) {
        long begin = System.currentTimeMillis();
        String str = cacheService.redisCache(length);
        System.out.println("redis生成随机字符串用时："+(System.currentTimeMillis()-begin));
        return str;
    }

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return testLazyService.test();
    }

    @GetMapping("/testRe")
    public String a1(@RequestParam(value = "h_h") String hh) {
        return hh;
    }
}
