package com.lvxiao.spring.bean;

import com.lvxiao.spring.bean.LifeCycleBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019-08-20 00:29
 */
@ComponentScan(basePackages = "com.lvxiao.spring.bean")
@Configuration
public class LifeCycleBeanConfig {
    @Bean(initMethod = "init", destroyMethod = "myDestroy")
    public LifeCycleBean lifeCycleBean() {
        return new LifeCycleBean();
    }
}
