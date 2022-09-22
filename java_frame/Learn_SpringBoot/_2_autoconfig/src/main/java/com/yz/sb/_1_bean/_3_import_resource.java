package com.yz.sb._1_bean;

import com.yz.sb._1_bean.pojo.User2;
import com.yz.sb._1_bean.pojo.User3;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/* 任意配置类上
    作用：导入spring配置文件
         创建 配置文件中的 bean   */
@ImportResource(locations = {("classpath:beans.xml")})
@Configuration
@SpringBootApplication
public class _3_import_resource {
    public static void main(String[] args) {
        // 返回IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(_2_import.class, args);
        // 获取组件
        User3 user = run.getBean("user3", User3.class); // user3 为xml中 bean的id
        System.out.println(user); // User{name='zhangsan', age=18}
    }
}
