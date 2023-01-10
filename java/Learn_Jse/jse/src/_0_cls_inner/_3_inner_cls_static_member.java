package _0_cls_inner;

class Outer3{
    private static int num1;
    private static void fun1(){}

    //4. static member inner cls
    // cls修饰符: private/default/protected/public, final
    static public class Inner4{
        private int num1 = 10;
        void f(){
            //!! access:
            //! inner access outer: all *static* member (include private
            fun1();

            // if Inner, Outer have member with same name:
            num1++; // inner
            Outer3.num1++; // outer
            // *Outer3* can get outer *cls*
        }

        static void sf(){}
    }

    void fun(){
        //! outer access static inner:
        // entire cls(same as member of outer cls), all member of inner (include private
        Inner4 inner4 = new Inner4();
        inner4.num1++; // inner
        num1++; // outer
    }


    static Inner4 getInner4(){return new Inner4();}
}

public class _3_inner_cls_static_member {
    public static void main(String[] args) {
        //! other outer access inner:
        Outer3.Inner4.sf(); // not create Outer3, Inner4
        Outer3.Inner4 inner4 = new Outer3.Inner4(); // create Inner4, not create Outer3
        Outer3.getInner4();

        // compare to 1.(not static)
//        Outer1.Inner1 = new Outer1().new Inner1();

    }

}
