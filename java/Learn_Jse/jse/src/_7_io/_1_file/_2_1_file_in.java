package _7_io._1_file;

import java.io.*;

public class _2_1_file_in  {
  public static void main(String args[]) throws IOException {

    File file = new File("2_file.dat");
    if (!file.exists()){
      System.out.println("file 不存在");
      System.exit(1);
    }

    // read 1-byte, ret int type ( -1 finish
    FileInputStream fi1 = new FileInputStream(file);
    int data = 0;
    while ((data = fi1.read()) != -1){
      System.out.println((char) data);
    }
    fi1.close();

    // store in arr, ret len ( -1 finish
    // read multi bytes each time , more effectient
    FileInputStream fi2 = new FileInputStream(file);
    byte[] buf = new byte[10];
    int size = 0;
    while ((size = fi2.read(buf)) != -1) {
      System.out.println(new String(buf, 0, size));
    }
    fi2.close();
  }
}