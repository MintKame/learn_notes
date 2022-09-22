package _9_reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

class A1{
    private int numA;
    public String strA;
}

class B1 extends A1{
    private int numB;
    public String strB;
    private static double dB;
}

public class _5_1_fields {
    @Test
    public void getFields(){
        final Class<B1> cls = B1.class;
        // 获取自己和父类（包括多级）的所有public字段
        final Field[] fields = cls.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        /*
            public java.lang.String _9_reflect.B1.strB
            public java.lang.String _9_reflect.A1.strA
         */
        System.out.println("===========================");
        // 获取自己 所有 字段（含非public）
        final Field[] fields1 = cls.getDeclaredFields();
        for (Field field : fields1) {
            System.out.println(field);
        }
        /*
            private int _9_reflect.B1.numB
            public java.lang.String _9_reflect.B1.strB
            private static double _9_reflect.B1.dB
         */
    }

    @Test
    public void methodMsg(){
        final Class<B1> cls = B1.class;
        final Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
            // 名
            System.out.println("名：" + field.getName());
            // 修饰符,int (求和：默认0 | public 1 | private 2 | protected 4 | static 8 | final 16 )
            System.out.println("修饰符：" + field.getModifiers());
            // 类型，一个Class对象
            System.out.println("返回类型：" + field.getType());
            System.out.println("============================");

        }
        /*
            private int _9_reflect.B1.numB
            名：numB
            修饰符：2
            返回类型：int
            ============================
            public java.lang.String _9_reflect.B1.strB
            名：strB
            修饰符：1
            返回类型：class java.lang.String
            ============================
            private static double _9_reflect.B1.dB
            名：dB
            修饰符：10
            返回类型：double
         */
    }
}
