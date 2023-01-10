package _10_database._3_dao;

import _10_database._3_dao.dao.BasicDao;
import _10_database._3_dao.dao.DepartmentDao;
import _10_database._3_dao.pojo.Department2;

public class Test {
    public static void main(String[] args) {
        final DepartmentDao departmentDao = new DepartmentDao();
        final Department2 department = departmentDao.getDepartmentById("ACCT");
        System.out.println(department);

        final String name = departmentDao.getNameById("ACCT");
        System.out.println(name);
    }
}
