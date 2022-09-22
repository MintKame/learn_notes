package _2_xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class _3_bean_life_cycle {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("_2_xml/_3__bean_life_cycle.xml");

        // 4
        final _3_Student student = context.getBean("student", _3_Student.class);
        System.out.println("使用bean: " + student);

        context.close(); // 否则不执行destroy-method
    }
}
