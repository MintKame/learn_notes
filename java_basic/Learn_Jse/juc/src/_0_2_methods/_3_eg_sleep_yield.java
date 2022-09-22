package _0_2_methods;

//what yield & sleep in common ?
//  both static, call by current Thread

//what's diff ?
//  after yield() may still run

//print 20 * _
class PrintRun implements Runnable{
  public void run() {    
    for(int i = 0; i < 200; i++)
      System.out.print("_");
  }
}

//create thread(PrintRun) && print 50 -, yield each 5 times
class YThread extends Thread{
  public void run() {
    new Thread(new PrintRun()).start();

    for(int i = 0; i < 10; i++) {
      for(int j = 0; j < 5; j++) {
        System.out.print("-");        
      }
      Thread.yield();
    }
    System.out.println();
  }
}

//create thread(PrintRun) && print 50 -, sleep each 5 times
class SThread extends Thread{
  public void run() {
    new Thread(new PrintRun()).start();

    for(int i = 0; i < 10; i++) {
      for(int j = 0; j < 5; j++) {
        System.out.print("-");        
      }
      try {
        Thread.sleep(1);
      } catch (InterruptedException e) { }
    }
    System.out.println();
  }
}
public class _3_eg_sleep_yield {
  public static void main(String[] args) throws InterruptedException {
    // test 1
    YThread yThread = new YThread();
    yThread.start();
    yThread.join();
    // test 2
    new SThread().start();
  }
}
