package _10_database._1_basic;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

// 每次操作数据库：连接-操作-关闭
// 可以封装连接和关闭（只读取一次配置文件）
 class JDBCUtils{
    private static String user;
    private static String password;
    private static String driver;
    private static String url;

    static {
        try {
            final Properties properties = new Properties();
            properties.load(new FileInputStream("db.properties"));
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
        } catch (IOException e) {
            throw  new RuntimeException(e);
            /* 实际开发中：
                编译异常 -> 运行异常
                调用者可以选择：捕获该异常。默认处理该异常
             */
        }
    }

    public static Connection getConnection(){ // 每次调用，返回一个新的 Connection
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
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

public class _2_3_utils {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet set = null;
        try {
            connection = JDBCUtils.getConnection(); // try 中获取，因为可能抛出异常
            statement = connection.createStatement();
            set = statement.executeQuery("select * from subject");
            while (set.next()){
                System.out.print(set.getString(1) + " ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(connection, statement, set);
        }
    }
}
