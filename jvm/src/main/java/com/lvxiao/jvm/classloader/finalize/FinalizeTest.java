package com.lvxiao.jvm.classloader.finalize;

/**
 * 覆盖了finalize()方法后，代表对象清楚前调用它做一些必要的清理工作。
 * 一般情况下，在垃圾回收期间，一个无法触及的对象会立即被销毁。不过，覆盖了 finalize() 方法的对象会被移动到一个队列里，一个独立的线程遍历这个队列，调用每一个对象的 finalize() 方法。在 finalize() 方法调用结束之后，这些对象才成为真正的垃圾，等待下一轮垃圾回收。
 * 从jdk9开始不推荐使用该方法
 * @author lvxiao
 * @version V1.0
 * @date 2020/1/3 11:06 下午
 */
public class FinalizeTest {


    public static void main(String[] args) {
        //如果调用这个方法，则会不断创建FinalizeTest实例，和java.lang.ref.Finalizer。如果不覆盖finalize()则只会产生FinalizeTest实例
        while (true) {
            FinalizeTest test = new FinalizeTest();
        }
    }
    @Override
    protected void finalize() throws Throwable {
        System.out.println("执行finalize");
        super.finalize();
    }
}
