package com.lvxiao.algorithm.array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2020/1/15 9:58 上午
 */
public class ArrayTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        /*
        如果此处使用i<5则会造成Exception in thread "main" java.lang.IndexOutOfBoundsException: Index: 3, Size: 2
        如果使用i<list.size()则会造成最后剩余两个。所以不能在for loop中使用remove
         */
        for (int i = 0; i < list.size(); i++) {
            list.remove(i);
        }
        System.out.println(list.size());
        list.clear();
        System.out.println(list.size());
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        Iterator<Integer> integerIterator = list.iterator();
        while (integerIterator.hasNext()) {
            //在只用remove()之前需要先使用next()移动游标和lastRet
            integerIterator.next();
            integerIterator.remove();
        }
        System.out.println(list.size());
    }
}
