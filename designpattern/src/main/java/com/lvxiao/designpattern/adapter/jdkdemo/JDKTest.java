package com.lvxiao.designpattern.adapter.jdkdemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019-05-30 23:20
 */
public class JDKTest {
    public static void main(String[] args) {
        Integer[] nums = new Integer[10];
        /**
         * 将一个引用类型的数组转为一个List。从而可以使用List类的操作来操作数组对象，但是有一点要注意：就是不能使用add(),remove()操作，因为返回的list底层是基于数组的，数组结构是不能更改的。 list类就是这里的适配器，通过这个适配器，对数组的直接操作变为间接操作。
         * ---------------------
         * 作者：iCoding91
         * 来源：CSDN
         * 原文：https://blog.csdn.net/caoxiaohong1005/article/details/79961539
         * 版权声明：本文为博主原创文章，转载请附上博文链接！
         */
        //基本数据类型不可以,因为找不到对应的类型
        List<Integer> list = Arrays.asList(nums);
        System.out.println(list.size());
        System.out.println(list.get(3));
        list.set(3, 3);
        System.out.println(list.get(3));
        //不能执行增加和删除操作，因为它不是真正的list
        //list.remove(3);

        /**
         * 引申，比较好的做法是使用工具类
         */
        List<Integer> list1 = new ArrayList<>(nums.length);
        Collections.addAll(list1, nums);
        list1.forEach(System.out::println);
    }
}
