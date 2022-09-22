package _3_transaction_xml;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class _2_test {

    @Test
    void testXmlConfig(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("_3_transaction_xml/_1_config.xml");
        AccountService2 accountService = context.getBean("accountService2", AccountService2.class);
        accountService.transfer("aaa", "bbb", 100);
    }
}
