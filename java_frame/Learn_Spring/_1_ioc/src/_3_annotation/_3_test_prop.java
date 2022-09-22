package _3_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class _3_test_prop {
    public static void main(String[] args) {
        //! 设置组件扫描
        ApplicationContext context = null;
        context = new AnnotationConfigApplicationContext(_1_SpringConfig.class); // 加载配置类

        //! 获取bean
        // 可以通过接口，获取实现类
        _3_UserService userService = context.getBean("userService", _3_UserService.class);
        userService.add();
    }
}
