package _2_xml;

public class _4_Emp {
    _4_Dept dept;

    String name;

    public void setDept(_4_Dept dept) {
        this.dept = dept;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp: " + name + " " + dept;
    }
}
