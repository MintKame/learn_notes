package com.yz.mybatis.pojo;

import lombok.Data;
// Lombok插件的注解 自动生成方法
// @Data = @Getter + @Setter + @ToString + @EqualsAndHashCode + @RequiredArgsConstructor
@Data
public class Student1 {
    private int id;
    private String name;
    private int age;

    // 有参构造方法，为后面的插入数据做准备
    public Student1(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // 因为自己编写了ctor，会覆盖Lombok插件自动创建的无参ctor
    // 因此，需要再编写一个无参的构造方法
    public Student1() {}
}
