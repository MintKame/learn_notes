package _2_xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class _2_test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("_2_xml/_1_config.xml");
        BookDao bookDao = context.getBean("bookDao", BookDao.class);
        bookDao.read();
    }
}
