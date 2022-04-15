package com.lvxiao.spring.filterbase.filter;

import java.io.IOException;
import java.util.Random;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.lvxiao.spring.filterbase.ContextLocal;
import com.lvxiao.spring.filterbase.ContextLocalKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author hongqi
 * @date 2022/03/28
 */
@Component
@Order(1)
public class Filter0 implements Filter {
       private static final Logger logger = LoggerFactory.getLogger(Filter0.class);

    public static final ContextLocalKey<Integer> TEST = ContextLocalKey.withDefaultValue(666);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
        throws IOException, ServletException {
        logger.info("默认test是:{}", TEST.get());
        TEST.set(get());
        logger.info("设置后的值是:{}", TEST.get());
        filterChain.doFilter(servletRequest, servletResponse);
        ContextLocal.endScope();
        logger.info("销毁后，test Filter0获取到的值是:{}", TEST.get());
    }

    private static int get() {
        return new Random().nextInt(1000);
    }
}
