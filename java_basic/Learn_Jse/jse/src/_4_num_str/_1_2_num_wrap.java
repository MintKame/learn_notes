package _4_num_str;

import java.math.RoundingMode;
import java.util.ArrayList;


public class _1_2_num_wrap {
  public static void main(String[] args) {

    //! wrapped cls
    Character character = 'a';
    Boolean bo = true;
    Byte bt = 1; // following extend Number
    Short s = 1;
    Integer i = 123;
    Long l = 1l;
    Float f = 1.0f;
    Double d = 1.0d;

    System.out.println(Integer.MAX_VALUE); // 2147483647
    System.out.println(Integer.MIN_VALUE); // -2147483648
    System.out.println(Character.isDigit('1')); // digit, letter, alphabetic, whitespace
    System.out.println(Character.isUpperCase('A')); // upper, lower
    System.out.println(Character.toUpperCase('a'));
  }
}
