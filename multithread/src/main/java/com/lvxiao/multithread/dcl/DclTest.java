package com.lvxiao.multithread.dcl;

/**
 * double check lock
 * 双重检查
 *<p>添加-XX:+UnlockDiagnosticVMOptions -XX:+PrintAssembly打印汇编码
 * ，可以看到使用volatile的变量操作前会加一个lock标识，这个会设置cpu的lock#信号
 * 该信号保证了访问的原子性，还可以保证缓存一致性(缓存一致性实现方式有锁定总线，和MESI缓存一致性，这个是硬件级别的实现。)</p>
 * <p>1.使用volatile关键字，防止指令重排序new DclTest()不会重排序。如果发生重排序，多线程下第一个判断null的时候，可能导致直接返回一个非null的空对象。</p>
 * <p>2.第一个if，将它放在synchronized之外，提高性能，如果singleton不为null，直接返回不用获取锁。</p>
 * <p>3.使用synchronized防止多线程问题，重复创建</p>
 * <p>4.第二个if，保证多个线程进入第一个if后，等待锁，有一个线程成功创建线程后，其他线程进入同步代码块后不重复创建对象/p>
 * <p>5.调用private构造器，防止人为调用构造器创建对象</p>
 * @author lvxiao
 * @date 2020/5/26
 */
public class DclTest {

    private static volatile DclTest singleton;

    private DclTest() {
    }

    public static DclTest getInstance2() {
        if (singleton == null) {
            synchronized (DclTest.class) {
                if (singleton == null) {
                    singleton = new DclTest();
                }
            }
        }
        return singleton;
    }
}
