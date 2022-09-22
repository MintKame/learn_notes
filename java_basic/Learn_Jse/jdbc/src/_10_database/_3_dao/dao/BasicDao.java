package _10_database._3_dao.dao;

import _10_database._3_dao.pojo.Department2;
import _10_database._3_dao.utils.JDBCUtils_Druid2;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BasicDao<T> {
    // 模板类 而不是 模板方法：因整个Dao都为操作某个pojo，不用等到调用方法 再确定 模板类型
    // 特：Scaler查询的结果类型，Scaler查询时才能知道，因此 模板方法

    // 创建几个？
    // QueryRunner：每个Dao用一个
    // Connection：每次方法的执行都用一个，Dao内的不同执行，不共用Connection（增加并行度）
    private QueryRunner runner = new QueryRunner();

    // 查多行记录
    public List<T> queryMulti(String sql,Class clazz, String... params) {
        // 虽然继承的子类Dao 指定的模板类型 和 class对应的类型 相同
        // 但，因不可以使用 T.class
        // 需传入clazz，作为query的参数
        Connection connection = null;
        try {
            connection = JDBCUtils_Druid2.getConnection();

            final List<T> sc = runner.query(
                    connection, sql, new BeanListHandler<T>(clazz), params);
            return sc;
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        } finally {
            JDBCUtils_Druid2.close(connection, null, null);
        }
    }

    // 查单行记录 不存在则返回null
    public T querySingle(String sql, Class clazz, Object... params) {

        Connection connection = null;
        try {
            connection = JDBCUtils_Druid2.getConnection();

            T ret = runner.query(connection, sql, new BeanHandler<T>(clazz), params);
            return ret;
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        } finally {
            JDBCUtils_Druid2.close(connection, null, null);
        }
    }

    // 查单行单列 不存在则返回null
    public <U> U queryScaler(String sql, Object... params) {

        Connection connection = null;
        try {
            connection = JDBCUtils_Druid2.getConnection() ;

            U ret = runner.query(connection, sql, new ScalarHandler<U>(), params);
            return ret;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils_Druid2.close(connection, null, null);
        }
    }

    // dml
    public int dml(String sql, Object... params) {

        Connection connection = null;
        try {
            connection = JDBCUtils_Druid2.getConnection();
            int affectedRows = runner.update(connection, sql, params);
            return affectedRows; // 受影响的行数
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils_Druid2.close(connection, null, null);
        }
    }
}
