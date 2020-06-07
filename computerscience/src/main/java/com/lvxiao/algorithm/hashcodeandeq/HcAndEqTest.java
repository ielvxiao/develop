package com.lvxiao.algorithm.hashcodeandeq;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * "=="用来判断两个对象是否为同一个对象，同一个对象就是内存地址是相同的。
 * "equals"用来判断两个对象的值是不是相等的，具体逻辑需要自己去定义，默认和"=="相同
 * "hashcode"是表示该类的三列码，我们要确保"equals"对象的三列吗都相等，防止产生歧义.
 * equals相同，则hashcode一定相同，反之则不一定。
 * ==，绝对equals，反之则不一定。
 *
 * @author lvxiao
 * @date 2020/6/7
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HcAndEqTest {
    private int age;
    private String name;

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof HcAndEqTest) {
            HcAndEqTest ob = (HcAndEqTest) obj;
            if (this.age == ob.age) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        HcAndEqTest t1 = new HcAndEqTest(1, "dd");
        System.out.println(t1.hashCode());
        HcAndEqTest t2 = new HcAndEqTest(1, "xx");
        System.out.println(t1.hashCode());
        System.out.println(t1 == t2);
        System.out.println(t1.equals(t2));
    }
}
