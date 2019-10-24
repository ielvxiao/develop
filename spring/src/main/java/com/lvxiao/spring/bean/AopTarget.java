package com.lvxiao.spring.bean;

import org.springframework.stereotype.Component;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/10/23 1:48 下午
 */
@Component
public class AopTarget {
    public void testAop(String name) {
        System.out.println("======AOP:" + name);
    }
}
