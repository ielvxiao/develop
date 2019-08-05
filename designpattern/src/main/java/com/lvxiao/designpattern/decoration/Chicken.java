package com.lvxiao.designpattern.decoration;

/**
 * @author lvxiao
 * @date 2019/8/5
 */
public class Chicken extends Food {

    public Chicken(){
        desc = "鸡肉";
    }

    @Override
    public String getDesc() {
        return desc;
    }
}
