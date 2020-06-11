package com.lvxiao.algorithm.java8;

import java.util.*;

/**
 * @author lvxiao
 * @date 2020/6/11
 */
public class MapTest {

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
