package com.lvxiao.algorithm.guava;

import java.time.LocalDate;
import java.time.ZoneId;

import org.apache.commons.lang3.tuple.Pair;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet;

/**
 * @author lvxiao <lvxiao@kuaishou.com>
 * Created on 2020-11-15
 */
public class RangeSetTest {
    public static void main(String[] args) {
        Pair<Integer, Integer> pair = JSON.parseObject("(1,2)", Pair.class);
        System.out.println(pair.getLeft());
        System.out.println(pair.getRight());
    }
}
