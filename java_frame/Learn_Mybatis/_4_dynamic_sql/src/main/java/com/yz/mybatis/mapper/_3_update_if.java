package com.yz.mybatis.mapper;

import com.yz.mybatis.pojo.Student4;

import java.util.List;

public interface _3_update_if {
    // 传入student，拼接所有 满足条件的属性，更新为新值
    void updateStudent(Student4 student);

    void updateStudent_set(Student4 student);

    void updateStudent_trim(Student4 student);
}
