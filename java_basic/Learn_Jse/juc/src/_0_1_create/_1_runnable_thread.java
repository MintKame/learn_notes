package _0_1_create;
//what's Thread & Runnable rel ?
//  T implements R
//  T may has a R

//how to use thread to do sth (2-ways) ? 
//
//1. define runnable R1
class R1 implements Runnable{
  @Override
  public void run() {
    System.out.println("runnable 1");
  }
}

//2. define a customized thread T2
class T1 extends Thread{
  @Override 
  public void run() {    
    System.out.println("thread 2");
  }
}

public class _1_runnable_thread {
  public static void main(String[] args) {
    Thread a = new Thread(new R1()); // 1
    a.start(); // "runnable 1"

    Thread b = new T1(); // 2
    b.start(); // "thread 2"

    //why recommend 1 ?
    //    T mix task & thread
    //        1 解耦，Runnable 中 定义task，Thread 中执行
    //        2 Thread 既包含了 task定义，又是执行单位
    //    R can multi-inherit
    //    R flexible & applicable适用 to high-level thread-manage-API

    //what happen after call start() ?
    //  start() tell JVM the thread's ready
    //  after scheduled, JVM invoke thread's run()
    //  in thread's run() may:
    //        a. invoke Runnable's run() [default, eg 1]
    //        b. do sth defined in Override run()  [if customize Thread, eg 2]

    //what happen if call Runnable's run() ?
    //    run in the thread where call it, not run in new Thread
    //    so, we just override run(), and call thread.start(). not call Runnable's run()
    // -----------------------------------------------------------------

    //what do the following do ?
    //3.
    new Thread() {
      public void run() { System.out.println("thread 3"); }
    }.start();

    //4.
    new Thread(()-> System.out.println("runnable 4")).start();

    //5.
    new Thread(new Runnable() {
      public void run() { System.out.println("runnable 5"); }
    }).start();

    //3: define & create anony-sub of Thread
    //4 & 5: define & create anony-sub of Runnable, pass to Thread
  }
}
