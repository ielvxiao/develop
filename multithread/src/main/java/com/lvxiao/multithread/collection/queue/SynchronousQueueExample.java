package com.lvxiao.multithread.collection.queue;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/10/9 5:38 下午
 */
public class SynchronousQueueExample {

    static class SynchronousQueueProducer implements Runnable {

        protected BlockingQueue<String> blockingQueue;
        final Random random = new Random();

        public SynchronousQueueProducer(BlockingQueue<String> queue) {
            this.blockingQueue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    String data = UUID.randomUUID().toString();
                    System.out.println("Put: " + data);
                    blockingQueue.put(data);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    static class SynchronousQueueConsumer implements Runnable {

        protected BlockingQueue<String> blockingQueue;

        public SynchronousQueueConsumer(BlockingQueue<String> queue) {
            this.blockingQueue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    String data = blockingQueue.take();
                    System.out.println(Thread.currentThread().getName()
                            + " take(): " + data);
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private static void SynchronousQueueTest(BlockingQueue<String> synchronousQueue) {
        SynchronousQueueProducer queueProducer = new SynchronousQueueProducer(
                synchronousQueue);
        new Thread(queueProducer).start();

        SynchronousQueueConsumer queueConsumer1 = new SynchronousQueueConsumer(
                synchronousQueue);
        new Thread(queueConsumer1).start();

        SynchronousQueueConsumer queueConsumer2 = new SynchronousQueueConsumer(
                synchronousQueue);
        new Thread(queueConsumer2).start();

    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> synchronousQueue = new SynchronousQueue<String>();
        SynchronousQueueTest(synchronousQueue); //如果传入的是SynchronousQueue则，输出是一个put一个get
        /*
        传入ArrayBlockingQueue则该队列可以最多储存10个任务，超过该任务数，put阻塞。如果队列为空，则take阻塞。
         */
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<String>(10);
        SynchronousQueueProducer queueProducer = new SynchronousQueueProducer(
                arrayBlockingQueue);
        new Thread(queueProducer).start();
        TimeUnit.MILLISECONDS.sleep(1000);
        SynchronousQueueConsumer queueConsumer2 = new SynchronousQueueConsumer(
                arrayBlockingQueue);
        new Thread(queueConsumer2).start();
    }
}
