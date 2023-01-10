package Tmp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Arrays;


class Client_{
    static DatagramSocket datagramSocket;
    static DatagramPacket sendPacket;
    static DatagramPacket recvPacket;
    static byte[] buf = new byte[1024];
    static int port = 8000;

    public static void main(String[] args) {
        try {
            datagramSocket = new DatagramSocket();
            // send
            sendPacket = new DatagramPacket(buf, buf.length);
            sendPacket.setData("123".getBytes());
            sendPacket.setAddress(InetAddress.getByName("localhost"));
            sendPacket.setPort(port);
            datagramSocket.send(sendPacket);
            // receive
            recvPacket = new DatagramPacket(buf, buf.length);
            datagramSocket.receive(recvPacket);
            System.out.println(new String(recvPacket.getData()));
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            datagramSocket.close();
        }
    }

}

class Server_{
    static DatagramSocket datagramSocket;
    static DatagramPacket datagramPacket;
    static byte[] buf = new byte[1024];
    static int port = 8000;

    public static void main(String[] args) {
        try {
            datagramSocket = new DatagramSocket(port);
            datagramPacket = new DatagramPacket(buf, buf.length);
            //receive
            datagramSocket.receive(datagramPacket);
            int data = Integer.parseInt(new String(buf).trim());
            System.out.println("receive" + data);
            //send
            InetAddress address = datagramPacket.getAddress();
            datagramPacket.setData((-data + "").getBytes());
            datagramPacket.setAddress(InetAddress.getByName(address.getHostAddress()));
            datagramSocket.send(datagramPacket);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            datagramSocket.close();
        }
    }

}