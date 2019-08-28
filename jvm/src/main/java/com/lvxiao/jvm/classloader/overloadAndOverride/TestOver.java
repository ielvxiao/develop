package com.lvxiao.jvm.classloader.overloadAndOverride;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lvxiao
 * @date 2019/8/28
 */
class Parent {
    void print(String a) {
        System.out.println("Parent - String");
    }

    void print(Object a) {
        System.out.println("Parent - Object");
    }
}

class Child extends Parent {
    void print(String a) {
        System.out.println("Child - String");
    }

    void print(Object a) {
        System.out.println("Child - Object");
    }
}

class Foo {
    void print(Cloneable a) {
        System.out.println("I am cloneable!");
    }

    void print(Map a) {
        System.out.println("I am Map!");
    }
}

class Parent1 {
    void print() {
        staticMethod(); //如果调用者是别的实例，因为staticMethod是静态方法，所以最后调用的方法还是print()这个中介所对应的staticMethod()
        instanceMethod();
    }

    static void staticMethod() {
        System.out.println("Parent::staticMethod");
    }

    void instanceMethod() {
        System.out.println("Parent::instanceMethod");
    }
}

class Child1 extends Parent1 {
    static void staticMethod() {
        System.out.println("Child::staticMethod");
    }

    @Override
    void instanceMethod() {
        System.out.println("Child::instanceMethod");
    }
}

public class TestOver {
    public static void main(String[] args) {
        String string = "";
        Object stringObject = string;

// What gets printed?
        Child child = new Child();
        child.print(string);
        child.print(stringObject);

        Parent parent = new Child();
        parent.print(string);
        parent.print(stringObject);

        HashMap cloneableMap = new HashMap();
        Cloneable cloneable = cloneableMap;
        Map map = cloneableMap;

// What gets printed?
        Foo foo = new Foo();
        foo.print(map);
        foo.print(cloneable);
//        foo.print(cloneableMap);
        Child1 child1 = new Child1();
        child1.print();
    }
}
