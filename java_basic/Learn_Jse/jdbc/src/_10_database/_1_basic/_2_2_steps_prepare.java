package _10_database._1_basic;

import java.sql.*;

/* 对比：
    1. 不用 符号串拼接，减少语法错
    2. 效率高：预处理，多次执行，只编译1次
    3. 解决 sql注入 问题：用户输入非法sql语句，Statement不检查
        eg. select * from admin where name = '用户名' and pwd = '密码'
            若用户名为 1' or 密码为 or '1'= '1
            则执行：select * from admin where name = '1' or' and pwd = 'or '1'= '1' // 必成功
 */
public class _2_2_steps_prepare {
    static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/javabook?serverTimezone=UTC";
        final Connection connect = DriverManager.getConnection(url, "root", "0");

        // 填写?占位符
        PreparedStatement ps  = connect.prepareStatement(
                "insert into Student(firstName, mi, lastName) values (?, ?, ?);");
        ps.setString(1, "Y"); // index | 列名
        ps.setString(2, "");
        ps.setString(3, "Z");
        // 也可以：setObject()

        ps.executeUpdate(); // ! 不填写sql字符串

        ps.close();
        connect.close();
    }
}
