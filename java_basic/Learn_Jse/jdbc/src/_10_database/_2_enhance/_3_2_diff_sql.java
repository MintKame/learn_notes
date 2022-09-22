package _10_database._2_enhance;

import jdk.nashorn.internal.scripts.JD;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class _3_2_diff_sql {
    public static void main(String[] args) throws SQLException {
        testMulti();
        System.out.println("====================");
        testSingle();
        System.out.println("====================");
        testScaler();
        System.out.println("====================");
        testDML();
    }

    // 根据结果类型，选择不同Handler
    // 返回多行记录
    static void testMulti() throws SQLException {
        final String sql = "select * from  department where collegeId = ?";
        final Connection connection = JDBCUtils_Druid1.getConnection();
        final QueryRunner runner = new QueryRunner();
        final List<Department1> sc = runner.query(     // !
                connection, sql, new BeanListHandler<Department1>(Department1.class), "SC");
        JDBCUtils_Druid1.close(connection, null, null);
        for (Department1 department : sc) {
            System.out.println(department);
        }
    }

    // 返回单行记录 不存在则返回null
    static void testSingle() throws SQLException {
        final String sql = "select * from  department where deptId = ?"; // deptId 是unique字段，结果必然只有一条
        final Connection connection = JDBCUtils_Druid1.getConnection();
        final QueryRunner runner = new QueryRunner();
        final Department1 department = runner.query(         // !
                connection, sql, new BeanHandler<Department1>(Department1.class), "CS");
        JDBCUtils_Druid1.close(connection, null, null);
        System.out.println(department);
    }

    // 返回单行单列 不存在则返回null
    static void testScaler() throws SQLException {
        final String sql = "select chairId from  department where deptId = ?"; // 只查一列，且结果只有一条 ==> scaler
        final Connection connection = JDBCUtils_Druid1.getConnection();
        final QueryRunner runner = new QueryRunner();
        final String id = runner.query(     // !
                connection, sql, new ScalarHandler<String>(), "CS");
        JDBCUtils_Druid1.close(connection, null, null);
        System.out.println(id);
    }

    // dml：不用handler，因为dml无结果集
    static void testDML() throws SQLException {
        final String sql1 = "insert into department values(?, ?, ?, ?)";
//        final String sql3 = "update department set name=? where deptId = ?";
//        final String sql2 = "delete department where deptId = ?";

        final Connection connection = JDBCUtils_Druid1.getConnection();
        final QueryRunner runner = new QueryRunner();
        final int affectedRows = runner.update(     // !
                connection, sql1, "test", "test", "test", "test");
        System.out.println(affectedRows); // 受影响的行数
        JDBCUtils_Druid1.close(connection, null, null);
    }
}
