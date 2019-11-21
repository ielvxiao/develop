package com.lvxiao.multithread.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/11/21 4:01 下午
 */
public class HashMapTest {
    public static void main(String[] args) {
        //初始化一个容量为10000的map,但是threshold是16384,只有数量超过16384*0.75的时候才会出发扩容
        Map<Object, Object> map = new HashMap<>(10000);
        for (int i = 0; i < 10000; i++) {
            map.put(i, i);
            System.out.println(i);
        }
    }
}
