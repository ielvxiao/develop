package com.lvxiao.multithread.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicMarkableReference;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019-07-17 21:04
 */
public class AtomicTest {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(12);
        int in = atomicInteger.incrementAndGet();
    }
}
