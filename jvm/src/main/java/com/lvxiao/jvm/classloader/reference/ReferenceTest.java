package com.lvxiao.jvm.classloader.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2020/1/3 6:02 下午
 */
public class ReferenceTest {
    /**
     * 只有当内存不够的时候才回收软引用类型，所以执行结果一直是
     * java.lang.Object@3cd1a2f1
     * null
     * java.lang.Object@3cd1a2f1
     * null
     */
    public static void soft() throws InterruptedException {
        Object o = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        SoftReference<Object> softReference = new SoftReference<>(o, referenceQueue);
        System.out.println(softReference.get());
        System.out.println(referenceQueue.poll());

        // 清除强引用,触发GC
        o = null;
        System.gc();

        System.out.println(softReference.get());

        Thread.sleep(2000);
        System.out.println(referenceQueue.poll());
    }

    /**
     * 弱引用: 当发生GC的时候,Weak引用对象总是会内回收回收。因此Weak引用对象会更容易、更快被GC回收。
     * Weak引用对象常常用于Map数据结构中，引用占用内存空间较大的对象
     *
     * <pre>
     * 如果不发生垃圾回收：
     * java.lang.Object@f9f9d8
     * null
     * java.lang.Object@f9f9d8
     * null
     *
     * 如果发生垃圾回收:
     * java.lang.Object@f9f9d8
     * null
     * null
     * java.lang.ref.WeakReference@422ede
     *
     * <pre>
     */
    public static void weak() throws InterruptedException {
        Object o = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        WeakReference<Object> weakReference = new WeakReference<>(o, referenceQueue);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());

        // 清除强引用,触发GC
        o = null;
        System.gc();

        System.out.println(weakReference.get());

        Thread.sleep(2000);
        System.out.println(referenceQueue.poll());
    }

    /**
     * 当GC一但发现了虚引用对象，将会将PhantomReference对象插入ReferenceQueue队列.
     * 而此时PhantomReference所指向的对象并没有被GC回收，而是要等到ReferenceQueue被你真正的处理后才会被回收.
     *
     * <pre>
     * 不发生GC执行结果是:
     * null
     * null
     * null
     * null
     *
     * 发生GC执行结果是:
     * null
     * null
     * null
     * java.lang.ref.PhantomReference@87816d
     * </pre>
     * <p>
     * 虚引用在实现一个对象被回收之前必须做清理操作是很有用的,比finalize()方法更灵活
     */
    public static void phantom() throws InterruptedException {
        Object o = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        PhantomReference<Object> phantomReference = new PhantomReference<>(o, referenceQueue); //参数中必须有ReferenceQueue
        System.out.println(phantomReference.get());
        System.out.println(referenceQueue.poll());

        // 清除强引用,触发GC
        o = null;
        System.gc();
        // 调用phanRef.get()不管在什么情况下会一直返回null
        System.out.println(phantomReference.get());

        // 当GC发现了虚引用，GC会将phanRef插入进我们之前创建时传入的refQueue队列
        // 注意，此时phanRef所引用的obj对象，并没有被GC回收，在我们显式地调用refQueue.poll返回phanRef之后
        // 当GC第二次发现虚引用，而此时JVM将phanRef插入到refQueue会插入失败，此时GC才会对obj进行回收
        Thread.sleep(2000);
        System.out.println(referenceQueue.poll());
    }

    public static void main(String[] args) throws InterruptedException {
        phantom();
    }
}
