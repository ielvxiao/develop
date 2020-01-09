package com.lvxiao.spring.boot.config;

import lombok.Data;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2020/1/9 4:46 下午
 */
@Data
public class EnvConfig implements EnvironmentAware {

    private Environment env;

    @Override
    public void setEnvironment(Environment environment) {
        env = environment;
    }
}
