package com.lvxiao.algorithm.guava;

import java.util.HashSet;
import java.util.Set;

import com.google.common.collect.ImmutableSet;

/**
 * @author lvxiao <lvxiao@kuaishou.com>
 * Created on 2020-11-28
 */
public class ImmutableCollectionTest {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            set.add(i);
        }
        ImmutableSet<Integer> integers = ImmutableSet.copyOf(set);
        integers.add(1); //异常，因为是不可变集合
    }
}
