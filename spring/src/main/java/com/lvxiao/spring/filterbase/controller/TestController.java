package com.lvxiao.spring.filterbase.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lvxiao <lvxiao@kuaishou.com>
 * Created on 2021-01-09
 */
@RestController
public class TestController {
    @RequestMapping("/")
    public String test() {
        return "1";
    }
}
