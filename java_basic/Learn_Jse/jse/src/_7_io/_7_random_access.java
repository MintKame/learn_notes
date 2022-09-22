package _7_io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamConstants;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.*;

public class _7_random_access {
  
  //what can do using random_access?
  //    read / write at any location.

  public static void main(String[] args) throws IOException {

    //how to create ?
    //  file name, access mode (r/rw)
    RandomAccessFile inout = new RandomAccessFile("7ra.bin", "rw");   //not forget "File"

    //what if file not exits ?
    //  r: exception | rw: create, R/W share 1 file ptr

    //what's 2-usage of setLen() ?
    // clear the file ?
    inout.setLength(0);

    //how to append ?
    if(inout.getFilePointer() != inout.length()){
      inout.seek(inout.length());     //move ptr to eof
      inout.writeInt(999);
      //what is seek()'s para ?
      //  pos of specific byte.
    }

    for (int i = 0; i < 200; i++)
      inout.writeInt(i);

    //what happened ? what 's order of op & move ?
    inout.seek(1 * 4);             //move to 2nd num
    System.out.print(inout.readInt());  //read 2nd num, move to 3rd num
    inout.writeInt(555);             //change 3rd num, move to 4th (op -> move)
    //problem: only change, can't insert.
    //solve  : store in a tmp file
    
    //how length change ?
    inout.seek(0);
    inout.writeChar('a');
    //length not change
    //write: change n * original-data's size
        
    inout.close();

    // check whether string exists in a file
    byte[] b = new byte[200];

    try (
            RandomAccessFile ois = new RandomAccessFile("hw.bin","r");
    ){
      ois.readFully(b);
    } catch (IOException e) { }

    String str = new String(b);
    System.out.println(str.indexOf("Adam"));
    }
  }
