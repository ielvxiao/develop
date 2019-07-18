package com.lvxiao.designpattern.singleton;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019-07-18 15:01
 */
enum SingletonEnum{
    /**
     * 创建枚举默认就是线程安全的，所以不需要担心double checked locking，而且还能防止反序列化导致重新创建新的对象。
     */
    SINGLETON_ENUM
}
public class Singleton {
    private static Singleton ourInstance;
    private Singleton() {
    }
    //===================创建单例模式的方法探索=========================
    /**
     * 懒汉模式，当调用方法适合才创建，可能出现线程问题
     * @return
     */
    public static Singleton getInstance() {
        if (ourInstance == null) {
            return new Singleton();
        }
        return ourInstance;
    }

    /**
     * 上一个方法的改造版。虽然解决了线程问题，但是效率太低
     * @return
     */
    public synchronized static Singleton getInstance1() {
        if (ourInstance == null) {
            return new Singleton();
        }
        return ourInstance;
    }

    /**
     * 上一个版本的改造版，依然存在问题。new Singleton()不是原子操作，存在指令重排序的问题。所以可能存在返回Null的情况。解决办法是加volatile关键字
     * @return
     */
    public static Singleton getInstance2() {
        if (ourInstance == null) {
            synchronized (Singleton.class) {
                if (ourInstance == null) {
                    return new Singleton();
                }
            }
        }
        return ourInstance;
    }

    /**
     * 类加载的时候初始化，不会出现线程问题，但是存在的问题是不能动态配置初始化参数，不属于懒加载模式
     */
    private static final Singleton SINGLETON = new Singleton();
    public static Singleton getInstance3() {
        return SINGLETON;
    }


    //===================以下是推荐使用的方法=========================

    /**
     * 静态内部类，懒汉模式，没有线程问题
     */
    private static class SingletonHolder{
        private static final Singleton INSINGLETON = new Singleton();
    }
    public static Singleton getInstance4() {
        return SingletonHolder.INSINGLETON;
    }

    /**
     * 还有一种非常简单的实现方式就是使用enum。
     * @see SingletonEnum
     */
}
