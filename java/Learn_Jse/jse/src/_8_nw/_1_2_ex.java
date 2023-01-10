package _8_nw;

import java.io.IOException;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;

public class _1_2_ex {
    public static void main(String[] args) {
//what exs can be thrown ?
        //in server
        try {
            ServerSocket ss = new ServerSocket(10);
            //if port already in use
//            ss.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //in client
        try {
            Socket s = new Socket("a", 1);
        } catch (java.net.UnknownHostException e) { //can't found host
            e.printStackTrace();
        } catch (ConnectException e) {   //server is not running
            e.printStackTrace();
        } catch (IOException e) {             //socket create fail
            e.printStackTrace();
        }
    }
}


