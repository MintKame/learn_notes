package _2_cls_if_abs_enum;

abstract class Shape{

  //why abs define a ctor ? can create instance ?
  //    abs can't create instance
  //    to define ctor, sub can reuse
  
  //whether abstract ?
  //    cls can't implement func && not need create instance

  // abs func:
  protected Shape() { System.out.println("shape area is " + this.getArea()); }
  public abstract double getArea();
 
  //why static fun can't be abs ?
  //    static can't be override by sub
}

//! what need if extends abs ?
// override all abs fun / declare abs cls
//1. not-abs sub
class Circles extends Shape{    
  private double radius = 1.0;

  @Override //must implement
  public double getArea() { return radius * radius * 3.14; }
}

//2. abs sub 
abstract class Irregular1 extends Shape{
  abstract public String toString();

  abstract public double getArea();     //super's    abs fun
  //why declare non-abs -> abs
  //  to invalidate super's func
}

public abstract class _4_abstract {
  // public class can be abstract, not influence main
  
  public static void main(String[] args) {
    Shape s0 = new Circles();
    // can use abs cls ref to a sub cls(not abs)
    Shape[] s1 = new Shape[5];
    for(int i = 0; i < s1.length; i++) {
      s1[i] = new Circles();
    }
  }
}