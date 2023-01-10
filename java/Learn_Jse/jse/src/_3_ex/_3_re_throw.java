package _3_ex;

public class _3_re_throw {


  //chain: m2 (throw ex) - m1(catch & rethrow) -  main(catch & call getMsg() )
  public static void main(String[] args) {
    try {
      method_1();
    }
    catch(Exception ex) {
      ex.printStackTrace();               //show all msg
      //what is output of getMsg() ?
      System.out.print(ex.getMessage());  //only new msg (from m1)
    }
  }

  public static void method_1() throws Exception {
   try { method_2(); }
   catch(Exception ex) {
     //how m1 rethrow with new msg ?
     throw new Exception("new msg in 1", ex); }  //rethrow a wrapped ex
  }

  public static void method_2() throws Exception{
    throw new Exception("ex in 2");
  }
  

}
