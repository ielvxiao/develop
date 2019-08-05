package com.lvxiao.designpattern.decoration;

/**
 * @author lvxiao
 * @date 2019/8/5
 */
public class Duck extends Food {
    public Duck(){
        desc = "鸭肉";
    }
    @Override
    public String getDesc() {
        return desc;
    }
}
