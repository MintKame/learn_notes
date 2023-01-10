package _7_io._2_decorater;

import java.io.*;

public class _6_2_buf_rw_cp {
//    升级版：
    // 读入类型为utf-8，保存类型为gbk
    public static void main(String[] args) {
        try (
                BufferedReader br =
                        new BufferedReader(new InputStreamReader(new FileInputStream("6cp.txt"), "utf-8"));
                BufferedWriter bw =
                        new BufferedWriter(new OutputStreamWriter(new FileOutputStream("6cp2.txt"), "gbk"));
        ){
            String data = "";
            while ((data = br.readLine()) != null){
               bw.write(data);
               bw.newLine();
           }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
