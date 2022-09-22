package com.yz.mybatis.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Student5 implements Serializable {
    private int id;
    private String name;
    private int age;

    public Student5(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Student5() {}
}