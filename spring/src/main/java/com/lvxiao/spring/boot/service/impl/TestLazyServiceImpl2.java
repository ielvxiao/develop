package com.lvxiao.spring.boot.service.impl;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * @author lvxiao <lvxiao@kuaishou.com>
 * Created on 2021-02-25
 */
@Lazy
@Service
public class TestLazyServiceImpl2 {

    @PostConstruct
    public void init() {
        //如果service被controller引用，则lazy无用，因为controller加载的时候就会加载所有的依赖
        System.out.println("TestLazyServiceImpl2被加载了");
    }
    public String test() {
        return "hello";
    }
}
