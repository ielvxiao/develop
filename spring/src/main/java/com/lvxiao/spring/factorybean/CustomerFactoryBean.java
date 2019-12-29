package com.lvxiao.spring.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.SmartFactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/12/29 7:40 下午
 */
@Component
public class CustomerFactoryBean implements SmartFactoryBean<UserService> {
    @Override
    public boolean isSingleton() {
        return false;
    }

    @Override
    public UserService getObject() throws Exception {
        return new UserService();
    }

    @Override
    public Class<?> getObjectType() {
        return UserService.class;
    }
}
