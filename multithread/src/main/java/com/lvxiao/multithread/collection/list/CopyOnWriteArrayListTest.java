package com.lvxiao.multithread.collection.list;

import lombok.Data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/11/11 6:15 下午
 */
@Data
class TestDomain {
    private Integer id;
}
public class CopyOnWriteArrayListTest {
    public static void main(String[] args) {
        List<TestDomain> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            TestDomain domain = new TestDomain();
            domain.setId(i);
            list.add(domain);
        }
        List<TestDomain> conList = new CopyOnWriteArrayList<>(list);
        Iterator<TestDomain> integerIterator = conList.iterator();
        while (integerIterator.hasNext()) {
            TestDomain testDomain = integerIterator.next();
            testDomain.setId(0);
        }
        System.out.println("======");
        list.forEach(System.out::println);
        System.out.println("======");
        conList.forEach(System.out::println);
    }
}
