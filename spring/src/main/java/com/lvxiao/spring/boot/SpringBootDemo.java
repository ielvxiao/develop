package com.lvxiao.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2020/1/9 2:03 下午
 */
@SpringBootApplication
@Controller
public class SpringBootDemo {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemo.class);
    }

    @GetMapping("/index")
    @ResponseBody
    public String index() {
        return "spring boot";
    }
}
