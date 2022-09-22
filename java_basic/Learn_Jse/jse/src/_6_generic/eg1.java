package _6_generic;

import java.util.ArrayList;
import java.util.Comparator;

public class eg1 {

    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("tom", new MyDate(2001,1,1)));
        employees.add(new Employee("jack",  new MyDate(2001,1,1)));
        employees.add(new Employee("tom",  new MyDate(1999,1,1)));

        // 排序：按名字-生日，从小到大排
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                int ret = o1.getName().compareTo(o2.getName());
                if (ret == 0) // 对birthday比较，最好封装到MyDate中实现
                    ret = o1.getBirthDay().compareTo(o2.getBirthDay());
                return ret;
            }
        });
        for (Employee employee : employees) {
            System.out.println(employee);
        }

    }
}

class Employee{
    private String name;
    private MyDate birthDay;

    public Employee(String name, MyDate birthDay) {
        this.name = name;
        this.birthDay = birthDay;
    }

    public String getName() {
        return name;
    }

    public MyDate getBirthDay() {
        return birthDay;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", birthDay=" + birthDay +
                '}';
    }
}

class MyDate implements Comparable<MyDate>{
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }

    @Override
    public int compareTo(MyDate o) {
        int ret = year - o.year;
        if (ret == 0)
            ret = month - o.month;
        if (ret == 0)
            ret = day - o.day;
        return ret;
    }
}