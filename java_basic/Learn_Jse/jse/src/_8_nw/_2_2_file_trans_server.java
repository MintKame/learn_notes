package _8_nw;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class _2_2_file_trans_server {
    public static void main(String[] args) {
        try (
                ServerSocket ss = new ServerSocket(11115); // listen self-port, wait until client request connect
                Socket socket = ss.accept(); // get socket, connent with client

                //socket: get ioStream to communicate with client
                BufferedReader br =  // 字符串：网络->程序
                        new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedInputStream bis = // 文件：本地->程序
                        new BufferedInputStream(new FileInputStream("img.png"));
                ByteArrayOutputStream aos = // 文件：程序->数组
                        new ByteArrayOutputStream(100000);
                BufferedOutputStream bos =  // 文件：数组->网络
                        new BufferedOutputStream(socket.getOutputStream());
        ){
            // 2. 字符串：网络->程序
            String str = br.readLine().trim();
            System.out.println("client: " + str);

            // =========== 可以封装为工具类，实现 inputStream -> byte[]
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = bis.read(buf)) != -1){  // 3. 文件：本地->程序
                aos.write(buf, 0, len); // 4. 文件：程序->数组
            }
            byte[] bytes = aos.toByteArray();
            // ===========

            bos.write(bytes); // 5. 文件：数组->网络
            bos.flush();
            socket.shutdownOutput(); // indicate finish output
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}