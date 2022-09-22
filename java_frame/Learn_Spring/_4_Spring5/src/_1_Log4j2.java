import demo.Book;
import demo.BookDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class _1_Log4j2 {

    /*  Spring5 框架整合 Log4j2，可整合其他日志
        Spring5 已移除 Log4jConfigListener, 官方建议使用 Log4j2

        使用流程：
            1. 引入jar包
            2. log4j2.xml 配置文件（src目录下，文件名固定）
     */
    public static void main(String[] args) {

        // 手动输出日志：
        Logger logger = LoggerFactory.getLogger(_1_Log4j2.class);
        logger.error("hello logger");

        // 以下代码执行时，会自动输出日志
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("demo/_1_config.xml");
        BookDao bookDao = context.getBean("bookDao", BookDao.class);
        final List<Book> books = bookDao.findAll();
        System.out.println(books);
    }
}
