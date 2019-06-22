package com.lvxiao.spring.aware;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019-06-15 11:23
 */
@Component
public class AwareBean implements BeanNameAware {

    private String name;

    @Override
    public void setBeanName(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println("容器被感知--BeanNameAware:Bean name is'" + this.name + "'.>>"+name);
    }
}
