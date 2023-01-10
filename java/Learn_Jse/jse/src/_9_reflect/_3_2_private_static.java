package _9_reflect;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Cls4{ // 方法和字段都为private static
    private static int num;

    private Cls4(String str){System.out.println("private ctor: " + str);}

    private static void fun(){System.out.println("private func");}

}
public class _3_2_private_static {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        final Class<Cls4> cls = Cls4.class;
        // 爆破（暴力破解）：
        // 1. 可以访问私有（ctor，字段，方法）
        // 2. 取消访问权限的检查（使用反射基本是解释执行，影响执行速度
        final Constructor<Cls4> ctor = cls.getDeclaredConstructor(String.class);
        ctor.setAccessible(true); // 爆破
        final Cls4 obj = ctor.newInstance("hello"); // “private ctor: hello”

        final Method fun = cls.getDeclaredMethod("fun");
        fun.setAccessible(true);// 爆破
        fun.invoke(obj); // “private func”
        fun.invoke(null); // static 可以不传入obj

        final Field num = cls.getDeclaredField("num");
        num.setAccessible(true);// 爆破
        num.set(obj, 10);
        System.out.println("num = " + num.get(obj)); // “num = 10”
        // static 可以不传入obj
        num.set(null, 10);
        System.out.println("num = " + num.get(null)); // “num = 10”
    }
}
