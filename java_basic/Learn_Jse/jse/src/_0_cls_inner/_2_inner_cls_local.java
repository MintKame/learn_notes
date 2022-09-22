package _0_cls_inner;


class SuperCls{
    public SuperCls() {}
    public SuperCls(int dummy) {}
}

class Outer2{
    private void fun2(SuperCls s){}

    void fun1(){
        //! if 1(member inner cls) just use at local, can
        // define at local(fun, block) of outer cls:

        //! 2. local inner cls
        // cls修饰符: 只可 final(can't be extend
        class Inner2{
            private void f(){
                //!! access:
                // outer access inner: only at local ( in func1
                // other outer cls can't access inner cls
                // other same as 1.(member inner cls)
            }
        }

        //! 3. annoy inner cls (more see java8
        // simplify of 2, if:
        //      extends a cls / implements an IF
        //      cls only use one time ( cls no name

        // cls修饰符不可添加
        SuperCls inner3 = new SuperCls(){};
        // declare type = SuperCls,
        // actual type = Outer2$1 ( 表示为Outer的匿名内部类

        /* same as:
            class Outer2$1 extends SuperCls{}

            SuperCls inner3 = new Outer2$1{}
        */

        // pass para to ctor: (this will call SuperCls's para-ctor)
        new SuperCls(1){
            // and can't define ctor here
        };

        //! usage * 3:
        SuperCls a = new SuperCls(){
            void f(){}
        };

        new SuperCls(){
            void f(){}
        }.f(); // if override cls of super, run sub's (dynamic binding)

        fun2(new SuperCls(){
            void f(){}
        });

    }
}

public class _2_inner_cls_local {
}