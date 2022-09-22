package _1_crud;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class _3_test_batch {

    static BookDao bookDao;
    static {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("_1_crud/_1_config.xml");
        bookDao = context.getBean("bookDao", BookDao.class);
    }

    @Test
    void testAdd(){
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("三国演绎", 110.0));
        books.add(new Book("西游记", 120.0));
        books.add(new Book("水浒传", 130.0));
        bookDao.batchAdd(books);
    }

    @Test
    void testUpdate(){
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("三国演绎", 10.0));
        books.add(new Book("西游记", 20.0));
        books.add(new Book("水浒传", 30.0));
        bookDao.batchUpdate(books);
    }

    @Test
    void testDelete(){
        ArrayList<String> names = new ArrayList<>();
        names.add("三国演绎");
        names.add("西游记");
        names.add("水浒传");
        bookDao.batchDelete(names);
    }
}
