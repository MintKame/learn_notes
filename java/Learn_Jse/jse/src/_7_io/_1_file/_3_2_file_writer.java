package _7_io._1_file;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class _3_2_file_writer {
    public static void main(String[] args) throws IOException {

        FileWriter fw = new FileWriter("3_file2.txt");
        fw.write('计');
        fw.write(new char[]{'算', '机'}); // 可指定数组的部分
        fw.write("系统"); // 可指定字符串的部分

        fw.close();

    }
}
