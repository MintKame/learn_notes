package _10_database._2_enhance;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

// JDBCUtils，基于Druid数据库连接池
class JDBCUtils_Druid1{
    static DataSource dataSource = null;  // 所有共用同一个连接池

    // 初始化连接池
    static {
        try {
            final Properties properties = new Properties();
            properties.load(new FileInputStream("druid.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw  new RuntimeException(e);
            /* 实际开发中：
                编译异常 -> 运行异常
                调用者可以选择：捕获该异常。默认处理该异常
             */
        }
    }

    public static Connection getConnection(){ // 每次调用，返回一个新的 Connection
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }
    }

    // 关闭资源，若不使用某资源，传入null
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

// 使用JDBCUtils
public class _2_3_utils {
    public static void main(String[] args) throws SQLException {
        final Connection connection = JDBCUtils_Druid1.getConnection();
        final PreparedStatement statement = connection.prepareStatement(
                "select * from person");
        final ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getString(1));
        }
    }
}
