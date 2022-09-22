package _3_annotation;

//import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class _2_test_create {
    public static void main(String[] args) {
        //! 设置组件扫描：2种方式（xml/annotation）
        ApplicationContext context = null;
        context = new ClassPathXmlApplicationContext("_3_annotation/_1_config.xml"); // 加载配置文件
//        context = new AnnotationConfigApplicationContext(_1_SpringConfig.class); // 加载配置类

        //! 获取bean
        _2_Student student = null;
        student = context.getBean("_2_Student", _2_Student.class); // 默认名
//        student = context.getBean("student", _2_Student.class); // 自定义名
    }
}
