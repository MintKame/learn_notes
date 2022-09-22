package _6_generic;

import org.junit.jupiter.api.Test;

public class _3_methods {
    //! 自定义 泛型方法 ===============================
    class A{
        public <U> U fun(U u){ // 泛型可以出现在方法：参数，返回，局部
            U u2 = u;
            return u2;
        }
    }

    class B<T>{ // 也可以定义在泛型类中
        public <U> void f1(T t, U u){} // 使用了 泛型类的泛型T，定义了泛型U（是泛型方法）

        public void f2(T t){} // 普通方法，使用了 泛型类的泛型T
        // 是否为泛型方法：根据修饰符后面有无<...>
    }

    //! 使用：调用方法时，编译器根据传入参数，确定类型 ===============================
    @Test
    void test(){
        B<Integer> b = new B<>(); // 确定：类B的泛型T 为Integer
        b.f1(1, "abc"); // 确定：方法f1的泛型U 为String
    }
}
