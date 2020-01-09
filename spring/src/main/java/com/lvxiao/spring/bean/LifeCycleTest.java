package com.lvxiao.spring.bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019-08-20 00:32
 */
public class LifeCycleTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LifeCycleBeanConfig.class);
        LifeCycleBean bean = (LifeCycleBean) context.getBean("lifeCycleBean");
        System.out.println(bean.getName());
        AopTarget aopTarget = (AopTarget) context.getBean("aopTarget");
        aopTarget.testAop("aaa");
        InBean inBean = (InBean) context.getBean("inBean");
        System.out.println(inBean.toString());
        context.close();
    }
}
