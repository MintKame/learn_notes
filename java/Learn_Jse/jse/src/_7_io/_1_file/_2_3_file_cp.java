package _7_io._1_file;

import java.io.*;

public class _2_3_file_cp {
    public static void main(String[] args) {
        File file = new File("img.png");
        File newFile = new File("img2.png");

        // make sure: input-File exit
        //            output-File not exit ( avoid discard existed content
        if (!file.exists()){
            System.exit(1);
        }
        if (newFile.exists()){
//            System.exit(1);
        }

        System.out.println("start copy");
        // 这里使用常规try, try-with-resource 见 4_2_buf_cp
        FileOutputStream fos = null;
        FileInputStream fis = null;
        try{
            fos = new FileOutputStream(newFile);
            fis = new FileInputStream(file);

            byte[] buf = new byte[1024];
            int dataLen = 0;

            while ((dataLen = fis.read(buf)) != -1){ // 读需要循环，写可以只调用一次
                fos.write(buf, 0, dataLen);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //why both io need close() ?
                fos.close();// to store in file
                fis.close();// release resource
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
