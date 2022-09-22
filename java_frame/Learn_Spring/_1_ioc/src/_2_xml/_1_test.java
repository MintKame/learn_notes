package _2_xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class _1_test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("_2_xml/_1__factoryBean.xml");

        final _1_Book book = context.getBean("book", _1_Book.class);
        System.out.println(book);
    }
}
