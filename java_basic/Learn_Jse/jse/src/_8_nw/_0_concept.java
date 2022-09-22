package _8_nw;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
/*  what should know to communicate ?
   addr: domain name / ip(v4 / v6)
   rule:
     (low lv)   IP
     (high lv) socket         trans        character
        TCP  ServerSo + So   stream       point to point | reliable | in order
        UDP  DataGramSo      packet       connect-less   | fast     | change order
*/

public class _0_concept {
    public static void main(String[] args) throws IOException {
        // create inet
        InetAddress ip0 = InetAddress.getByName("localhost"); //static methods
        ip0 = InetAddress.getLocalHost();

        // create socket: str / INetAddress + port
        //  port: 1-65535 (0-1023 have default)
        Socket s0 = new Socket("localhost", 10080);
        Socket s1 = new Socket("127.0.0.1", 10080);
        Socket s2 = new Socket(ip0, 10080);

        // get socket's msg
        System.out.println(s1.getLocalSocketAddress()); // self
        System.out.println(s1.getLocalAddress());
        System.out.println(s1.getLocalPort());

        System.out.println(s1.getRemoteSocketAddress()); // the other
        System.out.println(s1.getInetAddress());
        System.out.println(s1.getPort());

        //2. get stream ?
        DataInputStream dis1 = new DataInputStream(s0.getInputStream());

        //4. close stream && socket
        dis1.close();
        s0.close();
        s1.close();
        s2.close();
    }
}
