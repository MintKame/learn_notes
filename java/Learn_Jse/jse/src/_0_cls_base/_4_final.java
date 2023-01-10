package _0_cls_base;

public class _4_final {
    static class Person{
        String name;
        Person(String name){this.name = name;}
    }
// 不可：interface, abstract class
    public static void main(String[] args) {
        //0. final local var
        final int c1;
        c1 = 1;
        // c1 = 2; error

        final char[] chars = new char[]{1, 2};
        chars[1] = 1;
        // chars = new char[]{1}; // error, can't change ref

        final Person person = new Person("a");
        person.name = "b";
        // person = new Person("b");

    }
}

//1. final class: can't be extend
// eg: Integer, String

//error: class Bfinal extends AFinal{}

final class AFinal{
    //2. final member var: can't change
    // where init ?
    // non static: 3 location
    final int A_1 = 1; // const var name XX_XX
    final int A_2;
    { A_2 = 2; }

    final int A_3;
    public AFinal() {A_3 = 3;}

    // static: 2 location
    static final int B_1 = 1; //special: efficient (access var not load cls)
    static {B_2 = 2;}
    static final int B_2;
}

//3. final method:
// can't be override by child
class BF{
    final void fun(){}
}

class CF extends BF{
    /*
        @Override
        void fun(){}
     */
    void hi(){fun();} // but can be inherit

    // final CF(){} error

    // hint: a final cls, its method not need be final
}