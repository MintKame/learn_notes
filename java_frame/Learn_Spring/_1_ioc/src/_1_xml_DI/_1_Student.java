package _1_xml_DI;

public class _1_Student {
    String name;

    int age;

    // setter注入attr，必须有无参函数
    public _1_Student() {}

    public _1_Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "_1_Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
