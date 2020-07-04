package com.lvxiao.jvm.abstractclass;

/**
 * 查看ByteCode。可以发现
 *         Human man = new Man();
 *         test.hello(man);
 *         test1.hello(man);
 *         中传入的man都是 Human，则在编译期间，没有传入其真正的类型Human。
 *而上边的两个重载方法，则能看出传入参数的不同。
 * @author lvxiao
 * @date 2020/7/4
 */

public class Test extends Test1{
//    @Override
//    void hello(Man man) {
//        System.out.println("我是子类的man");
//    }

    @Override
    public void hello(Human man) {
        System.out.println("我是父类的Human");
    }

    void hello1(Man man) {
        System.out.println("我是父类的Man");
    }

    public void hello1(String s){

    }
    public static void main(String[] args) {
        Test test = new Test();
        Test1 test1 = new Test1();
        Human man = new Man();
        test.hello(man);
        test1.hello(man);
    }
}
