package _8_nw;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
/** n*client 发送一个数， server 接收后回复其负数
 * 三个程序逐步并行化
 * */


class Server1 {
    static int port = 10080;
    static DataOutputStream dos;
    static DataInputStream dis;
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        try
        {
            serverSocket = new ServerSocket(port);
            while(true) {
                socket = serverSocket.accept();
                System.out.println("request from: " + socket.getPort());

                dis = new DataInputStream(socket.getInputStream());
                dos = new DataOutputStream(socket.getOutputStream());

                double d = dis.readDouble();
                System.out.println("receive " + d + "from client " + socket.getPort());
                d *= -1;
                dos.writeDouble(d);
                System.out.println("sent to client " + d);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                serverSocket.close();
                socket.close();
                dis.close();
                dos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class Client1{
    static int port = 10080;
    public static void main(String[] args) {
        try (

            Socket socket = new Socket("127.0.0.1", 10080);

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        ){
            double d = new Scanner(System.in).nextDouble();
            System.out.println("my port: " + socket.getLocalPort());
            dos.writeDouble(d);
            d =  dis.readDouble();
            System.out.println("receive " + d + "from server " + socket.getPort());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}