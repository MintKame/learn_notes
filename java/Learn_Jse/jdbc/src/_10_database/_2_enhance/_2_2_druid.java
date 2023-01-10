package _10_database._2_enhance;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class _2_2_druid {
    public static void main(String[] args) throws Exception {
        // 引入jar包，设置为lib文件
        // 配置文件: 文件要放src目录
        final Properties properties = new Properties();
        properties.load(new FileInputStream("druid.properties"));
        // 创建 连接池（配置文件）
        final DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        // 获取 连接
        final Connection connection = dataSource.getConnection();
        System.out.println(connection.getClass());
        final PreparedStatement statement = connection.prepareStatement("select * from student");
        final ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            System.out.print(resultSet.getString(1));
            System.out.println(resultSet.getString(2));
        }
        resultSet.close();
        statement.close();
        connection.close(); // Druid实现的Connection，close时，并非真close，而是放回连接池
    }
}
