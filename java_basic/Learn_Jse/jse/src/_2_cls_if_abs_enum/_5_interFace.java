package _2_cls_if_abs_enum;

//              super      member     IF
// relation     is-a       has-a      is-kind-of
// how name     nouns                 nouns/adj. (more flexible)

//! what's diff abs-class & IF ?
//  both can't create instance
//               abs                    IF
//  inherit   | impl n*IF; ext 1*cls  | ext n*IF
//  ctor      | to be inherit by sub  | can't define
//  main func | Y                     | N
//              extend                  implement
// purpose    | reuse, 可维护          | 设计规范（方法），一定程度代码解耦（接口规范性+动态绑定）

//tips: use abs-cls to implements interface.
//      convenient to choose if / abs

//IF not have common root, compile to a file(.class)

//what can IF contain ? 
//  constant | abs func | static func | default func (last 2 need implements in IF)

//what identifier of member in interface can omit ?
//  func: public abstract
//  data: public static final (not use)
interface Feedable{   String type = "feedable"; void feed(); }
interface AIF_0{}

//how to inherit between IFs ?  multi-inherit
interface SubIF extends Feedable, AIF_0{}

abstract class Animal{  String type = "animal";}

//how to inherit between IF & CLS ?
class Cat extends Animal implements AIF_0, Feedable{ //implements == SubIF
  String type = "cat";
  @Override
  public void feed() {}

  public void printField(){
    //! access diff member of same name
    System.out.println("type " + type); // in this field
    System.out.println("this type " + this.type);
    System.out.println("super type " + super.type);
    System.out.println("IF type " + Feedable.type);
  }
}

public class _5_interFace {
  public static void main(String[] args) {

    Animal animal = new Cat(); //cat extends animal, implements IF(have feed())
    //animal.feed();   
    //why err ?
    //  dType(Animal) not implement feed() from IF
    //
    // 3 ways to solve ?
    //solve - 1/2: cast
    ((Cat)animal).feed();
    ((Feedable)animal).feed();
    //solve - 3
    //to have abs-feed: abstract class
  }
}
