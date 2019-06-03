package com.lvxiao.jvm.classloader;

/**
 * 1.首先为类变量赋值,a,b是int默认都是0.
 * 2.执行<clinit>（）方法为他们赋值，a先被赋值为1，然后被赋值为2.最后b赋值为2。如果交换静态代码块的顺序，则结果也会变化。
 * @author lvxiao
 * @date 2019/6/3
 */
class Father {
    /**
     * 交换public static int a = 1;的顺序，则结果也会变化，证明他们两个是一起，按照顺序初始化的
     */
    static {
        a = 2;
       // System.out.println(a); 会报错，a还没有初始化，只能赋值不能访问。
    }

    public static int a = 1;
    public int c = 3;

}

class Child extends Father {
    public static int b = a;
    {
        a = 4;
    }
}
public class ChildTest {
    public static void main(String[] args) {
        System.out.println(Child.b);
    }
}
