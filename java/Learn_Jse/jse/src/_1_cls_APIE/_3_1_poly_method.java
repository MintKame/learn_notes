package _1_cls_APIE;
//! poly:
// 2 method-poly: overload, override
// 3 obj-poly ?

//! compare
//            where   methodName  methodPara            retType   encapsulate
//overload    this    same        diff(num,type,order)  -         -
//override    p & c   same        same                  same      can't weaker

class ParentCls1{
    public void ol() { System.out.println("ol in parent");  }
    public void or() { System.out.println("or in parent");  }
}

class ChildCls1 extends ParentCls1 {
    public void ol(int dummy) {System.out.println("ol in child");}
    public void or() { System.out.println("or in child"); }
    // in child's override func, often call parent's -> reuse code
}

public class _3_1_poly_method {
    public static void main(String[] args) {
        ParentCls1 pRefP = new ParentCls1();
        ChildCls1 cRefC = new ChildCls1();
        ParentCls1 pRefC = new ChildCls1();
        // overload: result ? call who's func ?
        pRefP.ol();
        cRefC.ol();
        cRefC.ol(1);
        pRefC.ol();
        //p p (inherit from p) c p
        // 取决于：传入的参数 对应 哪个method
        ((ChildCls1)pRefC).ol(1); //c
    }
}
