package _7_io._2_decorater;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class _5_1_obj_io {

  public static void main(String[] args) throws IOException {

    //obj can used to trans in a pipe (IPC)

    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("5cmp_o.bin"));
    DataOutputStream dos = new DataOutputStream(new FileOutputStream("5cmp_d.bin"));
    // ObjI/O can read/write: primitive & string & obj, so can replace DataIO
    // diff: obj-io wirte / read type && data;
    //       other-io just write data

    oos.writeInt(123); // content: AC ED 00 05 77 04 00 00 00 7B (int 123 larger size
    dos.writeInt(123);// content: 00 00 00 7B (123
    // int -> Integer ( implements Serializable

    //how write, read an arr ?
    oos.writeObject(new int[]{1,2});
    //  arr is an obj
    //  must: each elem serializable

    oos.close();
    dos.close();

    //! write obj （type && data(serialize 序列化)） =========================================================
    ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream("5o.bin"));
    sCls o1 = new sCls();
    sCls o2 = new sCls();

    //              bytes inc?  write what
    oo.writeObject(o1); //+68   cls msg + obj msg (include serial num)
    oo.writeObject(o2); //+11   obj msg(include serial num)
    oo.writeObject(o2); //+5    serial num

    oo.close();
    //! read obj （ type && data(deserialize 反序列化)）   =========================================================
    // must: same order as 序列化
    //       必须 objOut 和 objIn 同一个obj，因为存obj时存入了包名
    ObjectInputStream oi = new ObjectInputStream(new FileInputStream("5o.bin"));
    try {
      // need cast after read
      sCls date = (sCls) (oi.readObject());
    } catch (ClassNotFoundException e) {    //checked ex
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    oi.close();
  }
}

