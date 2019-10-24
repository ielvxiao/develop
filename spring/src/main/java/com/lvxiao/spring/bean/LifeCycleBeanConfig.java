package com.lvxiao.spring.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019-08-20 00:29
 */
@ComponentScan(basePackages = "com.lvxiao.spring.bean")
@Configuration
@EnableAspectJAutoProxy
public class LifeCycleBeanConfig {
    @Bean(initMethod = "init", destroyMethod = "myDestroy")
    public LifeCycleBean lifeCycleBean() {
        LifeCycleBean lifeCycleBean = new LifeCycleBean();
        lifeCycleBean.setName("set方法设置了一个名字");
        return lifeCycleBean;
    }
}
