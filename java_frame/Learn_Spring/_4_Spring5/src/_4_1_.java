import demo.Book;
import demo.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/* 对比三种方式 spring 整合 junit：更方便 */

// 普通方式：需引入junit（4，5都可）
public class _4_1_ {
    @Test
    void test1(){
        // 每个@Test，都要:
        //      读取一次 ApplicationContext
        //      获取bean
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("demo/_1_config.xml");
        BookDao bookDao = context.getBean("bookDao", BookDao.class);

        List<Book> books = bookDao.findAll();
        System.out.println(books);
    }
}
