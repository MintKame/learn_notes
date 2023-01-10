package _10_database._2_enhance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class _1_batch {
    public static void main(String[] args) throws SQLException {

    // 测 插入5000条 时间
    // 注意：测试前先清空数据（控制变量）
        long start = System.currentTimeMillis();
//        test1(); // 传统 40
        test2(); // 批处理 4
        long end = System.currentTimeMillis();
        System.out.println("秒数: " + (end - start)/1000 );
    }

    static void test1() throws SQLException {
        Connection connection = JDBCUtils_Druid1.getConnection();
        PreparedStatement statement = connection.prepareStatement("insert into learndb.testBatch values(?)");
        for (int i = 0; i < 5000; i++) {
            statement.setInt(1, i);
            statement.executeUpdate(); // 执行
        }
        JDBCUtils_Druid1.close(connection, statement, null);
    }

    static void test2() throws SQLException {
        // 连接mysql时，开启批处理功能：rewriteBatchedStatements=true
        Connection connection = JDBCUtils_Druid1.getConnection();
        PreparedStatement statement = connection.prepareStatement("insert into learndb.testBatch values(?)");
        for (int i = 0; i < 5000; i++) {
            statement.setInt(1, i);
            statement.addBatch(); // 添加语句
            if ((i + 1) % 1000 == 0){
                statement.executeBatch(); // 执行
                statement.clearBatch(); // 清空：因语句过多，需要分批执行
            }
        }
        JDBCUtils_Druid1.close(connection, statement, null);
    }
}

