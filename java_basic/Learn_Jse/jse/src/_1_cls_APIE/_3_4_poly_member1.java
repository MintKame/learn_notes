package _1_cls_APIE;

public class _3_4_poly_member1 {
    /* 原理：use who's member ?
     obj.method(): dynamic binding at run-time
         check AType, (if not define)then check nearest super ...
         if one super has method, but can't access(private/default)
            err, why not check upper? even upper has, can't access: sub can't lower accessbility of upper
                // (vs: cpp优先call super， need "virtual" to call sub

     obj.property: no dynamic binding, just inherit
        use at 2-place:
          1. 对象方法内 访问 对象属性: use the property defined at current field
          2. 创建对象后，从外界 obj.property:
              check DType, then check nearest super ...
                      if one super has prop, but can't access(private/default)
                      err, not check upper, even upper have same accessible prop
     */
    //!  3*obj-poly:  (poly 3) call aType's func
    public static void main(String[] args) {
        A aRefb = new B();
        System.out.println(aRefb.num); // 都是10
        System.out.println(aRefb.toString()); //! diff cases (below)
    }
}
/* diff cases abcd:
 B是否or函数   a       b       c       d
 getNum()     T       T       F       F
 toString()   T       F       T       F
 result?      B20     A20     B10     A10   */
class A{
    // comments: steps 123 of case abc
    int num = 10; // c3
    public int getNum() {return num;} // c2
    public String toString() {return "A" + getNum();} // b1
}

class B extends A{
    int num = 20; // a3 b3
    public int getNum() {return num;} // a2 b2
    public String toString() {return "B" + getNum();} // a1 c1
}