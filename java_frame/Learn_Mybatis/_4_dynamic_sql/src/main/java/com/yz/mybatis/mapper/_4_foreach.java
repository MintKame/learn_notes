package com.yz.mybatis.mapper;

import com.yz.mybatis.pojo.Student4;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface _4_foreach {

    // 批量查询：查age在集合内的，所有学生
    List<Student4> findStudentByAge(@Param("ages") List<Integer> ages);

    // 批量添加
    void addStudents1(@Param("students")List<Student4> students);

    void addStudents2(@Param("students")List<Student4> students);
}
