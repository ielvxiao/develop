package com.lvxiao;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @author lvxiao
 * @date 2020/5/18
 */
@Data
@AllArgsConstructor
class Ha{
    private Integer id;
    private String name;
}
class T{
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue =
                new SynchronousQueue<>();
        System.out.println(queue.offer(1));
        System.out.println(queue.offer(2));
        System.out.println(queue.offer(3));
        System.out.println(queue.poll());
        System.out.println(queue.size());
    }
}
public class Test {
    private static ExecutorService pool= Executors.newFixedThreadPool(10);

    public static void main(String[] args)throws Exception {
        CompletableFuture<List<Ha>> future = CompletableFuture
                .supplyAsync(()->{
                    List<Ha> list = new ArrayList<>();
                    System.out.println("1===="+Thread.currentThread().getName());

                    list.add(new Ha(1,"吕"));
                    return list;
                },pool)
                .thenCombineAsync(CompletableFuture
                        .supplyAsync(()->{
                            List<Ha> list = new ArrayList<>();
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println("2===="+Thread.currentThread().getName());
                            list.add(new Ha(2,"啸"));
                            return list;
                        },pool),(list1,list2)->{
                    list1.addAll(list2);
                    return list1;
                })
                .thenCombineAsync(CompletableFuture
                        .supplyAsync(()->{
                            System.out.println("3===="+Thread.currentThread().getName());

                            Map<String, Integer> map = new HashMap<>();
                            map.put("啸",3);
                            return map;
                        },pool),(list1,map)->{
                    for (Ha ha : list1) {
                        if (map.containsKey(ha.getName())) {
                            ha.setId(map.get(ha.getName()));
                        }
                    }
                    return list1;
                }).exceptionally(ex->{
                    ex.printStackTrace();
                    return new ArrayList<>();
                });
        System.out.println(future.get());
        System.out.println(Thread.currentThread());
        pool.shutdown();
    }
}
