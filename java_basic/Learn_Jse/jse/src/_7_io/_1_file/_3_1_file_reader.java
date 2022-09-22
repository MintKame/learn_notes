package _7_io._1_file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class _3_1_file_reader {
    public static void main(String[] args) throws IOException {

        // 字节流读取 “123你好”
        // problem: 字节流可以读写中文
        // 但是，文件写入内容为字符形式，却读入为字节，
        // 注意：必须读写方式一致，如都用字节（iostream）
        FileInputStream fi = new FileInputStream("3_file.txt");
        int data1;
        while ((data1 = fi.read())!=-1){ // -1 ~ 255， 汉字被当成多个byte读入，乱码
            System.out.print((char) data1);
        }
        fi.close();

        System.out.println("\n==============================");
        // solve: 字符流
        FileReader fr1 = new FileReader("3_file.txt");
        int data;
        while ((data = fr1.read())!=-1){ // -1 ~ 0xFFFF，每次读入一个字符（一个汉字作为一个字符）
            System.out.print((char) data);
        }
        fr1.close();

        System.out.println("\n==============================");
        FileReader fr2 = new FileReader("3_file.txt");
        int dataLen;
        char[] buf = new char[10];
        while ((dataLen = fr2.read(buf))!=-1){  // 一次读入多个字符
            System.out.print(new String(buf, 0, dataLen));
        }
        fr2.close();

    }
}
