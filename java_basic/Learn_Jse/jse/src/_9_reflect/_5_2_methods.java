package _9_reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

class A2{
    public void a1(int i){}
    private void a2(){}
}

class B2 extends A2{
    public void b1(int i){}
    private void b2(){}
    private static void b3(String s){}
}

class C2{
    public static void c1(int a){}
    public void c2(String b){}
    private void c3(){}
}
public class _5_2_methods {
    @Test
    public void getMethods(){
        final Class<B2> cls = B2.class;
        // 获取自己和父类（包括多级）的所有public方法
        final Method[] methods = cls.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        /*
            public void _9_reflect.B2.b1(int)
            public void _9_reflect.A2.a1(int)
            此外，还有Object的public方法
         */
        System.out.println("===========================");
        // 获取自己 所有 方法（含非public）
        final Method[] methods1 = cls.getDeclaredMethods();
        for (Method method : methods1) {
            System.out.println(method);
        }
        /*
            private void _9_reflect.B2.b2()
            public void _9_reflect.B2.b1(int)
            private static void _9_reflect.B2.b3(java.lang.String)
         */
    }

    @Test
    public void methodMsg(){
        final Class<C2> cls = C2.class;
        final Method[] methods1 = cls.getDeclaredMethods();
        for (Method method : methods1) {
            System.out.println(method);
            // 方法名
            System.out.println("方法名：" + method.getName());
            // 修饰符,int (求和：默认0 | public 1 | private 2 | protected 4 | static 8 | final 16 )
            System.out.println("修饰符：" + method.getModifiers());
            // 返回类型，一个Class对象
            System.out.println("返回类型：" + method.getReturnType());
            // 参数类型，Class对象数组
            final Class<?>[] paras = method.getParameterTypes();
            for (Class<?> para : paras) {
                System.out.println("参数类型：" + para);
            }
            System.out.println("============================");
        }
        /*
            private void _9_reflect.C2.c3()
            方法名：c3
            修饰符：2
            返回类型：void
            ============================
            public static void _9_reflect.C2.c1(int)
            方法名：c1
            修饰符：9
            返回类型：void
            参数类型：int
            ============================
            public void _9_reflect.C2.c2(java.lang.String)
            方法名：c2
            修饰符：1
            返回类型：void
            参数类型：class java.lang.String
            ============================

         */
    }
}
