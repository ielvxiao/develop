package com.lvxiao.spring.bean;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

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

    @Bean
    public LifeCycleBean test() {
        return new LifeCycleBean();
    }
    
    //如果有多个LifeCycleBean而且参数名与它们不同，则需要通过@Qualifier区分
    @Bean
    public InBean inBean(@Qualifier("test") LifeCycleBean bean) {
        return new InBean(bean);
    }
}
