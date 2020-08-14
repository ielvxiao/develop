package com.lvxiao.multithread.exception;

import lombok.SneakyThrows;

/**
 * @author lvxiao
 * @date 2020/8/14
 */
public class ThreadException {
    private static class T extends Thread {
        @SneakyThrows
        @Override
        public void run() {
            System.out.println("aa");
            throw new Exception("hhh");
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            T t = new T();
            //这里设置uncaughtExceptionHandler可以接管Thread中发生的异常，如果不设置则会抛出
            t.setUncaughtExceptionHandler((t1, e) -> System.out.println(t1.getName()+"发生了异常："+e.getMessage()));
            t.start();
        }
    }

}
