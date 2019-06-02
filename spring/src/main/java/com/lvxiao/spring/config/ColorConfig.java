package com.lvxiao.spring.config;

import com.lvxiao.spring.domain.Color;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019-06-02 12:15
 */
@Configuration
public class ColorConfig {

    @Bean(value = "color", initMethod = "init", destroyMethod = "destroy")
    public Color getColor() {
        return new Color();
    }

}
