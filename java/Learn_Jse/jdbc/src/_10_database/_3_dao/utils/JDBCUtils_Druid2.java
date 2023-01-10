package _10_database._3_dao.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

// JDBCUtils，基于Druid数据库连接池
public class JDBCUtils_Druid2{
    static DataSource dataSource = null;  // 所有共用同一个连接池

    // 初始化连接池
    static {
        try {
            final Properties properties = new Properties();
            properties.load(new FileInputStream("druid.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }

    public static Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }
    }

    public static void close(Connection connection, Statement statement, ResultSet resultSet){
        try {
            if (resultSet != null){
                resultSet.close();
            }
            if (statement != null){
                statement.close();
            }
            if (connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }
    }
}
