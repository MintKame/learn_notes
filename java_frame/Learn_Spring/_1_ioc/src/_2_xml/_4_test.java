package _2_xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class _4_test {
    public static void main(String[] args) {
        final ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("_2_xml/_4__autowire.xml");
        final _4_Emp emp1 = context.getBean("emp1", _4_Emp.class);
        System.out.println(emp1);

        final _4_Emp emp2 = context.getBean("emp2", _4_Emp.class);
        System.out.println(emp2);

//        final _4_Emp emp3 = context.getBean("emp3", _4_Emp.class);
//        System.out.println(emp3);
    }
}
