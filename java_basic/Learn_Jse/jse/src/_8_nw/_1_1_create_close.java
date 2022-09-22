package _8_nw;

import java.io.IOException;
import java.net.ServerSocket;

public class _1_1_create_close {
    public static void main(String[] args) {
        // 2 - way using try:

        //!  try - catch - finally
        //  in finally, close reSrc: need handle ex caused by close()
        ServerSocket ss0 = null;
        try {
            ss0 = new ServerSocket(10000);
            //sth to do
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                ss0.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //! try with reSrc
        try(
                ServerSocket ss1 = new ServerSocket();
        ){
            //sth to do
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
