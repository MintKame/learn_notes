package com.yz.mybatis.mapper;

import com.yz.mybatis.pojo.Student2;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {

    Student2 findStudentById(int id);

    @Select("select * from student")
    List<Student2> findAll();
}
