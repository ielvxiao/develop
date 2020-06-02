package com.lvxiao.multithread.juc;

import lombok.SneakyThrows;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

/**
 * @author lvxiao
 * @date 2020/6/2
 */
public class ExchangerTest {



    private class Consumer implements Runnable {
        private Exchanger<Integer> exchanger;
        private int i;

        public Consumer(Exchanger<Integer> exchanger, int i) {
            this.exchanger = exchanger;
            this.i = i;
        }

        @SneakyThrows
        @Override
        public void run() {
            while (true) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName()+"生产了数据:" + (--i));
                Integer exchange = exchanger.exchange(i);
                System.out.println(Thread.currentThread().getName()+"获得了数据：" + exchange);
            }
        }
    }

    public static void main(String[] args) {
        Exchanger<Integer> exchanger = new Exchanger<>();
        ExchangerTest test = new ExchangerTest();
        Consumer consumer = test.new Consumer(exchanger,200);
        Consumer consumer1 = test.new Consumer(exchanger,300);
        Consumer consumer2 = test.new Consumer(exchanger,100);
        Thread t1 = new Thread(consumer2, "consumer2");
        Thread t2 = new Thread(consumer, "consumer");
        Thread t3 = new Thread(consumer1, "consumer1");
        t1.start();
        t2.start();
        t3.start();
    }
}
