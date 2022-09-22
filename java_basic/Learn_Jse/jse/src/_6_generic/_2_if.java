package _6_generic;

public class _2_if {
    //! 自定义 泛型接口===============================
    interface A<T> {
        // 不能出现在静态成员(同class)
        // T t; // 属性都为static
        // static T fun(){} // static方法必须定义方法体

        void fun2(T t); // 只能：非static方法的参数和返回类型
    }
    //! 使用：class实现/if继承 ===================================
    //  与泛型类的使用1类似
    class B<T> implements A<T>{ public void fun2(T t){} } // 泛型类

    class C implements A<Integer>{ public void fun2(Integer t){} } // 普通类，泛型指定为Integer

    interface D<T> extends A<T>{} // 泛型if

    interface E extends A<Integer>{} // 普通if，模板指定为Integer
    /* 因为E的泛型指定为Integer，E为普通类
        E相当于:
            interface E{ void fun2(Integer t); }
            因此，E的子类实现fun2，参数类型为Integer
     */
    class F implements E{
        @Override
        public void fun2(Integer integer) {}
    }
}
