package com.yz.mybatis;

import com.yz.mybatis.mapper.*;
import com.yz.mybatis.pojo.School;
import com.yz.mybatis.pojo.Student3;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    void testAnno(){
        SqlSession session = factory.openSession();
        _1_anno mapper = session.getMapper(_1_anno.class);
        Student3 student = mapper.getStudentById(10);
        System.out.println(student);
        // Student(id=10, name=Candy, age=20, school=null)
        session.close();
    }

    @Test
    void testCRUD(){
        SqlSession session = factory.openSession();
        _1_crud mapper = session.getMapper(_1_crud.class);
        try {
            // 增
            Student3 student1 = new Student3("yz", 20);
            student1.setId(902);
            mapper.addStudent(student1);
            // 查
            student1 = mapper.getStudentById(902);
            System.out.println(student1); // Student3(id=902, name=yz, age=20, school=null)
            // 改
            student1.setName("yzz");
            mapper.updateStudent(student1);
            System.out.println(mapper.getStudentById(902)); // Student3(id=902, name=yzz, age=20, school=null)
            // 删
            mapper.deleteById(902);
            // 提交
            session.commit();
        }catch (Exception ex){
            session.rollback();
        }finally {
            session.close();
        }
    }

    // 预期：数据库的pk，为自动生成
    //      java中，print的student对象，id也被设置为自动生成值
    @Test
    void testPK(){
        SqlSession session = factory.openSession();
        _2_primary_key mapper = session.getMapper(_2_primary_key.class);
        try {
            final Student3 student = new Student3("yz", 20);
            mapper.addStudent(student);
            System.out.println(student);// Student3(id=905, name=yz, age=20, school=null)
            session.commit();
        } catch (Exception ex){
            session.rollback();
        } finally {
            session.close();
        }
    }

    @Test
    void testParam(){
        SqlSession session = factory.openSession();
        _3_param mapper = session.getMapper(_3_param.class);
        Student3 student = mapper.findByNameAge("yz", 20);
        System.out.println("=============" + student);
        //! 参数为obj
        student = mapper.findByObj(new Student3("yz", 20));
        System.out.println("=============" + student);

        student = mapper.findByNameObj("yz", new Student3(null, 20));
        System.out.println("=============" + student);
        //! 参数为map
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "yz");
        map.put("age", 20);
        student = mapper.findByMap(map);
        System.out.println("=============" + student);

        student = mapper.findByNameMap("yz", map);
        System.out.println("=============" + student );
        //! 参数为collection
        ArrayList<Integer> list = new ArrayList<>();
        list.add(20);
        student = mapper.findByList("yz", list);
        System.out.println("=============" + student );

        session.close();
    }

    @Test
    void testResultSet(){
        SqlSession session = factory.openSession();
        _4_result_set mapper = session.getMapper(_4_result_set.class);
        // 1条结果 -> obj
        Student3 student = mapper.findStudentById1(1);
        System.out.println("=============" + student);

        // 多条结果 -> obj集合
        List<Student3> students = mapper.findStudentByAge1(20);
        System.out.println("=============" + students);

        // 1条结果 -> map<列名，列值>
        Map<String, Object> map1 = mapper.findStudentById2(1);
        System.out.println("=============" + map1);

        // 多条结果 -> map<某列的值，pojo对象>
        Map<String, Student3> map2 = mapper.findStudentByAge2(20);
        System.out.println("=============" + map2);
        session.close();
    }

    @Test
    void testResultMapObj(){
        SqlSession session = factory.openSession();
        _5_result_map1_obj mapper = session.getMapper(_5_result_map1_obj.class);
        // pojo属性 为对象
        System.out.println("=============" + mapper.getStudentById1(906));
        System.out.println("=============" + mapper.getStudentById2(906));
        System.out.println("=============" + mapper.getStudentById_step(906));
        // 懒加载
        Student3 student = mapper.getStudentById_step(907);
        System.out.println("============="  +student.getName());
        session.close();
    }
    @Test
    void testResultMapCollection(){
        SqlSession session = factory.openSession();
        _5_result_map2_collection mapper = session.getMapper(_5_result_map2_collection.class);
        // pojo属性 为对象集合
        System.out.println("=============" + mapper.getSchooldById1(2));
        System.out.println("=============" + mapper.getSchooldById_step(2));
        // 懒加载
        School school = mapper.getSchooldById_step(3);
        System.out.println("============="  + school.getSname());
        // 鉴别器
        System.out.println("=============" + mapper.getAllSchool_Dis());
        session.close();
    }
}

