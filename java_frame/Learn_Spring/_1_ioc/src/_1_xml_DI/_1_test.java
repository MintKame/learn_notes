package _1_xml_DI;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class _1_test {
    public static void main(String[] args) {
        // 加载 spring 配置文件
        //      ClassPath表示：xml 在 src下（另一种为 全路径
        ClassPathXmlApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("_1_xml_DI/_1__DI_3.xml");
        _1_Student student;
        // 利用id 获取对象
        //      para1：根据id，找创建的bean
        //      para2：模板，确定返回的对象的类型
        student = applicationContext.getBean("student1", _1_Student.class);
        System.out.println(student);
        student = applicationContext.getBean("student2", _1_Student.class);
        System.out.println(student);
        student = applicationContext.getBean("student3", _1_Student.class);
        System.out.println(student);
    }
}
