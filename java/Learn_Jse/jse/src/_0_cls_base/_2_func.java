package _0_cls_base;

public class _2_func { 

  //how to pass para to method ?
  //  pass by value - for obj, pass value of ref (obj name is a ref)

  // eg.
  //  def: void func(fObj)
  //  in caller: cObj.m = abc
  //  pass to func(cObj)
  //
  //  obj1
  //  ------
  //  |    | <- cObj
  //  |abc | <- fObj
  //  ------

  // 0. fObj.m = def;
  //
  //  obj1
  //  ------
  //  |    | <- cObj
  //  |def | <- fObj
  //  ------

  // 1. fObj = new obj
  //
  //  obj1                        obj2
  //  ------                      ------
  //  |    | <- cObj              |    | <- fObj
  //  |abc |                      |... |
  //  ------                      ------

  static void statFun(MyClass myclass) {}
  void localFun() {}
  
  public static void main(String []args) {
    MyClass myclass = new MyClass();
  }
}

class MyClass{ 
  //Name reuse between 
  //    a. member & local ? 
  //    b. diff local block ?
  int data;

  void fun() {
    int data = 1;   //can
    //for(int data = 0; data < 10; data++)
    // err, can't local var declare twice

    //how to visit member ?
    this.data = 1;
  }
  //use tool to auto generate getter & setter
} 