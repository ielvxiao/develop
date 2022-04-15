package com.lvxiao.spring.filterbase.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hongqi
 * @date 2022/03/30
 */
@RestController
@RequestMapping(value = {"/{language}/account", "/account"})
public class Test1Controller {

    @GetMapping("/test")
    public void test() {
        System.out.println("获取到的language=");
    }
}
