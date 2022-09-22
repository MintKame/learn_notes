package _0_arr;
import java.util.Arrays; 

public class _1_array {
 
  public static void main(String...args){
    //Is arr obj / prim ? is size fixed ?
    //    arrName is a ref to the obj
    //    after create, size fixed, but can change to ref other arr / null

    //! init
    int[] arrName;

    //! dynamic init: cxy set arr length, jvm set init value
    // can separate  with declare
    arrName  = new int[8]; //( default: 0 | 0.0 | false | str: null

    //! static init: cxy set init value, jvm set arr length
    arrName = new int[] {1,4,3,5}; // can separate with declare

    int[] arrWithoutNew = {1, 2, 3};     // simple: can't separate

    //! traverse: can't change primitive value
    int l = arrName.length;     //not a func

    for(Integer i : arrName) {
      i += 1;
    }
  }
}
