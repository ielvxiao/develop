package com.lvxiao.spring.boot.service.impl;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * @author lvxiao <lvxiao@kuaishou.com>
 * Created on 2021-02-26
 */
@Lazy
@Service
public class TestPostConstract1Impl {

    @PostConstruct
    public void init() {
        System.out.println("TestPostConstract1Impl加载了一下");
    }
    public void test() {
        System.out.println("TestPostConstract1Impl 哈哈哈");
    }
}
