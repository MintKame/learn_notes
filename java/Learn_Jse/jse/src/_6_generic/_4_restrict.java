package _6_generic;

import org.junit.jupiter.api.Test;

public class _4_restrict {
    class A {}
    class B extends A {}
    class C extends B{}

    class Student<T>{} // 泛型类

    // 泛型类 作为 方法的参数时，
    // 方法定义： 可约束 类的泛型（使用通配符）
    void f1(Student student){} // 任意泛型
    void f2(Student<?> student){} // 任意泛型（同上）
    void f3(Student<? extends B> student){} // B或B的子类
    void f4(Student<? super B> student){} // B或B的父类
    void f5(Student<B> student){} // B

    @Test
    void testF1(){
        f1(new Student<Integer>());
        f1(new Student<A>());
        f1(new Student<B>());
        f1(new Student<C>());
    }

    @Test
    void testF2(){
        f2(new Student<Integer>());
        f2(new Student<A>());
        f2(new Student<B>());
        f2(new Student<C>());
    }

    @Test
    void testF3(){
        // f3(new Student<Integer>());
        // f3(new Student<A>());
        f3(new Student<B>());
        f3(new Student<C>());
    }

    @Test
    void testF4(){
        // f4(new Student<Integer>());
        f4(new Student<A>());
        f4(new Student<B>());
        // f4(new Student<C>());
    }

    @Test
    void testF5(){
        // f5(new Student<Integer>());
        // f5(new Student<A>());
        f5(new Student<B>());
        // f5(new Student<C>());
    }
}
