package _9_reflect;

public class Cat {
    public String name = "默认";
    public int age = 0;
    public static String staticField = "static";

    public Cat() {}

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void eat(String food){System.out.println(name + " 吃 " + food);}

    public void hi(){System.out.println(name + "：喵~");}

    public static void staticFun(){
        System.out.println("static func!");
    }
}
