package _10_database._1_basic;

import com.mysql.cj.jdbc.Driver;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

// 前置工作：项目下创建文件夹 libs， 把驱动jar包copy至目录下，点击add to project
//  或者：File - project struct - addr.module - dependencies - +JARs/dir

public class _1_connect {
    // 建议：db的Driver类，url，user，password都写在properties文件中
    // 两大方式获得数据库连接：
    // 创建Driver - Driver获取Connection：1 2
    // 创建Driver - 注册到DriverManager  - DriverManager获取Connection 3 4 5
    //
    // 直接创建Driver
    @Test
    void test1() throws SQLException {
        // 直接创建Driver, 静态
        final com.mysql.cj.jdbc.Driver driver = new Driver();

        // 获取连接
        String url = "jdbc:mysql://localhost:3306/javabook?serverTimezone=UTC";
        final Properties properties = new Properties();
        properties.setProperty("user", "root"); // key固定
        properties.setProperty("password", "0");
        final Connection connect = driver.connect(url, properties);

        System.out.println(connect);
        connect.close();
    }

    // 反射创建 Driver
    @Test
    void test2() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        // 加载Driver类
        //  other db
        //  access : "sun.jdbc.odbc.JdbcOdbcDriver"
        //  oracle : "oracle.jdbc.driver.OracleDriver"
        final Class<?> cls = Class.forName("com.mysql.cj.jdbc.Driver");
        // 反射创建 Driver, 声明类型为接口
        final java.sql.Driver driver = (java.sql.Driver) cls.newInstance();

        // 获取连接
        String url = "jdbc:mysql://localhost:3306/javabook?serverTimezone=UTC";
        final Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "0");
        final Connection connect = driver.connect(url, properties);

        System.out.println(connect);
        connect.close();

    }

    // DriverManager 获取连接（统一管理Driver
    @Test
    void test3() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        // 加载Driver类
        final Class<?> cls = Class.forName("com.mysql.cj.jdbc.Driver");
        // 反射创建 Driver, 声明类型为接口
        final java.sql.Driver driver = (java.sql.Driver) cls.newInstance();

        // Driver 注册到 DriverManager
        DriverManager.registerDriver(driver);

        // 获取连接
        String url = "jdbc:mysql://localhost:3306/javabook?serverTimezone=UTC";
        final Connection connect = DriverManager.getConnection(url, "root", "0");// 用户名密码直接作为参数

        connect.close();
    }

    // 简化：不注册Driver，直接DriverManager 获取连接
    @Test
    void test4() throws ClassNotFoundException, SQLException {
        // 加载Driver类
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 5.1.6之后 不用forName，but建议写（更明确）
        // 因为：使用jdbc4，会自动注册驱动（jar包META-INF\services\java.sql.Driver）

        /*  Driver类的加载，的初始化阶段，执行static代码块：创建Driver，并注册到Manager
        static {
            try {
                DriverManager.registerDriver(new Driver());
            } catch (SQLException E) {
                throw new RuntimeException("Can't register driver!");
            }
        }
         */
        // 获取连接
        String url = "jdbc:mysql://localhost:3306/javabook?serverTimezone=UTC";
        final Connection connect = DriverManager.getConnection(url, "root", "0");

        System.out.println(connect);
        connect.close();
    }
}
