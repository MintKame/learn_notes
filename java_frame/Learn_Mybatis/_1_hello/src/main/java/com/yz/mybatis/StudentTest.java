package com.yz.mybatis;

import com.yz.mybatis.mapper.StudentMapper;
import com.yz.mybatis.pojo.Student1;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
/* 步骤:
    mysql：创建测试表
    java：创建javaBean （Student1.java）
    配置： pom.xml
          log4j配置文件
          mybatis配置文件：环境信息 + 注册mapper文件
    mapper文件：定义sql语句，及其封装规则（存到哪个pojo）
        将mapper文件 注册在 mybatis配置文件
    测试（新旧两种方式，见下）   */
public class StudentTest {

    /* 旧方式（不常用）
        mapper文件中，mapper的namespace 和 sql的id 随意
        selectOne参数：sql唯一标识 = ${namespace}.${id}
                       sql语句的参数
        问题：sql标识 过长；
             传入sql的参数类型为Object，无类型检查  */
    @Test
    void test1() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        //  SqlSession非线程安全(同connection)。每次使用都应该获取新对象。
        SqlSession session = factory.openSession();

        Student1 student = session.selectOne("com.yz.mybatis.mapper.StudentMapper.findStudentById",1);
        System.out.println(student);

        session.close(); // SqlSession代表和数据库的一次会话；用完必关
    }
    /* 新方式（推荐）
        定义接口（dao/mapper）
        接口 动态绑定 配置文件：
            mapper文件中，设置：
                mapper的namespace = 接口全类名
                sql的id = 方法名
            mapper接口没有实现类，但mybatis会为它生成一个代理对象（将接口和xml进行绑定）
        优点：解决旧方式的2个问题
             分离dao的规范和实现，便于扩展（如：改其他的持久层框架，仍使用该接口
        类比：Dao接口    ==>  DaoImpl 实现类
             Mapper接口	==>  xxMapper.xml       */
    @Test
    void test2() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = factory.openSession();

        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        System.out.println(studentMapper.getClass()); // class com.sun.proxy.$Proxy9

        Student1 student = studentMapper.findStudentById(1);
        System.out.println(student);

        session.close();
    }
}
