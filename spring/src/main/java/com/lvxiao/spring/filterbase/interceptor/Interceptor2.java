package com.lvxiao.spring.filterbase.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author lvxiao <lvxiao@kuaishou.com>
 * Created on 2021-01-09
 */
@Component
@Order(2)
public class Interceptor2 implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(Interceptor2.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        logger.info("Interceptor2 preHandle is invoked!!!");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        logger.info("Interceptor2 postHandle is invoked!!");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        logger.info("Interceptor2 after completion!!!!!!", ex);
    }
}
