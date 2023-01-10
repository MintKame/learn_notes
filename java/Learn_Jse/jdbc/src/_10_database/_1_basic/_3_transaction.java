package _10_database._1_basic;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class _3_transaction {
    // 实现代码：转账 (A->B 100 元)
    //          成功: A-100, B+100
    public static void main(String[] args) {
//        test1(); // 无事务
        test2(); // 事务
    }

    // 无事务 出现异常: A-100, B不变
    static void test1(){
        Connection connection = null;
        PreparedStatement statement1 =null;
        PreparedStatement statement2 =null;
        try{
            connection =JDBCUtils.getConnection();
            statement1 = connection.prepareStatement(
                    "update learndb.account set balance=balance-100 where name='A'");
            statement2 = connection.prepareStatement(
                    "update learndb.account set balance=balance+100 where name='B'");

            statement1.executeUpdate();
            int tmp = 1/0; // 异常
            statement2.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(null, statement1, null);
            JDBCUtils.close(connection, statement2, null);
        }
    }

    // 开启事务 出现异常: A, B
    static void test2(){

        Connection connection = null;
        PreparedStatement statement1 =null;
        PreparedStatement statement2 =null;
        try{
            connection =JDBCUtils.getConnection();
            statement1 = connection.prepareStatement(
                    "update learndb.account set balance=balance-100 where name='A'");
            statement2 = connection.prepareStatement(
                    "update learndb.account set balance=balance+100 where name='B'");

            connection.setAutoCommit(false); // 1.开启事务
            statement1.executeUpdate();
            int tmp = 1/0; // 异常
            statement2.executeUpdate();
            connection.commit(); // 2.提交

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            try {
                connection.rollback(); // 2.回滚 当前事务 到保存点 (默认事务初始)
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }finally {
            JDBCUtils.close(null, statement1, null);
            JDBCUtils.close(connection, statement2, null);
        }
    }

}
