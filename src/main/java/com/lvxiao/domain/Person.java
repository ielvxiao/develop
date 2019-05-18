package com.lvxiao.domain;

import lombok.*;

/**
 * lombok使用方法，效果可以参考生成的class文件，比较好理解。
 * @author lvxiao
 * @date 2019/5/17
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "lvxiao")
public class Person {
    private String name;
    @NonNull private Integer id;
    private int age;

    public static void main(String[] args) {

        Person p = new Person();
        p.setId(null);
    }
}
