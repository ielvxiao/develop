package com.lvxiao.designpattern;

/**
 * 工厂模式：
 * <p>创建抽象工厂</p>
 * <p>创建抽象产品</p>
 * <p>创建具体产品</p>
 * <p>创建具体工厂</p>
 *
 * @author lvxiao
 * @date 2019/4/28
 */
abstract class Factory {
    public abstract Product Manufacture();
}

abstract class Product {
    public abstract void Show();
}

class ProductA extends Product {

    @Override
    public void Show() {
        System.out.println("我是A");
    }
}

class ProductB extends Product {

    @Override
    public void Show() {
        System.out.println("我是B");
    }
}

class FactoryA extends Factory {

    @Override
    public Product Manufacture() {
        return new ProductA();
    }
}

class FactoryB extends Factory {

    @Override
    public Product Manufacture() {
        return new ProductB();
    }
}

public class FactoryPattern {
    public static void main(String[] args) {
        Factory factoryA = new FactoryA();
        factoryA.Manufacture().Show();

        Factory factoryB = new FactoryB();
        factoryB.Manufacture().Show();
    }
}
