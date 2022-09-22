package _1_1_mutual;
import java.util.concurrent.Semaphore;

//solve 4: semaphore(para: 1)
public class _4_semaphore extends _0_problem {

  Semaphore sp = new Semaphore(1);

  //what should do in try ?
  //  always release() in finally
  public void inc() {
    try {
      sp.acquire();
      super.inc();  //
    } catch (InterruptedException e) { }
    finally {
      sp.release();
    }
  }
  public void dec() {
    try {
      sp.acquire();
      super.dec();  //
    } catch (InterruptedException e) { }
    finally {
      sp.release();
    }
  }

  public static void main(String[] args) {
    new _4_semaphore().method();
  }
}
