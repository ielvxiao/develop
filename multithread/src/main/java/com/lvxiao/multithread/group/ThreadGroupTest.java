package com.lvxiao.multithread.group;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/12/28 9:17 下午
 */
public class ThreadGroupTest {
    public static void main(String[] args) {
//        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
//        ThreadGroup systemGroup = mainGroup.getParent();
//        System.out.println(systemGroup.getName());
//        System.out.println(mainGroup.getName());

        ThreadGroup tg = new ThreadGroup ("subgroup 1");
        Thread t1 = new Thread (tg, "thread 1");
        Thread t2 = new Thread (tg, "thread 2");
        Thread t3 = new Thread (tg, "thread 3");
        tg = new ThreadGroup ("subgroup 2");
        Thread t4 = new Thread (tg, "my thread");
        tg = Thread.currentThread ().getThreadGroup ();
        int agc = tg.activeGroupCount ();
        System.out.println ("Active thread groups in " + tg.getName () + " thread group: " + agc);
        tg.list ();
    }
}
