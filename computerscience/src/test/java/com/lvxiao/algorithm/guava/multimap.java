package com.lvxiao.algorithm.guava;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

/**
 * @author lvxiao <lvxiao@kuaishou.com>
 * Created on 2021-01-12
 */
public class multimap {

    @Test
    public void test() {
        Multimap<Integer, Integer> map = ArrayListMultimap.create();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                map.put(i, j);
            }
        }
        Map<Integer, List<Integer>> originMap = (Map<Integer, List<Integer>>) (Map<Integer, ?>) map.asMap();
        System.out.println(originMap.get(1));
    }
}
