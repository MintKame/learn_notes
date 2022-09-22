package _8_nw;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/** n*client，各可发送 n个数， server 接收后， （并发）回复其负数 */

class Server3 {

    static int port = 10080;          //self port
    static ServerSocket serverSocket; //1* -> listen the port

    public static void main(String[] args) {
        try
        {
            serverSocket = new ServerSocket(port);  //init socket
            while(true){
                Thread t = new Thread(new Work(serverSocket.accept())); //to connect
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //close resrc
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //change thread -> handle n* num:
    static class Work implements Runnable{
        Socket socket = null;       //1* -> communicate (create stream)
        DataInputStream dis;        //  n ioStream
        DataOutputStream dos;
        Work(Socket s_){
            socket = s_;
            System.out.println("server:" + socket.getLocalSocketAddress() + " request from: " + socket.getRemoteSocketAddress());
        }
        @Override
        public void run() {
            try {
                //init ioStream
                dis = new DataInputStream(socket.getInputStream());
                dos = new DataOutputStream(socket.getOutputStream());
                //communicate (all in while)
                while (true){
                    double d = dis.readDouble();
                    System.out.println("receive " + d + " from " + socket.getRemoteSocketAddress());
                    d *= -1;
                    dos.writeDouble(d);
                    System.out.println("sent "  + d + " to " + socket.getRemoteSocketAddress());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {  //close
                try {
                    socket.close();
                    dis.close();
                    dos.close();
                } catch (IOException e) {}
            }
        }
    }

}

class Client3{
    static int port = 10080;          //target's port
    static DataInputStream dis;       //1* -> communicate (create stream)
    //  n ioStream
    static Socket socket;
    static DataOutputStream dos;
    public static void main(String[] args) {
        try (
            Socket socket = new Socket("127.0.0.1", 10080); //to connect
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        ){
            System.out.println("my port:" + socket.getLocalSocketAddress());
            //! change to send n * num
            while (true){
                System.out.println("input num: ");
                double d = new Scanner(System.in).nextDouble();
                System.out.println("sent to server " + d);
                dos.writeDouble(d);
                d =  dis.readDouble();
                System.out.println("receive from server: " + d);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}