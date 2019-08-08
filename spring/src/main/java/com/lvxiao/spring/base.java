package com.lvxiao.spring;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019-06-02 12:14
 */
public class base {
    private Integer id;

    public base(Integer id) {
        this.id = id;
    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof base)) return false;
//        base base = (base) o;
//        return Objects.equals(id, base.id);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }

    /**
     * 禁止在Map中使用可变对象当key。如下代码，会造成内存溢出。
     * 可以通过重写hashCode改变该问题。相同id的对象具有相同hashCode
     * @param args
     */
    public static void main(String[] args) {
        try {
            Map<base, Integer> map = new HashMap<>();
            while (true) {
                map.put(new base(1), 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
