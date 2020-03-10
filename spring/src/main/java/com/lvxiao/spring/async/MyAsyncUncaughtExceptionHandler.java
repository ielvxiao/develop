package com.lvxiao.spring.async;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;

/**
 * 设置异常Handler
 * @author lvxiao
 * @version V1.0
 * @date 2020/3/10 4:07 下午
 */
public class MyAsyncUncaughtExceptionHandler implements AsyncUncaughtExceptionHandler {
    @Override
    public void handleUncaughtException(Throwable throwable, Method method, Object... objects) {
        throwable.printStackTrace();
    }
}
