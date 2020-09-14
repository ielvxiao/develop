package com.lvxiao.designpattern.builder;

import lombok.Builder;
import lombok.Data;

/**
 * @author lvxiao <lvxiao@kuaishou.com>
 * Created on 2020-09-14
 */
@Data
@Builder
class Student {
    private String name;
    private int age;
    private int grade;
}
public class TestBuilder {
    public static void main(String[] args) {
        Student student = Student.builder()
                .name("lvxiao")
                .age(18)
                .grade(100)
                .build();
        System.out.println(student.toString());
    }
}
