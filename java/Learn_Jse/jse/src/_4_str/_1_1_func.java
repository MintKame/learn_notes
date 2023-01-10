package _4_str;
import java.util.Scanner;

public class _1_1_func {
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);

    // Serializable Comparable
    // Unicode, 1 char use 2 bytes

    //! create
    String s1, s2, s3;
    s1 = new String();
    s1 = new String("abc");
    s1 = new String(new byte[]{'a', 'b', 'c'});
    s1 = "abc";
    s3 = new String(new char[] {'a', 'b', 'c'}); // convert with char arr
    s3 = String.valueOf(new char[]{'a', 'b', 'c'});
    //s1, s2, s3 not ref to same obj

    //! input str
    System.out.println("input str(no blank): ");
    String str1 = input.next(); // delim with blank (not input \n)

    System.out.println("input str(with blank): ");
    String str2 = input.nextLine();// delim with \n

    //! msg: len
    String name = "Yan Zhao";
    System.out.println("name.length() is " + name.length()); // 8
    // (not have null like c)

    //! switch depends on str
    switch("abv")
    {
      case "abc":
        break;
      case "abv":
        break;
    }

    //! cmp: .compareTo  / .equals
    //     .startsWith / .endsWith
    System.out.println("==: " +     // ref to same obj
      (boolean)("abc" == new String("abc"))); //F
    System.out.println("equals: " + // same contents
      (boolean)("abc".equals(new String("abc")))); //T
    System.out.println("equals: " + // same contents
      (boolean)("abc".equalsIgnoreCase(new String("ABC"))));//T


    //! compare
    // compare each char, if diff at i -> (str1[i] - str2[i])
    // all same char                   -> (len1 - len2)
    System.out.println("aaa".compareTo("az"));  // 'a' - 'z' = -25
    System.out.println("aaa".compareTo("aa"));  // 3 - 2 = 1
    System.out.println("aaa".compareTo("aaa")); // 3 - 3 = 0
  }

}
