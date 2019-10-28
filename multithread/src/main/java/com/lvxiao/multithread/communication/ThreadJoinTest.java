package com.lvxiao.multithread.communication;


/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/10/28 11:30 上午
 */
public class ThreadJoinTest extends Thread {

    private String name;
    public ThreadJoinTest(String name) {
        super(name);
        this.name=name;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " 线程运行开始!");
        for (int i = 0; i < 5; i++) {
            System.out.println("子线程" + Thread.currentThread().getName() + "运行 : " + i);
//                sleep((int) Math.random() * 10);

        }
        System.out.println(Thread.currentThread().getName() + " 线程运行结束!");
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+"主线程运行开始!");
        ThreadJoinTest mTh1=new ThreadJoinTest("A");
        ThreadJoinTest mTh2=new ThreadJoinTest("B");
        mTh2.start();
        mTh2.join(); //mTh2执行完毕后再执行别的线程
        mTh1.start();
        mTh1.join(); //如果不加入该行代码，则下方打印内容可能提前
        System.out.println(Thread.currentThread().getName()+ "主线程运行结束!");

    }

}
