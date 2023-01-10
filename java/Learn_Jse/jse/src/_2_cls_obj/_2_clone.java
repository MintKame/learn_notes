package _2_cls_obj;

import java.util.ArrayList;

//where does clone() from ?

/*
 * from Object (caz obj can implement clone(), but can't compareTo())
 *
 * IF Cloneable is empty (java.util):
 *    marker interface (check at runtime)
 */

class A implements Cloneable{
  private ArrayList<Integer> data = new ArrayList<>();
  @Override
  public Object clone() throws CloneNotSupportedException {
    //what always do in clone() ?
    //
    //1. copy common property:
    A ret = (A)super.clone();
    // Object's clone() copy each field
    // super's  clone() copy field inherit from super

    //2. copy special (not inherit) property
    // (use clone)
    ret.data = (ArrayList<Integer>)(data.clone());
    return ret;
  }

  //what always do in equals() ?
  @Override
  public boolean equals(Object o) {
    //not-primitive member: use equals()
    //    primitive member: use ==
    return ((A)o).data.equals(this.data);
  }
}
public class _2_clone {
  public static void main(String[]args) throws CloneNotSupportedException {
    A a = new A();
    A ca = (A)a.clone();
    A ra = a;
    System.out.println(a.equals(ca));   //t
    System.out.println(a == ca);        //f
  }
}