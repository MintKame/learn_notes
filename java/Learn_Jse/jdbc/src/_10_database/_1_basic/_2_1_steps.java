package _10_database._1_basic;

import java.sql.*;

public class _2_1_steps {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 获取连接
        String url = "jdbc:mysql://localhost:3306/javabook?serverTimezone=UTC";
        final Connection connect = DriverManager.getConnection(url, "root", "0");

        // 获取statement
        final Statement statement = connect.createStatement();

        /*
            对比             type                    return
           exeQ()            select                  result set
           exeU()            DDL                     0
                             DML(insert, delete)     cnt of row influenced
           exe()             any sql                 bool: whether ret resSet (not recommend)
         */
        // 执行 update
        statement.executeUpdate("insert into person values ('Yan', '', 'Zhao')");
        // 执行 query
        final ResultSet resultSet = statement.executeQuery("select * from person");

        while (resultSet.next()){ // loop: move to next row
            System.out.println(resultSet.getString("firstName")); // 参数：index|列名 (索引从1开始
            System.out.println(resultSet.getString("mi"));
            System.out.println(resultSet.getString("lastName"));
        }
        // resultSet.previous() 向前移动
        // 也可以：
        // resultSet.getObject();                       以Object类型接收

        // 关闭，释放资源 （close order: 1. Stat 2. Conn
        resultSet.close();
        statement.close();
        connect.close();
    }
}
