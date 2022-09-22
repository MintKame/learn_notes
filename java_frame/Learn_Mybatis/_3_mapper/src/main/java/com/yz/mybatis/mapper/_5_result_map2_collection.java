package com.yz.mybatis.mapper;

import com.yz.mybatis.pojo.School;
import com.yz.mybatis.pojo.Student3;

import java.util.List;

public interface _5_result_map2_collection {
    //! 3. pojo属性 为对象集合

    // collection标签
    School getSchooldById1(Integer sid);

    // collection标签，分步查询
    School getSchooldById_step(Integer sid);

    //! 4. 鉴别器
    List<School> getAllSchool_Dis();
}
