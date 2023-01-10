package _9_reflect;

import java.lang.annotation.Annotation;

class A0{}
interface B0{}
interface C0{}
@Deprecated
class Cls0 extends A0 implements B0, C0{ }

public class _4_cls_msg {

    public static void main(String[] args) throws ClassNotFoundException {
        final Class cls = Cls0.class;
        // 通过Class对象，获取 某个类的 信息、完整结构（见2）
        // 类名，调用了 getName()
        System.out.println(cls); // class _9_reflect.Cls0
        System.out.println(cls.getName()); // _9_reflect.Cls0
        System.out.println(cls.getSimpleName()); // Cls0
        // 包:返回一个Package对象
        System.out.println(cls.getPackage()); // package _9_reflect
        System.out.println(cls.getPackage().getName()); // _9_reflect
        // 父类：返回一个Class对象
        System.out.println(cls.getSuperclass()); // class _9_reflect.A0
        System.out.println("===================================");
        // 接口:返回 Class 数组
        final Class[] interfaces = cls.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println(anInterface);
        } // interface _9_reflect.B0 | interface _9_reflect.C0
        System.out.println("===================================");
        // 注解: 返回 Annotation 数组
        final Annotation[] annotations = cls.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        } // @java.lang.Deprecated()
    }
}
