package _7_io._2_decorater;

import java.io.Serializable;

// what should a cls do to be write by objIO? (2-ways)
//  implements Serializable (marker IF, no methods)
//  implements Externalizable (not recommand
class sCls implements Serializable{ // 可继承性，子类也可以序列化

  private static final long SerialVersionUID = 0; // 序列化版本号，提高兼容性，推荐

  //what field can be serialized ?
  //    non-static && not-transient ( other field must be prim/Serializable obj
  private String v0 = "a string";               //Y
  private static int v1;                        //N    
  private transient nsCls v2 = new nsCls();     //N
//  private nsCls v3 = new nsCls();             //err

  public void f1() {}
}
class nsCls{}