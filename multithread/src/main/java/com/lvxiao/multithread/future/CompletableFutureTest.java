package com.lvxiao.multithread.future;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2020/2/20 11:14 下午
 */
public class CompletableFutureTest {
    /**
     * Manual Completion 手动完成
     */
    private static void manualCompletion() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "1111";
        });
        executorService.submit(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //手动结束核心
            future.complete("手动完成");
        });
        System.out.println(future.get());
        executorService.shutdown();
    }

    /**
     * 调用链
     */
    public static void callbackChain() throws ExecutionException, InterruptedException {
        CompletableFuture completableFuture
                = CompletableFuture
                .supplyAsync(() -> "Knolders!")
                .thenRun(() -> System.out.println("Example with thenRun()."));
        System.out.println(completableFuture.get());
    }

    /**
     * 组合
     */
    private static void thenCompose() {
        //并行计算获取组合结果
        CompletableFuture<String> completableFuture =
                CompletableFuture.supplyAsync(() -> "Hello")
                        .thenCompose(value ->
                                CompletableFuture.supplyAsync(
                                        () -> value + " hahaha! Its thenCompose"));
        completableFuture.thenAccept(System.out::println); // Hello Knolders! Its thenCompose
    }

    /**
     * 组合所有的结果
     */
    private static void allOf() throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture1
                = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> completableFuture2
                = CompletableFuture.supplyAsync(() -> "lv!");
        CompletableFuture<String> completableFuture3
                = CompletableFuture.supplyAsync(() -> "Its allOf");
/*
这个方法并不直接返回结果只是返回一个CompletableFuture
 */
        CompletableFuture<Void> combinedFuture
                = CompletableFuture.allOf(completableFuture1, completableFuture2, completableFuture3);

        System.out.println(combinedFuture.get()); //输出null

        assert (completableFuture1.isDone());
        assert (completableFuture2.isDone());
        assert (completableFuture3.isDone());
        //使用以下两种方法获取最终结果
        CompletableFuture<List<String>> listCompletableFuture = combinedFuture.thenApply(v ->
                Stream.of(completableFuture1, completableFuture2, completableFuture3).
                        map(CompletableFuture::join).
                        collect(Collectors.toList()));
        System.out.println(listCompletableFuture.get());

        String combined = Stream.of(completableFuture1, completableFuture2, completableFuture3)
                .map(CompletableFuture::join)
                .collect(Collectors.joining(" "));
        System.out.println(combined);
    }

    private static void exception() {
        Integer age = -1;
        CompletableFuture<String> exceptionFuture = CompletableFuture.supplyAsync(() -> {
            if (age < 0) {
                throw new IllegalArgumentException("Age can not be negative");
            }
            if (age > 18) {
                return "Adult";
            } else {
                return "Child";
            }
        }).exceptionally(ex -> {
            System.out.println("Oops! We have an exception - " + ex.getMessage());
            return "Unknown!";
        });
        exceptionFuture.thenAccept(System.out::println); //Unknown!
    }

    private static void exceptionUsingHandle() {
        Integer age = -1;
        CompletableFuture<String> exceptionFuture = CompletableFuture.supplyAsync(() -> {
            if (age < 0) {
                throw new IllegalArgumentException("Age can not be negative");
            }
            if (age > 18) {
                return "Adult";
            } else {
                return "Child";
            }
        }).handle((result, ex) -> {
            if (ex != null) {
                System.out.println("Oops! We have an exception - " + ex.getMessage());
                return "Unknown!";
            }
            return result;
        });
        exceptionFuture.thenAccept(System.out::println); // Unknown!
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFutureTest.exception();
    }
}
