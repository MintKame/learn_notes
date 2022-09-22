package _1_cls_APIE;
import java.util.ArrayList;
//! what's visit limit & their :
//private   default     protect     public  
//inCls     inPkg       child       all 

//why: visibility is for cls, not for obj ?
//    eg. a cls has a member,
//        visit that member depends on visitor's class.

class Parent{ public void fun() {} }

class Child extends Parent{
  //why err ?
//  @Override
//  private void fun() {}
  //
  // sub override can't decrease visibility
  //( in cpp, 3 types inherit
}

class NotImmut {
//! how to make cls immutable?
//    (recommend) : eg: String

  //1. all data private;
  private ArrayList<Integer> list = new ArrayList<>();
  public NotImmut() { list.add(0); }

  //2. no setter
  //3. getter not return ref
  public ArrayList<Integer> getList_ref() { return list; }
  
  //how to define obj's getter for an immute cls ?
  //   solve--> copy with new, then return
  public ArrayList<Integer> getList_val() {     
    ArrayList<Integer> ret = (ArrayList<Integer>)list.clone();
    return ret; 
  }
  public void show() {
   System.out.println(list); 
  }
}

public class _1_encapsu {   //only 1 public cls
  int b;
  int a = b + 1;            //must below (special case)
  
  public static void main(String []args){     
    //test immut:
    NotImmut t = new NotImmut();
    t.show();
    t.getList_val().add(1);
    t.show();
    t.getList_ref().add(2);
    t.show();
  }
}  