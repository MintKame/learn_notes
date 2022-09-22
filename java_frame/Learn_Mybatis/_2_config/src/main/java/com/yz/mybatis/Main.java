package com.yz.mybatis;

import com.yz.mybatis.mapper.StudentMapper;
import com.yz.mybatis.mapper._1_SettingMapper;
import com.yz.mybatis.mapper._2_AliaseMapper;
import com.yz.mybatis.pojo.Student2;
import com.yz.mybatis.pojo._1_Test;
import com.yz.mybatis.pojo._2_Test;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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
    void test1(){
        SqlSession session = factory.openSession();
        _1_SettingMapper mapper = session.getMapper(_1_SettingMapper.class);
        final List<_1_Test> list = mapper.findAll();
        System.out.println(list);
        session.close();
    }

    @Test
    void test2(){
        SqlSession session = factory.openSession();
        _2_AliaseMapper mapper = session.getMapper(_2_AliaseMapper.class);
        final List<_2_Test> list = mapper.findAll();
        System.out.println(list);
        session.close();
    }

    @Test
    void testStudent(){
        SqlSession session = factory.openSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);

        Student2 student = mapper.findStudentById(1);
        System.out.println(student);

        List<Student2> list = mapper.findAll();
        System.out.println(list);

        session.close();
    }
}

