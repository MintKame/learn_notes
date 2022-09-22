import demo.Book;
import demo.BookDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

// spring5整合junit4：
//      需引入junit4
//      需jar包 spring-test

@RunWith(SpringJUnit4ClassRunner.class) // 单元测试框架：描述测试框架版本
@ContextConfiguration("classpath:demo/_1_config.xml") //加载配置文件 （整个test类，只需读取一次
public class _4_2_junit4 {

    @Autowired // 获取bean：自动注入
    BookDao bookDao;

    @Test // 来自junit4：org.junit.Test
    public void test1(){
        List<Book> books = bookDao.findAll();
        System.out.println(books);
    }
}
