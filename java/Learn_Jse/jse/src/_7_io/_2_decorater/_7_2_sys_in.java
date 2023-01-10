package _7_io._2_decorater;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class _7_2_sys_in{
  public static void main(String[] args) {

    // 编译类型：InputStream
    // 运行类型: BufferedInputStream
    System.out.println(System.in.getClass());
    // 节点流从键盘读取

    //! Scanner can read from ? *3
    //1.read inputStream
    Scanner in_1 = new Scanner(System.in);
    // Scanner(new InputStreamReader(System.in), WHITESPACE_PATTERN);

    //2.read string
    Scanner in_3 = new Scanner("12  34");
    Scanner in_4 = new Scanner("12\n34");
    System.out.println("12  34:\t" + in_3.nextInt() + in_3.nextLine()); // "12|  34" ==> "12  34|" （（（ | 表示读到哪里
    System.out.println("12\\n34:\t" + in_4.nextInt() + in_4.nextLine());// "12|\n  34" ==> "12\n|34"
    //  reason: nextInt stop before delimiter, nextLine get content bf Enter.

    //3.read file  
    try(
            Scanner s = new Scanner(new File("7_in.text"));
        ){
      ArrayList<String> content = new ArrayList<>(); //create a container to load the fr
      while(s.hasNextLine()) {     //note: can't use ch-char
        content.add(s.nextLine());
      }
    }catch(FileNotFoundException ex) {
      ex.printStackTrace();
    }
  }
}