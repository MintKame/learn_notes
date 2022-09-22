package com.yz.sb._1_bean.pojo;

public class User4 {
    String name;
    int age;

    public User4(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User4() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
