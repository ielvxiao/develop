package com.lvxiao.multithread.communication;

/**
 * 线程之间的通信
 *
 * 开发中不免会遇到需要所有子线程执行完毕通知主线程处理某些逻辑的场景。
 * @author lvxiao
 * @version V1.0
 * @date 2019-07-18 00:32
 */
class OddProducer implements Runnable{
    public static Object lock = new Object();
    public static Integer i = 0;

    @Override
    public void run() {
        System.out.println(++i);
        try {
            lock.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.notify();
    }
}
class EvenProducer implements Runnable{

    @Override
    public void run() {

    }
}
public class ThreadCommunication {

}
