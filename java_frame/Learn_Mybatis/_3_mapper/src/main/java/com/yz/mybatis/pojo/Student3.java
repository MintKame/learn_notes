package com.yz.mybatis.pojo;

import lombok.Data;
@Data
public class Student3 {
    private Integer id;
    private String name;
    private Integer age;
    private School school;

    public Student3(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student3() {}
}
