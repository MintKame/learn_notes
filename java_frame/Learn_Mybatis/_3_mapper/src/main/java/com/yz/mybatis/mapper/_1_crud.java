package com.yz.mybatis.mapper;

import com.yz.mybatis.pojo.Student3;

public interface _1_crud {

    public Student3 getStudentById(Integer id);

    /*  增删改：可定义返回值类型  Integer、Long、Boolean、void
               表示：影响行数、是否影响
        提交：
        sqlSessionFactory.openSession()     ===> 需手动提交
        sqlSessionFactory.openSession(true) ===> 自动提交     */
    public void addStudent(Student3 student);

    public void deleteById(Integer id);

    public void updateStudent(Student3 student);
}
