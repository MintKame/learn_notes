package com.yz.mybatis;

import com.yz.mybatis.mapper.*;
import com.yz.mybatis.pojo.Student4;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    SqlSessionFactory factory = null;

    {
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream("mybatis.xml");
            factory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void _1_select_if(){
        SqlSession session = factory.openSession();
        _1_select_if mapper = session.getMapper(_1_select_if.class);
        Student4 a = new Student4(0, "yz", 20);
        Student4 b = new Student4();
        b.setName("yz");
        Student4 c = new Student4();
        c.setAge(18);

        System.out.println("==========" + mapper.findStudent(a));
        System.out.println("==========" + mapper.findStudent(b));
        // 错误：System.out.println("==========" + mapper.findStudent(c));

        System.out.println("==========" + mapper.findStudent_where(a));
        System.out.println("==========" + mapper.findStudent_where(b));
        System.out.println("==========" + mapper.findStudent_where(c));

        System.out.println("==========" + mapper.findStudent_trim(a));
        System.out.println("==========" + mapper.findStudent_trim(b));
        System.out.println("==========" + mapper.findStudent_trim(c));
        session.close();
    }

    @Test
    void _2_select_choose(){
        SqlSession session = factory.openSession();
        _2_select_choose mapper = session.getMapper(_2_select_choose.class);
        System.out.println("=======" + mapper.findStudent_choose(new Student4(0, "yz", 20)));
        // 只按age查，结果有多个student
        session.close();
    }

    @Test
    void _3_update(){
        SqlSession session = factory.openSession(true);
        _3_update_if mapper = session.getMapper(_3_update_if.class);
        Student4 a = new Student4(906, "A", 20);
        Student4 b = new Student4(907, "B", null);
        Student4 c = new Student4(908, null, 20);

        mapper.updateStudent(a);
        mapper.updateStudent(b);
//        mapper.updateStudent(c); // 错误

        mapper.updateStudent_set(a);
        mapper.updateStudent_set(b);
        mapper.updateStudent_set(c);

        mapper.updateStudent_trim(a);
        mapper.updateStudent_trim(b);
        mapper.updateStudent_trim(c);

        session.close();
    }

    @Test
    void _4_foreach(){
        SqlSession session = factory.openSession(true);
        _4_foreach mapper = session.getMapper(_4_foreach.class);
        // 批量查询
        System.out.println(mapper.findStudentByAge(Arrays.asList(18,20)));
        // 批量添加
        mapper.addStudents1(Arrays.asList(new Student4(0, "haha", 17), new Student4(0, "lala", 17)));
        mapper.addStudents2(Arrays.asList(new Student4(0, "hoho", 17), new Student4(0, "lolo", 17)));
        session.close();
    }

    @Test
    void _5_params(){
        SqlSession session = factory.openSession();
        _5_params mapper = session.getMapper(_5_params.class);
        System.out.println(mapper.findStudentById(1));
        System.out.println(mapper.findStudentById(null));// 测试 _parameter，应查出所有学生
        session.close();
    }

    @Test
    void _6_bind_sql(){
        SqlSession session = factory.openSession();
        _6_bind_sql mapper = session.getMapper(_6_bind_sql.class);
        // sql标签
        System.out.println(mapper.findStudentById1(1));
        System.out.println(mapper.findStudentById1(1));
        // bind标签
        System.out.println(mapper.findStudentByName("y"));
        session.close();
    }
//    todo
    @Test
    void test(){
        SqlSession session = factory.openSession();
        _1_select_if mapper = session.getMapper(_1_select_if.class);
//        Student4 student = mapper.findStudentById(1);
//        System.out.println(student);
        session.close();
    }
}

