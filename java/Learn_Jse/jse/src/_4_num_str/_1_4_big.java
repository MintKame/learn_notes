package _4_num_str;

import java.math.RoundingMode;
import java.util.ArrayList;

public class _1_4_big {
    public static void main(String[] args) {

        //! BigInteger, BigDecimal: diff int / double
        java.math.BigDecimal bigDec0= new java.math.BigDecimal("1234");
        java.math.BigDecimal bigDec1= new java.math.BigDecimal("3");
        System.out.println( bigDec0.multiply( bigDec0 ));
//    System.out.println(bigDec0.divide( bigDec1 ) );  //exception
        System.out.println( bigDec0.divide(
                bigDec1, 20, RoundingMode.CEILING));
        //    are sub of java.lang.Number (abstract class)
        ArrayList<Number> nums = new ArrayList<>();
        nums.add(1);
        nums.add(3.14);
        nums.add(new java.math.BigInteger("1.2345"));
    }
}
