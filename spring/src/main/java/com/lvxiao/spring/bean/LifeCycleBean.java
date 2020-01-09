package com.lvxiao.spring.bean;

import lombok.ToString;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019-08-19 23:48
 */
@ToString
public class LifeCycleBean implements BeanFactoryAware, BeanNameAware,
        InitializingBean, DisposableBean, ApplicationContextAware {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LifeCycleBean() {
        System.out.println("3.执行实例化方法");
    }

    public void init() {
        System.out.println("12.执行init");
    }
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("8.调用setBeanFactory()");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("7.调用setBeanName()");

    }
    public void myDestroy() {
        System.out.println("15.myDestroy()");
    }
    @Override
    public void destroy() throws Exception {
        System.out.println("14.调用destroy()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("11.执行afterPropertiesSet()");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("9.调用setApplicationContext()");
    }
}
