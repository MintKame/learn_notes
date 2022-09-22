package _4_tool;
import java.util.Scanner;

public class _1_math_rand {
  public static void main(String []atgs)
  {
    Scanner input = new Scanner(System.in);
    //! cls Math
    double piNum = Math.PI;
    double rintNum = Math.rint(piNum);      // also: floor, ceil, round
    System.out.println(Math.round(1.1)); // -> 1


    //! Random
    double randomNum = Math.random();
    java.util.Random random = new java.util.Random();
    //para: set seed (default: current time)
    random.nextInt();
    random.nextInt();       //para: 0 - para (default 2^32)r
  }
}
