package com.yz.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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

    /*
        正向：表 - 创建pojo - 创建mapper接口 - 创建 mapper.xml
        逆向：根据表，mybatis自动实现后面的步骤
            代码生成器 Mybatis Generator (MBG)

        步骤：
            1.不用写：pojo，mapper接口，mapper.xml
            2.generator 依赖
            3.配置文件 mbg.xml
            4.运行mybatisGenerator，生成代码（多种方式，其一见下）
            5.测试
            注：重新生成，先删上次生成的文件
     */
    // 4.用xml文件，运行mybatisGenerator
    @Test
    public void testMbg() throws Exception {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        File configFile = new File("mbg.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
                callback, warnings);
        myBatisGenerator.generate(null);
    }

    // 5.测试
    @Test
    void test() throws IOException {
        SqlSession session = factory.openSession();
//        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
//
//        Student5 student2 = studentMapper.findStudentById(1);
//        System.out.println(student1); // true

        session.close();
    }
}
