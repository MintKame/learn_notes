package _1_crud;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class _2_test_crud {
    static BookDao bookDao;
    static {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("_1_crud/_1_config.xml");
        bookDao = context.getBean("bookDao", BookDao.class);
    }

    @Test
    void testAdd(){
        Book book = new Book("红楼梦", 100.0);
        bookDao.add(book);
    }

    @Test
    void testUpdate(){
        Book book = new Book("红楼梦", 100.0);
        book.setPrice(120.0);
        bookDao.update(book);
    }

    @Test
    void testDelete(){
        String bookName = "红楼梦";
        bookDao.delete(bookName);
    }

    @Test
    void testFindAll(){
        // 查：list
        final List<Book> books = bookDao.findAll();
        System.out.println(books);
    }

    @Test
    void testFindBook(){
        // 查：obj
        String bookName = "红楼梦";
        final Book book1 = bookDao.findBookByName(bookName);
        System.out.println(book1);
    }

    @Test
    void testFindPrice(){
        // 查：scalar
        String bookName = "红楼梦";
        final Double price = bookDao.findPriceByName(bookName);
        System.out.println(price);
    }
}
