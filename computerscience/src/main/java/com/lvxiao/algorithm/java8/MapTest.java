package com.lvxiao.algorithm.java8;

import java.util.*;

/**
 * @author lvxiao
 * @date 2020/6/11
 */
public class MapTest {

    /**对比
     * @see Map#putIfAbsent(Object, Object)
     * 最大的区别是compute方法传入的不是具体的value，而是一个function。
     * 所以，当传入的value需要复杂的计算时，使用compute**方法是比较合适的。
     * @param map
     * @param key
     * @param value
     */
    private static void computeIf(Map<Integer, Integer> map, int key, int value) {
        map.put(key, value);
        //不管存在不存在某值，最后都保存
        map.compute(key, (x,y) -> 1 + value);
        //如果不存在某值，才执行
        map.computeIfAbsent(key, x -> 2*value);
        //如果存在才执行
        map.computeIfPresent(key, (x, y) -> y + 1);
    }

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        computeIf(map,1,2);
        map.forEach((k,v)->{
            System.out.println(k);
            System.out.println(v);
        });
    }
}
