package com.lvxiao.spring.java8;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author lvxiao
 * @date 2019/8/6
 */
@Data
@AllArgsConstructor
class TestDomain {
    private Integer id;
    private String name;
}
public class Java8Test {

    /**
     * 使用Optional找到id为1的TestDomain的name
     * @param testDomain
     * @return
     */
    public String testOptional(TestDomain testDomain) {
        return Optional.ofNullable(testDomain).filter(u->u.getId().equals(1)).map(TestDomain::getName).orElse("空的？》");
    }

    /**
     * 找到list中id为1的TestDomain的name
     * @param list
     * @return
     */
    public String testLamda(List<TestDomain> list) {
        //这部分感觉可以优化
        Optional<List<TestDomain>> optional = Optional.ofNullable(list);
        if (!optional.isPresent()) {
            return "test";
        }
        return optional.get().stream().filter(item -> item.getId().equals(1)).findFirst().get().getName();
    }
    public static void main(String[] args) {
        TestDomain testDomain = new TestDomain(1, "lvxiao");
        TestDomain testDomain1 = new TestDomain(2, "lvxiao1");
        List<TestDomain> list = Arrays.asList(testDomain, testDomain1);
//        System.out.println(new Java8Test().testOptional(new TestDomain(1,"lvxiao")));
        System.out.println(new Java8Test().testLamda(null));
    }
}
