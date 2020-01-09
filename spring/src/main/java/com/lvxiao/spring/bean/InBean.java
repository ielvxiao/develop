package com.lvxiao.spring.bean;

import lombok.Data;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2020/1/9 10:19 上午
 */
@Data
public class InBean {
    private LifeCycleBean lifeCycleBean;

    public InBean(LifeCycleBean lifeCycleBean) {
        this.lifeCycleBean = lifeCycleBean;
    }
}
