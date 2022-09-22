package _3_annotation;

import org.springframework.stereotype.Component;

// 1. 注解:创建对象
//  4个注解，功能相同，但常用于不同层
//      高到低: @Controller - @Service - @Repository
//      都可以: @Component

// test：见 _2_test_create

@Component // 默认名：_2_Student  （类名，首字母小写
//@Component(value = "student") // 设置名
public class _2_Student {
}
