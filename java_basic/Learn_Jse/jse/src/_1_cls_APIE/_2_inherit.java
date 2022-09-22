package _1_cls_APIE;

// what's reused by poly & inherit ?
// inherit -> reuse software(code);
// poly    -> reuse interface

public class _2_inherit {
  public static void main(String[] args) {
    ChildCtor childCtor = new ChildCtor();
  }
}
// what can be inherit from super ?
//  all property & method, but can't access private / default, super can provide public func to access
//  not ctor, but need call super's ctor when init

// ! ctor
/*
 what ctor do ?
  must call delegate ctor(this() / super())  at line 1
      default: super() !!! ( until Object, every cls extends Object
  init self-define member var
  update static value (eg. cnt..)

 why delegate ctor ?
  to reuse ctor from self / super
  to init inherited member

 how to prohibit create instance ?
  private ctor
  abs cls

 why do that ?
  only have static member eg. Math


 */
//1. from self
class DelegateCtor{  
  private int data;

  public DelegateCtor(){    
    this(1);      //must: 1st line (cpp only in init-list)
  }
  public DelegateCtor(int data){
    this.data = data;
  }  
}

//1. from super
class ParentCtor{
  ParentCtor(){     //(recommand) parent always def default ctor
    System.out.println("ctor Parent");
  }
  void parentFun() {
    System.out.println("func Parent");    
  }
}

class ChildCtor extends ParentCtor{
  ChildCtor(){               
    super();                //must: 1st line 
    System.out.println("ctor Child");
    super.parentFun();      //line not limit
  }
}

