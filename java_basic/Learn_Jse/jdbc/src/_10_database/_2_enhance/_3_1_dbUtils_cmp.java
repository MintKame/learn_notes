package _10_database._2_enhance;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class _3_1_dbUtils_cmp {
    public static void main(String[] args) throws SQLException {
//        test0();
//        test1();
        test2();
    }


    // 不使用dbUtils
    static void test0() throws SQLException {
        final String sql = "select * from department where collegeId = ?";
        final Connection connection = JDBCUtils_Druid1.getConnection();
        final PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "SC");
        // 使用结果
        final ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            System.out.print(resultSet.getString("deptId") + ' ');
            System.out.print(resultSet.getString("name") + ' ');
            System.out.print(resultSet.getString("chairId") + ' ');
            System.out.print(resultSet.getString("collegeId") + ' ');
            System.out.println();
        }
        // 延迟关闭连接：若先关连接，则不能使用结果集
        JDBCUtils_Druid1.close(connection, statement, resultSet);
    }

    // 不使用dbUtils, 自己实现dbUtils的功能: 存到pojo的List
    //! 数字标出相同功能的不同代码
    static void test1() throws SQLException {
        final String sql = "select * from department where collegeId = ?"; // 1
        final Connection connection = JDBCUtils_Druid1.getConnection();     // 2
        final PreparedStatement statement = connection.prepareStatement(sql); // 3
        statement.setString(1, "SC"); // 4
        final ResultSet resultSet = statement.executeQuery();    // 5
        // 6 存到pojo
        final List<Department1> departments = new ArrayList<>();
        while (resultSet.next()){
            String deptId = resultSet.getString("deptId");
            String name = resultSet.getString("name");
            String chairId = resultSet.getString("chairId");
            String collegeId = resultSet.getString("collegeId");
            departments.add(new Department1(deptId, name, chairId, collegeId));
        }
        // 关连接
        JDBCUtils_Druid1.close(connection, statement, resultSet); // 789(三个)
        // 使用结果
        for (Department1 department : departments) { // 10
            System.out.println(department);
        }
    }

    // 使用dbUtils: 需添加jar包
    static void test2() throws SQLException {
        final String sql = "select * from department where collegeId = ?";  // 1
        final Connection connection = JDBCUtils_Druid1.getConnection();      // 2
        final QueryRunner runner = new QueryRunner(); // 线程安全，可以实现crud批处理
        final List<Department1> departments =  // 3456 89
                runner.query(connection, sql, new BeanListHandler<Department1>(Department1.class), "SC");
        //! Handler：用于将 resultSet 转化为pojo，多种子类 对应 不同的结果类型
        // 模板方法：根据方法实参类型 决定 模板的类型（返回的list的模板类型 正由此而来）
        // 传入Class对象：需反射获取pojo信息，从而结果转化为pojo

        // 先关连接，再使用结果
        JDBCUtils_Druid1.close(connection, null, null); // 7 （结果集和语句已关闭）
        for (Department1 department : departments) { // 10
            System.out.println(department);
        }
    }
    /* query 源码，实现多步
        PreparedStatement stmt = null;
        ResultSet rs = null;
        T result = null;
        try {
            stmt = this.prepareStatement(conn, sql);          // 3
            this.fillStatement(stmt, params);                 // 4 填入所有参数 params
            rs = this.wrap(stmt.executeQuery());              // 5 执行
            result = rsh.handle(rs);                          // 6 封装到pojo集合
        } catch (SQLException e) {
            this.rethrow(e, sql, params);
        } finally {
            try {
                close(rs);                                    // 9
            } finally {
                close(stmt);                                  // 8
                if (closeConn) {
                    close(conn);                              //（默认为不关）
                }
            }
        }
        return result;
     */
}
