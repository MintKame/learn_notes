package _0_cls_base;

class Parent{
    static int snum = printP1();
    int num = printP2();

    static {System.out.println("parent static block");}

    {System.out.println("parent block");}

    Parent(){System.out.println("parent ctor");}

    static int printP1(){System.out.println("parent static var"); return 0;}
    int printP2(){System.out.println("parent var"); return 0;}
}

class Child extends  Parent{
    static int snum = printC1();
    int num = printC2();

    static {System.out.println("child static block");}

    {System.out.println("child block");}

    Child(){System.out.println("child ctor");}

    static int printC1(){System.out.println("child static var"); return 0;}
    int printC2(){System.out.println("child var"); return 0;}
}

public class _3_block {

    public static void main(String[] args) {
        new Child();
    }

    //! why use init block ?
    //     diff ctor's common statements, move in block => reuse code

    //! when load class?
    //  new obj, use static field
    //  super before sub load

    //! exe order?
    // super cls loaded:
    //   1. cinit(): init static property, static initBlock (same priority, depends by order)
    // sub cls loaded:
    //   2. cinit(): init static property, static initBlock (same priority, depends by order)
    // super obj:
    //   3. init(): init property, initBlock (same, priority, depends by order)
    //   4. ctor
    // sub obj:
    //   3. init(): init property, initBlock (same, priority, depends by order)
    //   4. ctor

}


