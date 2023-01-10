package _6_generic;

public class _1_cls {

    //! 自定义 泛型类：泛型出现在类的4个地方 ===============================
    static class A<T>{
        // 不能出现在静态成员：new创建对象时才确定类型，
        // 而在类加载时就创建了静态成员，此时不知类型
        // static T st;
        // static T f1(T s){};

        public T[] arr = null;
        // public T[] arr = new T[10];
        // 泛型数组不可初始化，因为T未确定，不可知数组占用的空间大小

        public T t; // 1.属性类型

        public void setT(T t) {this.t = t;} // 2.方法参数类型

        public T getT() { return t; } // 3.方法返回值类型

        public void f2(){
            T tmp;  // 4.方法局部变量
            // T[] m = new T[1]; // 泛型数组不可初始化
        }
    }
    // 实例化：泛型函数/类  -> 普通函数/类
    //  when: 编译时，非运行时

    //! 使用1：继承泛型类 ==============================================

    /*              B   C   D   E
    指定父类的泛型   1   0   1   0 （也成为：泛型的实例化）
    定义新泛型       0   0   1   1
    */

    static class B1 extends A<Integer>{ }  // 实例化为普通类 t的类型为Integer

    static class B2 extends A{} // 实例化为普通类，t的类型为Object
    //等价于：class C extends A<Object>{}

    static class C<T> extends A<T>{} // 泛型类(父)，没有实例化父类的泛型

    static class D<U> extends A<Integer>{ U u; } // 实例化父类的泛型，同时定义子类的泛型，仍为泛型类（子），t的类型为Object
    //等价于：class E<U> extends A<Object>{}

    static class E<U, T> extends A<T>{U u;} // 泛型类（父+子）

    //! 使用2：先确定泛型，再创建对象 ===============================
    public static void main(String[] args) {
        new A<>(); // 没指定类型，默认类型为Object
        new A<Integer>();

    }
}
