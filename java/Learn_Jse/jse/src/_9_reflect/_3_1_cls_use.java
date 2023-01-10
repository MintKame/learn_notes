package _9_reflect;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class _3_1_cls_use {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException,
            IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {

        //! 反射的使用流程，从而实现：调用外部文件的类的方法
        //1. 读取外部文件
        Properties properties = new Properties();
        properties.load(new FileReader("cat.properties"));
        String className = properties.getProperty("className");
        String fieldName = properties.getProperty("fieldName");
        String method1Name = properties.getProperty("method1Name");
        String method2Name = properties.getProperty("method2Name");
        String method2Para = properties.getProperty("method2Para");

        //2. 加载 某个类，并从堆中获取 它对应的 Class对象 （某个类指配置文件中的类）
        Class cls = Class.forName(className);

        //3. 由Class对象，创建 某个类 的public对象 (无参ctor)
        Object obj = cls.newInstance();

        //4. 由Class对象，获取并操作 一些对象（对应 某个类的结构）
        //4.1 Method对象：对应 某个类的 某个方法 ===============================
        Method method1 = cls.getMethod(method1Name);
        Method method2 = cls.getMethod(method2Name, String.class); // 需要传入：方法的参数类型 的Class对象
        method1.invoke(obj); //  "默认：喵~"
        method2.invoke(obj, method2Para); // "默认 吃 fish"
        //      传统：对象.方法(参数1,参数2...)
        //      反射：Method对象.invoke(对象,参数1,参数2...)

        //4.2 Constructor对象：对应 某个类的 某个构造器 ===============================
        Constructor ctor1 = cls.getConstructor(); // 无参ctor
        Constructor ctor2 = cls.getConstructor(String.class, int.class);
        // Object obj = cls.newInstance(); // 无参public ctor
        Object o1 = ctor1.newInstance();
        Object o2 = ctor2.newInstance("tom", 2);
        System.out.println(o1); // Cat{name='默认', age=0}
        System.out.println(o2); // Cat{name='tom', age=2}

        //4.3 Field对象：对应 某个类的 某个成员变量 ===============================
        Field field = cls.getField(fieldName);
        System.out.println(field.get(obj)); // "默认"
        //      传统：对象.成员变量
        //      反射：Field对象.get(对象)
        field.set(obj, "新名字");
        System.out.println(field.get(obj)); // 新名字
        //      传统：对象.成员变量 =
        //      反射：Field对象.set(对象, 值)
    }

}
