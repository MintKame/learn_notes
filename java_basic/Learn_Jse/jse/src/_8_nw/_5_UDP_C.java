package _8_nw;

import java.io.*;
import java.net.*;
import java.util.*;

public class _5_UDP_C {

  //! 区别：
  // tcp：收发方ip，port 唯一确定 一个收方的socket
  // udp：收方ip，port 唯一确定 一个收方的socket（即不同的client发到server的同一个socket）
  public static void main(String[] args) {
    try(
            DatagramSocket socket = new DatagramSocket();
            // port: not specify local port, auto generate
    ){
      // 0. Initialize buffer
      byte[] buf = new byte[256];  // for send and receive packets
      Arrays.fill(buf, (byte) 0);

      // send steps:       (separate can reuse packet-----------------------------------------
      //  0. init buf
      //  1. init packet with buf & len
      //  2. packet set addr & port
      //  3. packet set data
      //  4. packet send by socket
      DatagramPacket sendPacket = new DatagramPacket(buf, buf.length,
              InetAddress.getByName("localhost"), 8000); // 1,2
      // port: need server's add + port, Client need know previously

      // 3. how set data ?
      sendPacket.setData((new Scanner(System.in).nextDouble() + "").getBytes());
      //      also can: (Double.valueOf(r).toString().getBytes());

      socket.send(sendPacket); // 4
      // socket 给出local的ip+port，packet设置了对方的ip+port

      // receive: -------------------------------------------------
      DatagramPacket receivePacket = new DatagramPacket(buf, buf.length);
      socket.receive(receivePacket);
      // how to byte[] -> double ?
      System.out.println("receive " +
              Double.parseDouble(new String(buf).trim()) + '\n');

    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}
