package com.yz.mybatis.mapper;

import com.yz.mybatis.pojo.Student3;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

public interface _4_result_set {
    // 1条结果 -> obj
    // mapper中 resultType=全类名
    Student3 findStudentById1(int id);

    // 多条结果 -> obj集合
    // mapper中 resultType=全类名
    List<Student3> findStudentByAge1(int age);

    // 1条结果 -> map<列名，列值>
    // mapper中 resultType=map
    Map<String, Object> findStudentById2(int id);

    // 多条结果 -> map<某列的值，pojo对象>
    @MapKey("id")   // 指出：map的key 是哪列的值
    // mapper中 resultType=全类名/map
    Map<String, Student3> findStudentByAge2(int age);
}
