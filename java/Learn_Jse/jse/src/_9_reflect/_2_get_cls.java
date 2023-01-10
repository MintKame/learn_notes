package _9_reflect;

import org.junit.jupiter.api.Test;

import java.io.Serializable;

public class _2_get_cls {
    public static void main(String[] args) throws ClassNotFoundException {
        //! 谁有Class对象？
        final Class<String> stringClass = String.class; // 类
        final Class<Serializable> serializableClass = Serializable.class; // interface
        final Class<Thread.State> stateClass = Thread.State.class;// enum
        final Class<Deprecated> deprecatedClass = Deprecated.class;// 注解
        final Class<Double> doubleClass = double.class;// primitive
        final Class<Void> voidClass = void.class;// void
        final Class<int[]> aClass3 = int[].class;// 数组
        System.out.println("=================================");

        //! 在程序的不同阶段，获取Class对象：四类，六种方式

        // 注意自动生成的类型：why不同？
        // 1. 编译器不知道 被加载的类的类型
        // 2. 编译器知道 是Cat类
        // 3. 编译器知道 对象的AType是Cat（一定是Cat或Cat的子类）

        //1. 加载类 并获取 对应的Class对象
        Class<?> aClass = Class.forName("_9_reflect.Cat"); // 需要全类名
        // 应用：框架使用多（xml中写类名）通过配置文件读取

        //2. 加载后，Class对象已经存在，直接获取
        Class<Cat> catClass = Cat.class; // 需要已知类是什么
        // 应用：多用于参数传递，eg：cls.getConstructor(String.class, int.class);
        //      最安全，性能最高
        final Class<Integer> integerClass1 = Integer.class;

        //3. 通过对象 得到 对象的运行类型 的Class对象
        Cat cat = new Cat();
        Class<? extends Cat> aClass1 = cat.getClass(); // 需要已知实例

        //4. 加载类 并获取 对应的Class对象
        final ClassLoader loader = Cat.class.getClassLoader();
        final Class<?> aClass2 = loader.loadClass("_9_reflect.Dog");
        System.out.println(aClass2); // "class _9_reflect.Dog"

        //5. primitive 获取
        final Class<Integer> integerClass = int.class;

        //6. wrapper 获取
        final Class<Integer> type = Integer.TYPE;
        //TYPE为 Integer 成员变量：public static final Class<Integer>  TYPE
        //                          = (Class<Integer>) Class.getPrimitiveClass("int");

        // 某个类的Class对象只有一个，因为类只加载一次
        System.out.println(aClass.hashCode()); // cat
        System.out.println(catClass.hashCode()); // cat
        System.out.println(aClass1.hashCode());// cat(三个相同)
        System.out.println(integerClass.hashCode()); // int.class
        System.out.println(type.hashCode()); // Integer.TYPE
        System.out.println(integerClass1.hashCode()); // Integer.class（前两个相同，第三个不同）
        // Integer.TYPE = int.class, 实际上装箱拆箱是通过这个Class对象实现
        System.out.println("=================================");

        String s = "a";
        Class cls1 = s.getClass(); // 获取：String类 在堆中创建的 Class对象
        Class cls2 = cls1.getClass(); // 获取：Class类 在堆中创建的 Class对象
        System.out.println(cls1);  // 显示cls1对应的类的 类型
        System.out.println(cls2); // 显示cls2对应的类的 类型
    }
}