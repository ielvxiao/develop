package com.lvxiao.spring.context;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * @author lvxiao
 * @date 2019/8/13
 */
public class Compare {
    public static void main(String[] args) {
        BeanFactory factory = new XmlWebApplicationContext();
        ApplicationContext context = new XmlWebApplicationContext();
    }
}
