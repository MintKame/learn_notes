package _9_reflect;


import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

class A3{ 
    public A3(){}
    private A3(String s){}
}
class B3 extends A3{
    public B3(){}
    private B3(String s){}
}

public class _5_3_ctors {
    
    @Test
    void getCtors(){
        final Class<B3> cls = B3.class;
        // 获取自己（不含父）的所有public构造器
        final Constructor<?>[] constructors = cls.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
        /*
            public _9_reflect.B3()
         */
        System.out.println("===========================");
        // 获取自己 所有 构造器（含非public）
        final Constructor<?>[] constructors1 = cls.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors1) {
            System.out.println(constructor);
        }
        /*
            public _9_reflect.B3()
            private _9_reflect.B3(java.lang.String)
         */
    }

    @Test
    public void ctorMsg(){
        final Class<B3> cls = B3.class;
        final Constructor<?>[] constructor = cls.getDeclaredConstructors();
        for (Constructor<?> ctor : constructor) {
            System.out.println(ctor);
            // 名
            System.out.println("名：" + ctor.getName());
            // 修饰符,int (求和：默认0 | public 1 | private 2 | protected 4)
            System.out.println("修饰符：" + ctor.getModifiers());
            // 参数类型，Class对象数组
            final Class<?>[] paras = ctor.getParameterTypes();
            for (Class<?> para : paras) {
                System.out.println("参数类型：" + para);
            }
            System.out.println("============================");
        }
        /*

            public _9_reflect.B3()
            名：_9_reflect.B3
            修饰符：1
            ============================
            private _9_reflect.B3(java.lang.String)
            名：_9_reflect.B3
            修饰符：2
            参数类型：class java.lang.String

         */
    }
}
