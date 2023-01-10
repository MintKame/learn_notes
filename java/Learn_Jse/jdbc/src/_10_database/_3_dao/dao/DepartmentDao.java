package _10_database._3_dao.dao;

import _10_database._3_dao.pojo.Department2;

public class DepartmentDao extends BasicDao<Department2>{
    public String getNameById(String id){
        String sql = "select name from department where deptId = ?";
        return queryScaler(sql, id);
    }

    public Department2 getDepartmentById(String id){
        String sql = "select * from department where deptId = ?";
        return querySingle(sql, Department2.class, id);
    }
}
