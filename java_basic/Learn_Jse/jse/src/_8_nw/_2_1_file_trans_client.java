package _8_nw;

import com.sun.xml.internal.txw2.output.DataWriter;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class _2_1_file_trans_client{
    public static void main(String[] args) {
        try (
                Socket socket = new Socket("127.0.0.1", 11115); // request connect to server
                //why server need self-port, client need server-port ?
                //               server                         client
                // self port     提供用于listen                  随机choose by jvm (程序not need know)
                // peer port     对方申请连接后可知，用于发数据    需提前知道，用于申请连接

                BufferedWriter bw =  // 字符串：程序->网络
                        new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                BufferedInputStream bis = // 文件：网络->程序
                        new BufferedInputStream(socket.getInputStream());
                ByteArrayOutputStream aos = // 文件：程序->数组
                        new ByteArrayOutputStream(100000);
                BufferedOutputStream bos =  // 文件：数组->本地
                        new BufferedOutputStream(new FileOutputStream("nw_img.png"));
        ){
            //! 输出到网络中，都需要：
            // 1. flush(), 否则 出现exception 且 无法写入数据通道
            // 2. indicate finish write，否则接收方等待对方数据，阻塞
            //      writer: newLine / socket.shutdownOutput
            //      outputStream: socket.shutdownOutput

            // 1. 字符串：程序->网络
            bw.write("hello, server");
            bw.newLine(); // indicate finish write，另外一方需要用 newLine() 读取
            bw.flush();

            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = bis.read(buf)) != -1){  // 6. 文件：网络->程序
                aos.write(buf, 0, len); // 7. 文件：程序->数组
            }

            bos.write(aos.toByteArray()); // 8. 文件：数组->本地

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}