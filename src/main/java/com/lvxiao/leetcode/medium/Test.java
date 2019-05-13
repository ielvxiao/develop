package com.lvxiao.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author lvxiao
 * @date 2019/5/13
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(21);
        list.add(2);
        list.add(7);
        Collections.sort(list,(o1,o2)->{
            return o1 - o2;
        });
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
