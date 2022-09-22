package _1_xml_DI;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class _3_Class {
    int cnum;
    _3_Teacher teacher;

    public void setCnum(int cnum) {
        this.cnum = cnum;
    }

    public void setTeacher(_3_Teacher teacher) {
        this.teacher = teacher;
    }

    public _3_Teacher getTeacher() {
        return teacher;
    }

    @Override
    public String toString() {
        return "_3_Class{" +
                "cnum=" + cnum +
                ", teacher=" + teacher +
                '}';
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("_1_xml_DI/_3__DI_obj.xml");
        _3_Class class1 = context.getBean("class1", _3_Class.class);
        System.out.println(class1);

        _3_Class class2 = context.getBean("class2", _3_Class.class);
        System.out.println(class2);

        _3_Class class3 = context.getBean("class3", _3_Class.class);
        System.out.println(class3);
    }
}
