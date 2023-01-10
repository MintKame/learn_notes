package _4_cls_simplify;
public class _2_anony_inner_cls {
  public static void main(String[] args) {
    //what is AIC ?  anony_inner_cls
    //  same-time: define cls & create obj

    //when can use AIC ?
    //  inner cls only use 1 time (the class is anony)
    //            extend super / implement IF

    /* form:
        new SuperCls( // para pass to ctor ){
          // def of sub's var && func
        };
    */
    
    Object o1 = new Object() {};
    Object o2 = new Object();
    //      dType    aType?
    //o1:  Object | anony sub cls of Object
    //o2:  Object | Object

    new IFName() {
      @Override
      public int func() {
        return 0;
      }
      //what AIC contains ?
      //    Implements / override methods (abs-method must implements)
      //    self-def methods
    };
    //what compile to? 
    //  OuterClassName $ N.class (N: an int)
  }
}
interface IFName{
  abstract int func();
}
