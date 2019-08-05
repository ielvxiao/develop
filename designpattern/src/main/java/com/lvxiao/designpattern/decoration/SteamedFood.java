package com.lvxiao.designpattern.decoration;

/**
 * @author lvxiao
 * @date 2019/8/5
 */
public class SteamedFood extends FoodDecoration {
    private Food food;

    public SteamedFood(Food f){
        this.food = f;
    }

    @Override
    public String getDesc() {
        return getDecoration() + food.getDesc();
    }

    private String getDecoration(){
        return "蒸";
    }
}
