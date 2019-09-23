package com.lvxiao.jvm.classloader.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/9/20 5:04 下午
 */
@Data
@AllArgsConstructor
public class User implements Serializable {
    private Integer id;
    private String name;

}
