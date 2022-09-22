package com.yz.mybatis.mapper;

import com.yz.mybatis.pojo.Student4;

import java.util.List;

public interface _1_select_if {
    // 传入student，拼接所有 满足条件的属性，作为查询条件
    List<Student4> findStudent(Student4 student);

    List<Student4> findStudent_where(Student4 student);

    List<Student4> findStudent_trim(Student4 student);
}
