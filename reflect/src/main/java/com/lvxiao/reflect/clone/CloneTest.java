package com.lvxiao.reflect.clone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 浅拷贝---能复制变量，如果对象内还有对象，则只能复制对象的地址
 *(因为积分数据类型的包装类都是final的，所以拷贝也是拷贝的变量)
 * 深拷贝---能复制变量，也能复制当前对象的 内部对象
 * @author lvxiao
 * @date 2019/7/16
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
class Student implements Cloneable {
    private String name;
    private int age;
    private Integer test;
    @Override
    protected Student clone() {
        try {
            return (Student) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class School implements Cloneable{
    private Student student;
    private int history;
    @Override
    protected School clone() {
        try {
            return (School) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}

public class CloneTest {
    public static void main(String[] args) {
        Student student = new Student("lvxiao", 28, 88);
        Student student1 = student.clone();
        School school = new School(student, 100);
        System.out.println(school);
        System.out.println(student1);
        student.setName("duanxin");
        student.setAge(18);
        student.setTest(18);
        //值都不改变
        System.out.println(student1);
        //内部兑现修改。。其值也跟着修改
        System.out.println(school);

    }
}
