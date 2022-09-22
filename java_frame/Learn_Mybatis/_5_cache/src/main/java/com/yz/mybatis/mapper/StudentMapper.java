package com.yz.mybatis.mapper;

import com.yz.mybatis.pojo.Student5;

public interface StudentMapper {
    Student5 findStudentById_(int id);

    Student5 findStudentById(int id);
}
