package com.lvxiao.spring.bean;

import java.util.List;

import lombok.Data;

/**
 * @author hongqi
 * @date 2022/05/07
 */
@Data
public class BeanB {
    private int anInt;
    private List<BeanB> list;
}
