package com.lvxiao;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author lvxiao
 * @date 2020/5/15
 */
@Component
@ConfigurationProperties("example.service")
@Data
public class Starter {

    private String prefix;
    private String suffix;

}
