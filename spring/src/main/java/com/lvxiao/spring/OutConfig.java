package com.lvxiao.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hongqi
 * @date 2021/12/17
 */
@Configuration
public class OutConfig {

    @Bean("testString")
    public String stringBean() {
        return "hello world";
    }
}
