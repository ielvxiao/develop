package com.lvxiao.algorithm.java11;

import java.util.HashMap;
import java.util.Map;

/**
 * //增加ZGC一般情况下这个垃圾收集器能把停顿时间降低到10ms以下
 * 不是分代的基于page的收集器（可能未来会出）
 *
 *       对于 G1 GC，相比于 JDK 8，升级到 JDK 11 即可免费享受到：并行的 Full GC，快速的 CardTable 扫描，
 *       自适应的堆占用比例调整（IHOP），
 *       在并发标记阶段的类型卸载等等。这些都是针对 G1 的不断增强，其中串行 Full GC 等甚至是曾经被广泛诟病的
 *       短板，你会发现 GC 配置和调优在 JDK11 中越来越方便。
 * @author lvxiao
 * @date 2020/9/22
 */
public class Java11Test {
//    var a = new Java11Test(); 不能用在类变量中

    public static void main(String[] args) {
        //本地变量var，有类型推断的能力。但是不能定义在类中
        Map map = new HashMap<>();
        map.put(1, 2);

        //java11增加了一些很实用的方法

    }
}
