package _2_xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

public class _5_test {
    public static void main(String[] args) throws SQLException {
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("_2_xml/_5__outer_file.xml");
//        final DataSource source1 = context.getBean("dataSource1", DataSource.class);
//        source1.getConnection();

        final DataSource source2 = context.getBean("dataSource2", DataSource.class);
        source2.getConnection();
    }
}
