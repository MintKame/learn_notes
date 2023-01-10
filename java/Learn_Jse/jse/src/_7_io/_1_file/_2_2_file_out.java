package _7_io._1_file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class _2_2_file_out {
    public static void main(String[] args) throws IOException {

        File file = new File("2_file.dat");

        if(file.exists()){
            System.out.println("already exist");
            System.exit(1);
        } // when write, create the file

        FileOutputStream fo = new FileOutputStream(file, false);
        // 2nd para:  whether append( default false, clear the file)

        // 1.write str
        fo.write("abc".getBytes());
        fo.write("abc".getBytes(), 0, 2); // ab

        // 2.write byte
        for(int i = Byte.MIN_VALUE; i <= Byte.MAX_VALUE; i++) { // -128 ~ 127
            fo.write(i);
            System.out.print(i + "\t");
        }
        // why read() use -1 as EOF ?
        // [-128, -1]  [0, 127] // java's byte
        // [128, 255]  [0, 127] // store in file / read from file

        fo.close();
    }
}
