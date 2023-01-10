package _8_nw;

import java.io.*;
import java.net.*;
import java.util.*;

public class _5_UDP_S {

  public static void main(String[] args) {
    try(
            DatagramSocket socket = new DatagramSocket(8000)
            // port: specify local port, listen own port to receive
    ) {
      // 0. Initialize buffer
      byte[] buf = new byte[256];
      // 1
      DatagramPacket receivePacket = new DatagramPacket(buf, buf.length);

      while (true) { // loop to send & receive
        Arrays.fill(buf, (byte) 0);// 0. Initialize buffer for each iteration
        // receive steps:-----------------------------------------
        //  0. init buf
        //  1. init packet with buf & len
        //  2. use socket to receive, data fill in a DatagramPacket
        socket.receive(receivePacket); // 2

        //how get received data from packet (2-way) ?
        String str = new String(buf); // use buf directly
        str = new String(receivePacket.getData() , 0, receivePacket.getLength());
        // 由于接受前将buf清0，因此可以直接用buf创造string
        // 若没有清0，需要根据 receivePacket.getLength()
        // （此长度为UDP中数据的长度，而非buffer的容量

        double radius = Double.parseDouble(str.trim());
        System.out.println("receive: " + radius + '\n');
        double area = radius * radius * Math.PI;

        // Send:----------------------------------------
        // port: need other's add + port, S get add of C from received packet
        DatagramPacket sendPacket = new DatagramPacket(buf, buf.length);
        sendPacket.setData(Double.valueOf(area).toString().getBytes());
        sendPacket.setAddress(receivePacket.getAddress());  //
        sendPacket.setPort(receivePacket.getPort());
        socket.send(sendPacket);
      }
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}
