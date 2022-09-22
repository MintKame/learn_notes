package _0_1_create;

import java.io.IOException;

public class _2_eg_wrong {
  public static void main(String args[]) throws IOException {
    new test1();
    new test2();
  }
}

//why test 1, 2 wrong ?
class test1 implements Runnable{
  public test1() {
    new Thread(new test1()).start();
  }
  @Override
  public void run() {
    System.out.println("test 1");
  }  
}

class test2 implements Runnable{
  public test2() {
    Thread t = new Thread(this);
    t.start();
    t.start();
  }
  @Override
  public void run() {
    System.out.println("test 2");
  }
}
//1. create self obj in ctor -> recur create -> Overflow

//2. start a thread twice -> IllegalThreadState
//how to do same thing twice ?
//  use 2 thread, passing same Runnable