package com.lvxiao.aimoffer;

import java.util.*;

/**
 * @author lvxiao
 * @date 2020/6/26
 */
public class Offer41 {
    List<Integer> list = new ArrayList<>();
    /** initialize your data structure here. */
    public Offer41() {

    }

    public void addNum(int num) {
        int size = list.size();
        //二分查找，插入位置

    }

    public double findMedian() {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (size % 2 == 0) {
            return (list.get(size / 2 - 1) + list.get(size / 2)) / 2.0;
        } else {
            return list.get(size / 2);
        }
    }
}
