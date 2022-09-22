package _7_io._2_decorater;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class _7_1_sys_out {
    public static void main(String[] args) throws IOException {

        // 编译类型：PrintStream
        // 运行类型: PrintStream
        System.out.println(System.out.getClass());
        // 节点流默认输出到屏幕，可以设置为其他PrintStream
//        System.setOut(new PrintStream("7_out"));

        System.out.write("你好".getBytes()); // 底层为FilterOutputStream.write()
        System.out.println("你好"); // 底层为PrintStream.write() => (BufferedWriter)textOut.write(s);

        PrintWriter pw1 = new PrintWriter(System.out);
        // ctor: PrintWriter(new BufferedWriter(new OutputStreamWriter(out)), autoFlush);
        pw1.print("hello你好");
        pw1.write("hello你好"); // 底层调用write,可以直接调用
        pw1.close();

//        PrintWriter pw2 = new PrintWriter(new FileWriter("a"));
//        pw2.close()
    }
}