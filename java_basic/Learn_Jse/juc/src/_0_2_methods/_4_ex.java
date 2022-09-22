package _0_2_methods;

//what methods may throw Interrupted ex ?
//  sleep, join


public class _4_ex {
  //which is problem ?
  static class Loop1 implements Runnable{
    public void run() {
      for(int i = 0; i < 3; i++) {
        try {
          System.out.println("loop1: " + i);
          Thread.sleep(10);
        } catch (InterruptedException e) {
          System.out.println("interrupt ");
        }
      }
    }
  }
//  diff: try in loop | loop in try
//  if 1 throw ex, continue the loop after handle the ex

  //how solve ?
  static class Loop2 implements Runnable{
    public void run() {
      try {
        for(int i = 0; i < 3; i++) {
          System.out.println("loop2: " + i);
          Thread.sleep(10);
        }
      }catch (InterruptedException e) {
        System.out.println("interrupt ");
      }
    }
  }

  public static void main(String []args) throws InterruptedException {

    Thread t1 = new Thread(new Loop1());
    t1.start();
    t1.interrupt();
    t1.join();
    System.out.println();
    Thread t2 = new Thread(new Loop2());
    t2.start();
    t2.interrupt();
  }
}
