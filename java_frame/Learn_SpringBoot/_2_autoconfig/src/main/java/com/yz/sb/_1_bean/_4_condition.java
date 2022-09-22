package com.yz.sb._1_bean;


import com.yz.sb._1_bean.pojo.Pet;
import com.yz.sb._1_bean.pojo.User2;
import com.yz.sb._1_bean.pojo.User4;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

/* 可注册bean的地方：组件类上，或者标注为@Bean的方法上
    条件装配：满足条件，才进行组件注入
 */
@SpringBootApplication
public class _4_condition {
    @Bean
    @ConditionalOnMissingBean(name = "user4") // 此处为 Conditional的 派生注解
    public User4 user4(){
        return new User4();
    }

    public static void main(String[] args) {
        // 返回IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(_2_import.class, args);
        // 获取组件
        User4 user = run.getBean("user4", User4.class);
        System.out.println(user); // User{name='null', age=0}
    }
}
