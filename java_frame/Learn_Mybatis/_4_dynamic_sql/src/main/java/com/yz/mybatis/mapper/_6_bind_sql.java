package com.yz.mybatis.mapper;

import com.yz.mybatis.pojo.Student4;

import java.util.List;

public interface _6_bind_sql {
    List<Student4> findStudentById1(Integer id);

    List<Student4> findStudentById2(Integer id);

    List<Student4> findStudentByName(String name);
}
