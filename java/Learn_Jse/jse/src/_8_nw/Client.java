package _8_nw;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String fileName = "img.png";
        try (
                Socket socket = new Socket("localhost", 9999);
                BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileName));
                ByteArrayOutputStream aos = new ByteArrayOutputStream();
        ) {
            // upload
            int len = 0;
            final byte[] buf = new byte[4096];
            while ((len = bis.read(buf)) != -1){
                aos.write(buf, 0, len);
            }
            byte[] data = aos.toByteArray();
            bos.write(data);
            bos.flush();
            socket.shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
