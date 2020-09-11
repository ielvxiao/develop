package com.lvxiao.multithread.future;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

/**
 * @author lvxiao <lvxiao@kuaishou.com>
 * Created on 2020-09-08
 */
public class ListenableFutureTest {
    //线程池中线程个数
    private static final int POOL_SIZE = 50;
    //带有回调机制的线程池
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(POOL_SIZE);
    private static final ListeningExecutorService SERVICE = MoreExecutors
            .listeningDecorator(EXECUTOR);

    public static void main(String[] args) {
        final List<String> value = Collections
                .synchronizedList(new ArrayList<>());
        try {
            List<ListenableFuture<String>> futures = new ArrayList<>();
            // 将实现了callable的任务放入到线程池中，得到一个带有回调机制的ListenableFuture实例，
            // 通过Futures.addCallback方法对得到的ListenableFuture实例进行监听，一旦得到结果就进入到onSuccess方法中，
            // 在onSuccess方法中将查询的结果存入到集合中
            for (int i = 0; i < 100; i++) {
                final int index = i;
                ListenableFuture<String> sfuture = SERVICE
                        .submit(() -> {
                            Thread.sleep(500 * index);
                            if (index % 10 == 0) {
                                throw new Exception("hhh");
                            }
                            long time = System.currentTimeMillis();
                            return String.valueOf(time);
                        });
                sfuture.addListener(() -> System.out.println(index), SERVICE);

                Futures.addCallback(sfuture, new FutureCallback<String>() {
                    public void onSuccess(String result) {
                        value.add(result);
                    }

                    public void onFailure(Throwable t) {
                        throw new RuntimeException(t);
                    }
                }, EXECUTOR);
                // 将每一次查询得到的ListenableFuture放入到集合中
                futures.add(sfuture);
            }

            // 这里将集合中的若干ListenableFuture形成一个新的ListenableFuture
            // 目的是为了异步阻塞，直到所有的ListenableFuture都得到结果才继续当前线程
            // 这里的时间取的是所有任务中用时最长的一个
            ListenableFuture<List<String>> allAsList = Futures.allAsList(futures);
            System.out.println(allAsList.get());
            SERVICE.shutdown();
        } catch (Exception ignored) {
        }
    }
}
