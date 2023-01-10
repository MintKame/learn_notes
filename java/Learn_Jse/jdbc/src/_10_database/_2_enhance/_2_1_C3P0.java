package _10_database._2_enhance;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class _2_1_C3P0 {
    public static void main(String[] args) throws Exception {
        // 引入jar包(2个)，设置为lib文件（source jar包 只是为了看源码）
//        test1();
        test2();
    }

    static void test1() throws Exception {
        // 创建连接池
        final ComboPooledDataSource dataSource = new ComboPooledDataSource();
        // 程序中设置参数: 数据库
        dataSource.setJdbcUrl(
                "jdbc:mysql://localhost:3306/learndb?serverTimezone=UTC&rewriteBatchedStatements=true");
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setUser("root");
        dataSource.setPassword("0");
        // 程序中设置参数: 连接池
        dataSource.setInitialPoolSize(10);
        dataSource.setMaxPoolSize(50);
        // 获取连接: 运行类型为 NewProxyConnection，由C3P0实现
        final Connection connection = dataSource.getConnection();
        //
        final PreparedStatement statement = connection.prepareStatement("select * from student");
        final ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            System.out.print(resultSet.getString(1));
            System.out.println(resultSet.getString(2));
        }
        resultSet.close();
        statement.close();
        connection.close(); // C3P0实现的Connection，close时，并非真close，而是放回连接池
    }

    static void test2() throws Exception {
        // 创建连接池（配置文件）
        // src目录下，配置文件，& 要用 &amp; 转义
        final ComboPooledDataSource dataSource = new ComboPooledDataSource("hello");

        // 获取连接: 运行类型为 NewProxyConnection，由C3P0实现
        final Connection connection = dataSource.getConnection();

        // 为区分test1，查询了另一个数据库的student
        final PreparedStatement statement = connection.prepareStatement("select * from student");
        final ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            System.out.print(resultSet.getString(1));
            System.out.println(resultSet.getString(2));
        }
        resultSet.close();
        statement.close();
        connection.close();
    }
}
