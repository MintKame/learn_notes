package Tmp;/*
 * @Author: 闫昭
 * @Date: 2020-12-23- 18:04:00
 * @LastEditors:
 * @Description:
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TCP {
    public static void main(String[] args) {
        Server server = new Server();
        System.out.println("create server");
        Client[] clients = new Client[5];
        for(Client c : clients){
            System.out.println("create client");
            c = new Client();
        }
    }
}

class Client {
    static Socket socket;
    static DataInputStream dataInputStream;
    static DataOutputStream dataOutputStream;
    static int port = 8000;
    public static void main(String[] args) {
        try {
            socket = new Socket("localhost", port);
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
                int data = (int)( Math.random() * 100);
                dataOutputStream.writeInt(data);
                System.out.println("generate: " + data + " receive: " + dataInputStream.readInt());
        }catch (IOException ex){
        }finally {
            try {
                socket.close();
            }catch (IOException ex){}
        }
    }
}

class Server{
    static ServerSocket serverSocket;
    static int port = 8000;
    static Executor executor = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        try{
            serverSocket = new ServerSocket(port);
            while (true){
                executor.execute(new Worker(serverSocket.accept()));
            }
        }catch (IOException ex){
        }finally {
            try {
                serverSocket.close();
            }catch (IOException ex){ }
        }
    }

    static class Worker implements Runnable {
        Socket socket;
        DataInputStream dataInputStream;
        DataOutputStream dataOutputStream;

        Worker(Socket socket){
            this.socket = socket;
            try {
                dataInputStream = new DataInputStream(socket.getInputStream());
                dataOutputStream = new DataOutputStream(socket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                while (true){
                    int data = dataInputStream.readInt();
                    dataOutputStream.writeInt(-1 * data);
                    System.out.println("receive: " + data);
                }
            }catch (IOException ex){
            }finally {
                try {
                    socket.close();
                    dataOutputStream.close();
                    dataInputStream.close();
                }catch (IOException ex){ }
            }
        }
    }
}