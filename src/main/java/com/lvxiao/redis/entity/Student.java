package com.lvxiao.redis.entity;

import java.io.Serializable;

/**
 * @author lvxiao
 * @date 2019/4/27
 */
public class Student implements Serializable,Cloneable {

    private static final long serialVersionUID = 876323262645176354L;

    private int age;
    private String name;
    private String job;

    public Student(int age, String name, String job) {
        this.age = age;
        this.name = name;
        this.job = job;
    }
    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
