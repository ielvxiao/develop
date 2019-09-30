package com.lvxiao.multithread.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/9/30 9:53 上午
 */
class Break {
    public static void main(String[] args) {
        for (int i = 100; i < 1000; i++) {
            MapTest.map.put(i, i);
            MapTest.concurrentHashMap.put(i, i);
        }
    }
}
public class MapTest {
    public static ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>();

    public static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            MapTest.map.put(i, i);
            MapTest.concurrentHashMap.put(i, i);
        }
        new Thread(() -> {
            //换成hashmap会报错
            for (Map.Entry<Integer, Integer> entry : concurrentHashMap.entrySet()) {
                System.out.println(entry.getValue());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 100; i < 1000; i++) {
                MapTest.map.put(i, i);
                MapTest.concurrentHashMap.put(i, i);
            }
        }).start();
    }
}
