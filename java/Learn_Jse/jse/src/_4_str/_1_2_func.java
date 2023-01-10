package _4_str;

public class _1_2_func {
  public static void main(String[] args) {
    //! can use regex: replace, split, matches
    "Welcome".replace('e', 'E'); // "WElcomE"
    "Welcome".replaceFirst("el", "EL"); // "WELcome"
    "Welcome".replaceAll("e", "E"); // "WElcomE"

    "abc".toUpperCase(); // "ABC"

    "abc".toCharArray();
    // s3.getChars();

    //! plus: concat
    System.out.println("\"ab\".concat(\"c\") is " + "ab".concat("c"));
    // what is a after a.concat(b) ?
    //  still a, immutable, just return the result, a new str

    //! sub: char, trim, str
    String name = "Yan Zhao hhh";
    int firstBlankIndex = name.indexOf(' '); // 3
    name.indexOf('$'); // -1
    int lastBlankIndex = name.lastIndexOf(' '); // 8
    //can find str; 2nd para is fromIndex; can find from last
    System.out.println("trim() is "+ " \tab\t".trim()); //"ab"
    System.out.println(name.substring(0, firstBlankIndex)); // "Yan"
    System.out.println(name.substring(firstBlankIndex + 1)); // "Zhao hhh"
    //sub contain chars at [fromIndex to (toIndex - 1)], toIndex can ignore
    System.out.println("name.charAt(1) is " + name.charAt(1));  // 'a'
    // get int
    int i = Character.getNumericValue("a 3 b".charAt(2)) - 1;

    //! format
    System.out.printf("%0+10.2f %b\n", 1.2,1);// +000001.20 true
    // same as:
    System.out.print(String.format("%0+10.2f %b\n", 1.2,1));


    String[] tokens = "Java&Html&cpp".split("&");
    //"Java", "Html", "cpp"
    // split by special char, need \
    String path = "E\\aa\\bb";
    System.out.println(path);
    for (String s :path.split("\\\\")) { // "E" "aa" "bb"
      System.out.println(s);
    }
  }
}
