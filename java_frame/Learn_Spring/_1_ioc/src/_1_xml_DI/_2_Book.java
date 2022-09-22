package _1_xml_DI;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class _2_Book {
    String name1;
    String name2;
    String name3;

    public void setName1(String name) {
        this.name1 = name;
    }

    public void setName2(String name) {
        this.name2 = name;
    }

    public void setName3(String name) {
        this.name3 = name;
    }

    @Override
    public String toString() {
        return "_2_Book{" +
                "name1='" + name1 + '\'' +
                ", name2='" + name2 + '\'' +
                ", name3='" + name3 + '\'' +
                '}';
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("_1_xml_DI/_2__DI_special.xml");
        final _2_Book book = context.getBean("book", _2_Book.class);
        System.out.println(book);
    }
}
