package com.lvxiao.multithread.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 使用ConcurrentHashMap遍历时不会报ConcurrentModificationException。但是HashMap会。
 * 主要原因是table用violatile修饰，使得读操作可以收到更新。加上hapend-before机制，避免读取到更新前的数据
 * @author lvxiao
 * @version V1.0
 * @date 2019/9/30 9:53 上午
 */
class Break {
    public static void main(String[] args) {
        for (int i = 100; i < 1000; i++) {
            ConcurrentHashMapTest.map.put(i, i);
            ConcurrentHashMapTest.concurrentHashMap.put(i, i);
        }
    }
}
public class ConcurrentHashMapTest {
    public static ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>();

    public static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            ConcurrentHashMapTest.map.put(i, i);
            ConcurrentHashMapTest.concurrentHashMap.put(i, i);
        }
        new Thread(() -> {
            //换成hashmap会报错
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                System.out.println(entry.getValue());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                ConcurrentHashMapTest.map.put(1000-i, 1000-i);
                ConcurrentHashMapTest.concurrentHashMap.put(i, i);
            }
        }).start();
    }
}
