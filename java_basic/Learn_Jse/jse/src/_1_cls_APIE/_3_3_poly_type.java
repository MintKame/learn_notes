package _1_cls_APIE;

class ParentCls3{ }

class ChildCls3 extends ParentCls3 {}

public class _3_3_poly_type {

    public static void main(String[] args) {
        // DeclaredType       ActualType
        ParentCls3 pRefP = new ParentCls3();
        ChildCls3 cRefC = new ChildCls3();
        ParentCls3 pRefC = new ChildCls3();  
        //! 3*obj-poly:  (poly 2) super ref to sub (also call 向上转型

        //! change:
        //              when
        // DeclaredType compile   can't change
        // ActualType   run       can change
        // pRefC = new ParentCls3(); eg. AType change to ParentCls3

        //! cast
        //    ChildCls3 cc1 = pRefC;               compiler check dType
        //    ChildCls3 cc2 = (ChildCls3)pRefP;     run-time check aType
        // err: can't use sub ref to super:
        ChildCls3 cc3 = (ChildCls3)pRefC;   // OK, (also call 向下转型
    }
}
