package com.lvxiao.designpattern.decoration;

/**
 * @author lvxiao
 * @date 2019/8/5
 */
public class RoastFood extends FoodDecoration {

    private Food food;

    public RoastFood(Food f){
        this.food = f;
    }

    @Override
    public String getDesc() {
        return getDecoration() + food.getDesc();
    }

    private String getDecoration(){
        return "烤";
    }
}
