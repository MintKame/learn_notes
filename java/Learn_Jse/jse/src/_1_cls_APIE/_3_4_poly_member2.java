package _1_cls_APIE;
class ParentCls{  
  public void ol() { System.out.println("ol in parent");  }
  public void or() { System.out.println("or in parent");  }
  public static void staticFun() {  System.out.println("static in parent");  }
}

class ChildCls extends ParentCls{
  public void ol(int dummy) {  // overload need same name, diff para
    System.out.println("ol in child");
  }
  public void or() { System.out.println("or in child"); }
  public static void staticFun() {  System.out.println("static in child");  }
}

public class _3_4_poly_member2 {

  public static void main(String[] args) {
    ParentCls pRefP = new ParentCls();
    ChildCls cRefC = new ChildCls();
    ParentCls pRefC = new ChildCls();

    // override：call who's func ?
    pRefP.or();     //p
    cRefC.or();     //c
    pRefC.or();     //! c  (poly 3)

    //! 2 special case (can't override) ?
    //  private func: child can't override; can't call
    //  static fun  : child can't override; can call (super & sub call the same one)
    //    if c def sameName -> unrelated func -> when call, decide on dType
    //    p's func name hide by c's func
    pRefP.staticFun();  //p
    cRefC.staticFun();  //c
    pRefC.staticFun();  //p
  }
}
