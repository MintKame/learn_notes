import demo.Book;
import demo.BookDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

// spring5整合junit5：
//      需引入junit5

//@ExtendWith(SpringExtension.class)
//@ContextConfiguration("classpath:demo/_1_config.xml") //加载配置文件 （整个test类，只需读取一次

// 可：1个注解，替代上面两个注解
@SpringJUnitConfig(locations = "classpath:demo/_1_config.xml")
public class _4_3_junit5 {

    @Autowired // 获取bean：自动注入
    BookDao bookDao;

    @Test // 来自junit5：org.junit.jupiter.api.Test
    public void test1(){
        List<Book> books = bookDao.findAll();
        System.out.println(books);
    }
}
