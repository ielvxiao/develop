package com.lvxiao.spring.bean;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/10/23 1:53 下午
 */
@Aspect
@Component
public class AspectTest {

    @Pointcut(value = "execution(* com.lvxiao.spring.bean.AopTarget.*(..))")
    public void pointcut() {

    }

    @Around(value = "pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("进入环绕方法" + joinPoint.getSignature());
        return joinPoint.proceed();
    }
}
