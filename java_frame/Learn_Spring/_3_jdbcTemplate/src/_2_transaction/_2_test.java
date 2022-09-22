package _2_transaction;

import _1_crud.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class _2_test {

    @Test
    void testXmlConfig(){
        // 注意：运行前，先注释 _1_SpringConfig。
        //       否则 _1_config.xml 扫描到 _1_SpringConfig 的 getDataSource() 重复的数据源
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("_2_transaction/_1_config.xml");
        AccountService accountService = context.getBean("accountService", AccountService.class);
        accountService.transfer("aaa", "bbb", 100);
    }

    @Test
    void testAnnoConfig(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(_1_SpringConfig.class);
        AccountService accountService = context.getBean("accountService", AccountService.class);
        accountService.transfer("aaa", "bbb", 100);
    }

}
