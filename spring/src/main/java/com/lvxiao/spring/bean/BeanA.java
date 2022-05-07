package com.lvxiao.spring.bean;

import java.util.List;

import lombok.Data;

/**
 * @author hongqi
 * @date 2022/05/07
 */
@Data
public class BeanA {
    private int anInt;
    private List<BeanA> list;
}
