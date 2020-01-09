package com.lvxiao.spring.boot.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.PropertyResolver;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2020/1/9 2:15 下午
 */
@Configuration
@ConditionalOnClass(PropertyResolver.class)
public class AutoConfigTest {

    @Bean
    public EnvConfig envConfig() {
        return new EnvConfig();
    }
}
