package com.yz.mybatis.mapper;

import com.yz.mybatis.pojo.School;
import com.yz.mybatis.pojo.Student3;

public interface _5_result_map1_obj {
    //! resultMap 的作用
    /*
    !     1. 列名 匹配 pojo属性名
        解决 javabean属性名 != db列名
        法1：sql中，查询的列起别名（=javabean属性名）
        法2：全局配置，开启驼峰命名法：
            将数据库的 aaa_bbb列，存到 javaBean的aaaBbb属性
        法3：resultMap（列 映射到 属性名） */

    //!      2. pojo属性 为对象
    // 级联赋值
    Student3 getStudentById1(Integer id);

    // association标签
    Student3 getStudentById2(Integer id);

    // association标签，分步查询
    Student3 getStudentById_step(Integer id);
}
