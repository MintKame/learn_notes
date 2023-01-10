package _10_database._2_enhance;

import java.util.Date;

public class Department1 { // POJO，JavaBean，Domain
    String deptId;
    String name;
    String chairId;
    String collegeId;
    // mysql类型 <==> java类型 (都用Wrapper，因为可能mysql中存为null)
    // int            Integer
    // double         Double
    // char varchar   String
    // date           util.Date / String

    public Department1() {} // 必要：反射使用

    public Department1(String deptId, String name, String chairId, String collegeId) {
        this.deptId = deptId;
        this.name = name;
        this.chairId = chairId;
        this.collegeId = collegeId;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChairId() {
        return chairId;
    }

    public void setChairId(String chairId) {
        this.chairId = chairId;
    }

    public String getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId;
    }

    @Override
    public String toString() {
        return "Department: " +
                "deptId='" + deptId + '\'' +
                ", name='" + name + '\'' +
                ", chairId='" + chairId + '\'' +
                ", collegeId='" + collegeId;
    }
}
