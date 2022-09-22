package _2_transaction;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"_2_transaction"}) // 开启组件扫描
@EnableTransactionManagement //! 开启事务注解
public class _1_SpringConfig {
    // 创建数据库连接池
    @Bean
    DruidDataSource getDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/ssm?serverTimezone=UTC&rewriteBatchedStatements=true");
        dataSource.setUsername("root");
        dataSource.setPassword("0");
        return dataSource;
    }
    // 创建 JdbcTemplate
    // para: 到 ioc容器中(已创建的bean), 根据类型找到 dataSource, 作为参数传入
    @Bean
    JdbcTemplate getJdbcTemplate(DataSource dataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }
    //! 创建事务管理器
    @Bean
    TransactionManager getTransactionManager(DataSource dataSource){
        TransactionManager transactionManager
                = new DataSourceTransactionManager(dataSource);
        return transactionManager;
    }
}
