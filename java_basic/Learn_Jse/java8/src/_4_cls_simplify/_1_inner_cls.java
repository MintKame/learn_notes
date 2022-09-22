package _4_cls_simplify;

//when use inner class?
//  cls only used by outer & need visit outer's member

//what benefits?
//a. simplify pkg  (compile to what ?):
//      Outer.class
//      Outer$InnerName.class
//b. readable (inner closer to where use it)
//c. avoid name conflict

class Outer{
  public int outdata;
  // 成员内部类
  //what modifier can used to def inner cls ?
  //    static, visibility (4 modifier)
  class InstanceInner{
    int indata = outdata;  //inner can visit Outer's member
  }
  static class StaticInner{}

  //2. how to create instance of inner-cls from outer cls ?
  public static void main(String[] args) {
    //static: visit via Outer cls
    StaticInner a = new StaticInner();
    //non-  : visit via Outer obj
    Outer out = new Outer();
    InstanceInner b = out.new InstanceInner();
  }
}
public class _1_inner_cls {

  //2. how to create instance of inner-cls from diff cls ?
  public static void main(String[] args) {
    //static
    Outer.StaticInner a = new Outer.StaticInner();
    //non-
    Outer out = new Outer();
    Outer.InstanceInner b = out.new InstanceInner();
  }
}



