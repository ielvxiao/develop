package com.lvxiao.spring.filterbase.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * @author lvxiao <lvxiao@kuaishou.com>
 * Created on 2021-01-09
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    HandlerInterceptor interceptor1;
    @Autowired
    HandlerInterceptor interceptor2;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor1);
        registry.addInterceptor(interceptor2);
    }
}
