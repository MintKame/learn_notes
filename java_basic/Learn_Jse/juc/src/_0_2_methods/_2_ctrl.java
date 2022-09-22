package _0_2_methods;

public class _2_ctrl {

  static class R3 implements Runnable{
    public void run() {System.out.println("runnable 3");}
  }

  public static void main(String[] args) {


    Thread aThread = new Thread(new R3());

    //----------------------------------------------------------------
    //what schedule policy ?
    //    diff prior -> h to l;
    //    same prior -> RR

    //how to avoid starve ?
    //  higher_thread call sleep/yield

    //how num present priority in linux & java ?
    //  num++, pr-- | num++, pr--; 
    aThread.setPriority(0); 
    aThread.getPriority();    
    //what's the const of priority ?
    //  MAX_PRIORITY | MIN_PRIORITY | NORM_PRIORITY (10, 1, 5)

    //why recommend use const ?
    //  num maybe change

    //what's default prior ?
    //  inherit which spawn it,
    //  main thread is NORM_PRIORITY

    //----------------------------------------------------------------
    // 2 type:     daemon thread      |   user thread
    //              (守护线程)eg. gc   | main thread, user defined thread
    // when end?   no user threads    | finish all tasks / be notified
    Thread daemon = new Thread(
      ()-> {
        while (true) {
          System.out.println("hello");
          try {
            Thread.sleep(100);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      });
    daemon.setDaemon(true); // must set bf start
    daemon.start();
    //----------------------------------------------------------------
    //sth outdated:
    //a. group - replaced by pool
    ThreadGroup tg = new ThreadGroup("group name");
    Thread tInG = new Thread(tg, "thread name");
    tg.activeCount();   //estimate how many in group
    //b.
    aThread.stop();
    aThread.suspend();
    aThread.resume(); 
  }
}
