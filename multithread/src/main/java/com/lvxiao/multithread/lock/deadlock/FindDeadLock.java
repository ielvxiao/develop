package com.lvxiao.multithread.lock.deadlock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

/**
 * 查找死锁
 *
 * @author lvxiao
 * @version V1.0
 * @date 2020/1/27 6:22 下午
 */
public class FindDeadLock {
    private static void detectDeadLock() {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long[] deadlockedThreads = threadMXBean.findDeadlockedThreads();
        System.out.println("Dead lock found：" + (deadlockedThreads != null && deadlockedThreads.length > 0));
    }
}
