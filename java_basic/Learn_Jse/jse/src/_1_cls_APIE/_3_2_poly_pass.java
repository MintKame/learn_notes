package _1_cls_APIE;
public class _3_2_poly_pass {

  static class Circle{ int radius = 1;}
  static class Square{ int length = 2;}
    
  public static void main(String[] args) {
    int a = 0;
    Circle c = new Circle();
    Square s = new Square(); 
    Object o = new Object();
    //! 3*obj-poly:  (poly 1) pass sub-obj as super-obj
    // benefit ?
    //    pass diff sub-obj to same func, reuse code
    //    in func, can compare diff-type child's common feature (inherited from super)
    showMessage(o);
    showMessage(c);
    showMessage(s);
    showMessage(a); // int -> Integer (auto)
  }


  //! how to do diff base on AType ?
  static void showMessage(Object o) {   //  define func: need pass superCls
    //  use "instanceof"
    if(o instanceof Integer) { System.out.println("int"); }

    else if (o instanceof Circle) {
      System.out.println("Circle's radius: " + ((Circle)o).radius);
    }

    else if(o instanceof Square) {
      System.out.println("Square's length: " + ((Square)o).length);
    }
    else {
      System.out.println("not circle or square or Integer");
    }
  }
}