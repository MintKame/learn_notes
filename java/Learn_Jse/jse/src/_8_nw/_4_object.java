package _8_nw;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

//how to trans obj between C/S ?

class AnObj implements Serializable {
    String str;
    int num;
    AnObj(String str_, int num_){
        str = str_;
        num = num_;
    }

    @Override
    public String toString() {
        return "AnObj{" +
                "str='" + str + '\'' +
                ", num=" + num +
                '}';
    }
}

class Client5 {
    public static void main(String[] args) {
        AnObj o = new AnObj("im client", 1024);
        try (
            Socket s = new Socket("localhost", 10001);
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream())) {
            out.writeObject(o);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Server5 {
    public static void main(String[] args) {
        try (ServerSocket ss = new ServerSocket(10001);
             Socket s = ss.accept();
             ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
        ) {
            Object o = ois.readObject();
            System.out.println((AnObj)o);
        }catch (IOException e){
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}