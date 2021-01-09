package com.lvxiao.spring.filterbase.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author lvxiao <lvxiao@kuaishou.com>
 * Created on 2021-01-09
 */
@Component
@Order(2)
public class Filter2 implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(Filter2.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        logger.info("fileter2-pre");
        filterChain.doFilter(servletRequest, servletResponse);
        logger.info("fileter2-after");
    }
}
