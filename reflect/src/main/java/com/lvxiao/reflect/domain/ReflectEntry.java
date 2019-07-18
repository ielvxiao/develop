package com.lvxiao.reflect.domain;


import lombok.Getter;
import lombok.Setter;

/**
 * @author lvxiao
 * @date 2019/5/24
 */
@Getter
@Setter
public class ReflectEntry {

    private String name;
    private Integer id;


    private String test(String name) {
        return "我是" + name;
    }
}
