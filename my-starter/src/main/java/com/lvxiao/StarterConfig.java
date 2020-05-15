package com.lvxiao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lvxiao
 * @date 2020/5/15
 */
@Configuration
@ConditionalOnClass(Starter.class) //当classpath下发现该类的情况下进行自动配置。
@EnableConfigurationProperties(Starter.class)
public class StarterConfig {

    private final Starter starter;

    @Autowired
    public StarterConfig(Starter starter) {
        this.starter = starter;
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "example.service", value = "enabled", havingValue = "true")
    Starter starter() {
        return starter;
    }
}
