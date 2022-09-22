package com.yz.mvc;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentDao {
    private static Map<Integer, Student> students = null; // 存所有学生

    private static Integer initId = 1001;

    static{
        students = new HashMap<Integer, Student>();
        students.put(1001, new Student(initId++, "aaa"));
        students.put(1002, new Student(initId++, "bbb"));
        students.put(1003, new Student(initId++, "ccc"));
    }


    // 增：浏览器的数据赋值到pojo，没设置id，在此为id赋值
    // 改：覆盖map中的对象
    public void save(Student student){
        if(student.getId() == null){
            student.setId(initId++);
        }
        students.put(student.getId(), student);
    }

    public Collection<Student> getAll(){
        return students.values();
    }

    public Student get(Integer id){
        return students.get(id);
    }

    public void delete(Integer id){
        students.remove(id);
    }
}
