package _1_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class _2_test {
    public static void main(String[] args) {
        // 设置：2种方式，见_1_（xml/annotation）
//      ApplicationContext  context = new AnnotationConfigApplicationContext(_1_SpringConfig.class);
        ApplicationContext context = new ClassPathXmlApplicationContext("_1_annotation/_1_config.xml");

        UserDao userDao = context.getBean("userDao", UserDao.class);
        userDao.add();
        System.out.println("================================================");
        userDao.remove();
        System.out.println("================================================");
        System.out.println(userDao.getClass()); // class _1_annotation.UserDao$$EnhancerBySpringCGLIB$$e36452bb
    }
}
