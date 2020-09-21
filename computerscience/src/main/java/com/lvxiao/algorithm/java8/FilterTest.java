package com.lvxiao.algorithm.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lvxiao <lvxiao@kuaishou.com>
 * Created on 2020-09-21
 */
class TestF {
    private int num;

    public TestF(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
public class FilterTest {
    public static void main(String[] args) {
        List<TestF> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(new TestF(i));
        }
        //通过断点，多个filter连接的时候只会循环一次
        List<TestF> tmp = list.stream()
                .filter(testF -> (testF.getNum() % 2) == 0)
                .filter(testF -> (testF.getNum() % 4) == 0)
                .collect(Collectors.toList());
        System.out.println(tmp);
    }
}
