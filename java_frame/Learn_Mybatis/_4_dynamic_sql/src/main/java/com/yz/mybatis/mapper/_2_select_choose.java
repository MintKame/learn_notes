package com.yz.mybatis.mapper;

import com.yz.mybatis.pojo.Student4;

import java.util.List;

public interface _2_select_choose {
    // 传入student，某个 属性，作为查询条件
    List<Student4> findStudent_choose(Student4 student);
}
