package _7_io._2_decorater;

import java.io.*;

public class _4_2_buf_rw_cp {
    public static void main(String[] args) {
        // buf io copy 类似 file io copy
        // try-with-resource (auto close)
        try (
                //in ():
                //  must declare & create together
                //  CLS must implements AutoCloseable
                BufferedReader br = new BufferedReader(new FileReader("4cp.txt"));
                BufferedWriter bw = new BufferedWriter(new FileWriter("4cp2.txt"));
        ){
            String data = "";
            // 按行读，效率高
            while ((data = br.readLine()) != null){  // null 为读完
               bw.write(data); // 因为buffer，实际上不一定写入，只在buf满了或者close时写入
               bw.newLine(); // 和系统相关的换行
           }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
