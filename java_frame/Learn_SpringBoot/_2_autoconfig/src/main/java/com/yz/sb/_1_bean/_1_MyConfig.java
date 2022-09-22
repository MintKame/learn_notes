package com.yz.sb._1_bean;

import com.yz.sb._1_bean.pojo.Pet;
import com.yz.sb._1_bean.pojo.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/* annotation，用于 注册组件：
@Component、@Controller、@Service、@Repository
@Configuration  @Bean
@Import
@ImportResource      */

/* proxyBeanMethods：代理bean的方法(2种模式：
       Full(proxyBeanMethods = true)  每次调用@Bean方法，返回组件都是单实例
       Lite(proxyBeanMethods = false) 每次调用@Bean方法，返回组件都是新创建的
   选择：组件依赖（见下）必须Full模式（默认）
        Lite模式，每次获取时，不检查是否存在，加速容器启动       */
@Configuration(proxyBeanMethods = true)
@SpringBootApplication // 为了能在该文件进行测试
public class _1_MyConfig {

    /* @Bean 给容器中添加组件。
        方法名=组件id
        返回类型=组件类型
        返回值=组件在容器中的实例     */
    @Bean
    Pet pet(){
        return new Pet("aaa");
    }

    @Bean //user 组件依赖了pet组件
    User user(Pet pet){
        return new User("AAA", 0, pet);
    }

    public static void main(String[] args) {
        // 返回IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(_1_MyConfig.class, args);
        // 1.配置类本身也是组件
        _1_MyConfig bean = run.getBean(_1_MyConfig.class); // com.yz.sb._1_bean._1_MyConfig$$EnhancerBySpringCGLIB$$6b1c6612@238ad8c
        System.out.println(bean);
        // 2.默认：组件 为 单实例
        User user1 = run.getBean("user", User.class);
        User user2 = run.getBean("user", User.class);
        Pet pet1= run.getBean("pet", Pet.class);
        System.out.println(user1); // User{name='AAA', age=0, pet=Pet{name='aaa'}}
        System.out.println(user1 == user2); // true
        System.out.println(user1.getPet() == pet1); // true，组件依赖，使用单实例
    }
}
