package com.lvxiao.spring.factorybean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/12/29 7:39 下午
 */
public class FactoryBeanTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println("容器启动完成");
        UserService userService = applicationContext.getBean(UserService.class);
        System.out.println(userService);
        Object customerFactoryBean = applicationContext.getBean("customerFactoryBean");
        System.out.println(customerFactoryBean);
        System.out.println(userService==customerFactoryBean); //通过类型和名字获取的bean是一个
    }

}
