package com.yz.sb._1_bean;

import com.yz.sb._1_bean.pojo.User2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/* Import
    只能用在 组件上
    作用：无参ctor 创建组件，注册到容器
         组件名 默认 全类名
    高级用法：https://www.bilibili.com/video/BV1gW411W7wy?p=8  */
@Import({User2.class})
@Configuration
@SpringBootApplication
public class _2_import {
    public static void main(String[] args) {
        // 返回IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(_2_import.class, args);
        // 获取组件
        User2 user = run.getBean(User2.class);
        System.out.println(user); // User{name='null', age=0}
    }
}
