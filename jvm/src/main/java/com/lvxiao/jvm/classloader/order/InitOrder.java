package com.lvxiao.jvm.classloader.order;

/**
 * 初始化顺序：
 * <p>1.父类方法的静态属性，按照顺序</p>
 * <p>2.子类方法的静态属性</p>
 * <p>3.父类方法的非静态属性，按照顺序</p>
 * <p>4.子类方法的非静态属性</p>
 * <p>5.父类构造器</p>
 * <p>6.子类构造器</p>
 * <p>总体流程为：1优先级：静态比非静态优先；2优先级：父类比子类优先；3优先级：属性比构造器优先</p>
 * <p>对于接口中的变量，如果没有调用，则不会触发初始化</p>
 * @author lvxiao
 * @date 2020/7/12
 */
class Domain {
    public Domain(String name) {
        System.out.println("调用了Domain的构造方法"+name);
    }
}
interface In1{
    Domain DOMAIN = new Domain("接口1");

    void test();
}
interface In2 extends In1{
    Domain DOMAIN1 = new Domain("接口2");

}
abstract class Parent {
    static {
        System.out.println("静态代码块1");
    }
    public static Domain domain = new Domain("抽象类1");

    private Domain domain2 = new Domain("父类普通变量1");
    {
        System.out.println("父类普通代码块");
    }
    private Domain domain3 = new Domain("父类普通变量2");

    public static Domain domain1 = new Domain("抽象类2");
    static {
        System.out.println("静态代码块2");
    }

    public Parent() {
        System.out.println("父类的构造器");
    }
}
class Children extends Parent implements In2{
    public static Domain domain1 = new Domain("子类内静态变量");

    private Domain domain2 = new Domain("子类普通变量1");
    {
        System.out.println("子类普通代码块");
    }
    private Domain domain3 = new Domain("子类普通变量2");
    static {
        System.out.println("子类静态代码块1");
    }

    public Children() {
        System.out.println("子类构造器");
//        System.out.println(DOMAIN);
    }

    @Override
    public void test() {
        System.out.println("Test");
    }
}
public class InitOrder {
    public static void main(String[] args) {
        Children children = new Children();
        children.test();
        System.out.println(Children.DOMAIN1);
    }
}
