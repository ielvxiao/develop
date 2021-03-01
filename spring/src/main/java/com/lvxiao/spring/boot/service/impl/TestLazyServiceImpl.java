package com.lvxiao.spring.boot.service.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * @author lvxiao <lvxiao@kuaishou.com>
 * Created on 2021-02-25
 */
@Lazy
@Service
public class TestLazyServiceImpl {

    @PostConstruct
    public void init() {
        System.out.println("TestLazyServiceImpl被加载了");
        testPostConstract1.test();
    }

    @Autowired
    private TestLazyServiceImpl2 testLazyServiceImpl2;
    @Autowired
    private TestPostConstract1Impl testPostConstract1;

    public String test() {
        return testLazyServiceImpl2.test();
    }
}
