package com.yz.mybatis.mapper;


import com.yz.mybatis.pojo.Student3;
import org.apache.ibatis.annotations.Select;

public interface  _1_anno {
    // 注解 vs mapper文件：
    //    重要，  复杂的Dao接口：sql mapper文件
    //    不重要，简单的Dao接口：sql 注解（开发快，但改sql要改源码）
    @Select("select * from student where id = #{id}")
    public Student3 getStudentById(Integer id);

}
