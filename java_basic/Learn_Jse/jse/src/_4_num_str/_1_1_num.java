package _4_num_str;
public class _1_1_num {
  public static void main(String args[])
  {
    //some num, constant, postfix
    final int CONSTANT = 1;         //const in cpp
    long longInt = 1242_34232L;     //_ between chars -> readability
    byte byteInt = (byte)77777;     //byte 8bit -2^(7) - 2^(7)-1
    boolean isClose = true;         //int 4bytes - 32bits    

    //diff type num
    System.out.println(0B1111); //binary
    System.out.println(0765);   //octoal
    System.out.println(0Xfed);  //hex

    System.out.println(1.1D);   //double
    System.out.println(1.1F);   //float

  }
}
