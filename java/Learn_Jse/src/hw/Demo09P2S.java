package hw;
/**
 * 这是服务器程序。
 * 
 * 客户端连接后，不断接收客户端发来的半径并返回面积；
 * 当客户端发来负数时退出
 */

import java.io.*;
import java.net.*;

class Worker extends Thread{
  Socket socket;
  Worker(Socket s_){
    socket = s_;
  }
  @Override
  public void run() {
    try(
            // 创建 Data Input/Output 流
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            ) {
        // 从客户端接收圆的半径（通过DataInput流读取）
        double r = in.readDouble();
        // 半径小于0，则退出循环
        while (r >= 0.0){
          // 计算圆面积
          double area  = r * r * Math.PI;
          // 把面积发回给客户端
          out.writeDouble(area);
          // 输出提示信息
          System.out.println("\tRadius is : " + r);
          System.out.println("\tArea   is : " + area);
          r = in.readDouble();
        }
    }catch (IOException e){
      e.printStackTrace();
    }
  }
}

public class Demo09P2S {
  public static void main(String[] args) {
    try(
            // 创建一个ServerSocket对象，指定监听端口，与客户端程序保持一致
            ServerSocket server = new ServerSocket(8000);
            ) {
      System.out.println("Listening on port 8000");
      System.out.println("Client connected");
      double r;
      // 加入while循环，使得服务器不断接收半径并发送面积
      while(true) {
        new Worker(server.accept()).start();  // 监听并等待接受连接：accept
      }
    }catch(IOException ex) {
      ex.printStackTrace();
    }finally {
      System.out.println("Server closed");
    }
  }
}
