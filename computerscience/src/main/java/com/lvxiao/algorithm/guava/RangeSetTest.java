package com.lvxiao.algorithm.guava;

import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet;

/**
 * @author lvxiao <lvxiao@kuaishou.com>
 * Created on 2020-11-15
 */
public class RangeSetTest {
    public static void main(String[] args) {
        RangeSet<Integer> set = TreeRangeSet.create();
        set.add(Range.closed(1, 100));
        System.out.println(set.contains(10)); //true
        System.out.println(set.encloses(Range.openClosed(1, 100)));
    }
}
