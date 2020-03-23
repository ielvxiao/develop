package com.lvxiao.dubbo.manual.raw.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/10/28 5:50 下午
 */
@Data
@AllArgsConstructor
public class Student implements Serializable {
    private int age;

}
