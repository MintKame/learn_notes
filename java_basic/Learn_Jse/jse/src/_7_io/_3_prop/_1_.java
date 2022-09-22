package _7_io._3_prop;

import java.io.*;
import java.util.Properties;

public class _1_ {
    public static class Dog implements Serializable {
        String name;
        int age;
        String color;

        public Dog(String name, int age, String color) {
            this.name = name;
            this.age = age;
            this.color = color;
        }
    }

    public static void main(String[] args) throws IOException {
        Properties prop = new Properties(); // 父类为Hashtable
        // 1. 加载文件，展示内容到指定流
        prop.load(new FileReader("dog.properties"));
        prop.list(System.out);
//        prop.load(new FileInputStream("dog.properties")); // 也可以

        // 2. 读
        String name = prop.getProperty("name");
        int age = Integer.parseInt(prop.getProperty("age"));
        String color = prop.getProperty("color");

        // 3. 使用读取的数据
        // 创建dog，并序列化到dog.dat文件
        Dog dog = new Dog(name, age, color);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("dog.dat"));
        oos.writeObject(dog);
        oos.close();

        // 4.修改prop，并存到配置文件（中文被存储为unicode码）
        prop.setProperty("color", "白色white"); // 不存在则新建k-v
        prop.store(new FileWriter("dog2.properties"), "注释内容");
        prop.store(new FileOutputStream("dog3.properties"), "注释内容");
        // 底层：
        // (writer instanceof BufferedWriter)? writer : BufferedWriter(writer)
        // bufferWriter(OutputStreamWriter(out))

        // 可用map的方法 ======================================
        // 作为hashtable的子类，key，value都不能为null
        prop.put("k1", "v");
        prop.put("k2", "v");
        prop.remove("k1");
    }
}
