package _7_io._2_decorater;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
public class _6_1_io_rw {
  public static void main(String[] args) throws IOException {

      // 作用1：convert: byte <-> text
      // 从字节流中读入字符
//      InputStreamReader isr0 = new InputStreamReader(System.in); // stream -> byte --isr-> text
      // 将字符写入字节流
//      OutputStreamWriter osw0 = new OutputStreamWriter(System.out);// text --osw-> byte -> stream

      // 作用2：指定读写的字符集  ======================================================
      PrintWriter pw = new PrintWriter(System.out);

      FileReader fr  = new FileReader("6.txt"); // UTF-8
      char[] data  = new char[1024];
      int len = 0;
      while ((len = fr.read(data)) != -1){
          pw.write(data, 0, len);
      }
      pw.println();
      fr.close();
      // problem ======================================================
      FileReader fr2  = new FileReader("6_2.txt");  // ANSI(gbk)
      data  = new char[1024];
      len = 0;
      while ((len = fr2.read(data)) != -1){
          pw.write(data, 0, len);
      }
      pw.println();
      fr2.close();
      // solve：指定编码格式 ======================================================
      InputStreamReader fr3  =  // ANSI(gbk)
              new InputStreamReader(new FileInputStream("6_2.txt"), "gbk");
      data  = new char[1024];
      len = 0;
      while ((len = fr3.read(data)) != -1){
          pw.write(data, 0, len);
      }
      pw.println();
      fr3.close();
      // 注意：读写需要一致：流（字符流或字节流），字符集



      pw.close();
  }
}
