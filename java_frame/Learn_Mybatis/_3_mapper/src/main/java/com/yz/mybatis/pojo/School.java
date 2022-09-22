package com.yz.mybatis.pojo;

import lombok.Data;

import java.util.List;

@Data
public class School {
    private int sid;
    private String sname;
    private List<Student3> students;

    public School(int sid, String name) {
        this.sid = sid;
        this.sname = name;
    }

    public School() {}
}
