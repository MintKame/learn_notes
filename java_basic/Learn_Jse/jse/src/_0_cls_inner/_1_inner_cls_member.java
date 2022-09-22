package _0_cls_inner;


class Outer1{
    private int num1 = 1;
    private void fun1(){}

    //! 1. member inner cls
    // define as member of cls:
    // cls修饰符: private/default/protected/public, final
    public final class Inner1{
        private int num1 = 10;
        void f(){
            //! access:
            // inner access outer: all member (include private
            fun1();

            // if InnerCls and OuterCls have member with same name:
            num1++; // inner
            Outer1.this.num1++; // outer
            // Outer1.this: get outer obj
        }
    }

    void fun(){
        // outer access inner:
        // entire cls(same as member of outer cls), all member (include private
        Inner1 inner1 = new Inner1();
        inner1.num1++; // inner
        num1++; // outer
    }

    Inner1 getInner1(){return new Inner1();}
}

public class _1_inner_cls_member {
    public static void main(String[] args) {
        // other outer access inner:
        new Outer1().new Inner1();
        new Outer1().getInner1();
    }
}













