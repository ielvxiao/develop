package com.lvxiao.jvm.classloader;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/11/7 6:14 下午
 */

class Fruit {}
class Apple extends Fruit {}
class Jonathan extends Apple {}
class Orange extends Fruit {}
interface In {

}
class InC implements In {

}
public class Test {

    public static void main(String[] args) {
        List<Apple> appleList = new ArrayList<>();
        List<Fruit> appleList1 = new ArrayList<>();
        appleList1.add(new Fruit());
        List<? extends Apple> extendApple = new ArrayList<>();
        extendApple = appleList;
        //下界
        List<? super Apple> flistBottem = new ArrayList<>();
        flistBottem = appleList1;
        flistBottem.add(new Apple());
        flistBottem.add(new Jonathan());
        Apple fruit = (Apple) flistBottem.get(0);
    }
}
