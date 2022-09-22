package com.yz.mybatis.pojo;

import lombok.Data;
@Data
public class Student4 {
    private int id;
    private String name;
    private Integer age;

    public Student4(int id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Student4() {}
}
