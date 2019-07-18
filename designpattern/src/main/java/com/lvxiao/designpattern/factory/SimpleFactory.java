package com.lvxiao.designpattern.factory;

/**
 * 简单工厂模式
 *
 * @author lvxiao
 * @version V1.0
 * @date 2019-07-18 14:12
 */
interface Shape {
    void draw();
}

class CircleShape implements Shape {

    @Override
    public void draw() {
        System.out.println("draw circle");
    }
}

class RectShape implements Shape {


    @Override
    public void draw() {
        System.out.println("draw rect");
    }
}

public class SimpleFactory {
    /**
     * 简单工厂根据传入的shapeName找出对应的类
     *
     * @param shapeName 传入名称
     * @return  返回实体
     */
    public static Shape getShape(String shapeName) {
        Shape shape = null;
        if (shapeName.equals("circle")) {
            shape = new CircleShape();
        } else if (shapeName.equals("rect")) {
            shape = new RectShape();
        }
        return shape;
    }
}
