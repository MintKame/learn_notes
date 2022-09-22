package com.yz.mybatis.pojo;

import lombok.Data;
@Data
public class Student2 {
    private int id;
    private String name;
    private int age;

    public Student2(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Student2() {}
}
