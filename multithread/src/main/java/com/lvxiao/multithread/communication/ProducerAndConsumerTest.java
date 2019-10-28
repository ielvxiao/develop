package com.lvxiao.multithread.communication;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/10/28 3:35 下午
 */
class Producer extends Thread {
    List<Integer> list;
    private Integer count = 0;

    public Producer(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        long old = System.currentTimeMillis();
        while (true) {
            synchronized (list) {
                //一秒钟产生一条消息
                if (System.currentTimeMillis() - old < 1000) {
                    continue;
                } else {
                    old = System.currentTimeMillis();
                }
                list.add(++count);
                System.out.println("producer生产了数据：" + count);
                //有了消息就通知
                list.notify();
            }
        }
    }
}

class Consumer extends Thread {
    List<Integer> list;

    public Consumer(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (list) {
                //没有消息就等待
                if (list.isEmpty()) {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("consumer消费了数据：" + list.remove(0)+",消息总条数:"+list.size());
            }
        }
    }
}

public class ProducerAndConsumerTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Producer producer = new Producer(list);
        Consumer consumer = new Consumer(list);
        producer.start();
        consumer.start();
    }
}
