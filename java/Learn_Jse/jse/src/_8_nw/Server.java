package _8_nw;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (
                ServerSocket serverSocket = new ServerSocket(9999);
                Socket socket = serverSocket.accept();
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("aaa.png"));
                BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
                ByteArrayOutputStream aos = new ByteArrayOutputStream();
        ) {
            // download
            int len = 0;
            final byte[] buf = new byte[1024];
            while ((len = bis.read(buf)) != -1){
                aos.write(buf, 0, len);
            }
            bos.write(aos.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
