package _9_reflect;

public class TestLoad {
    public static void main(String[] args) throws ClassNotFoundException {
        // 动态静态加载分别在何时？
      System.out.println("start main");

//        System.out.println("访问AAA的静态变量 " + AAA.snum);

        Cat cat = new Cat();
        /*
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return loadClass(name, false);
            }
         */

        System.out.println(cat.name);

        Class.forName("_9_reflect.Dog");

    }
}