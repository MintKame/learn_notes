package _1_1_mutual;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//what's diff between lock && synchronized ?
//  type         | interface          | keyword
//  acquire lock | explicitly         | implicitly
//  ex           | must call unlock() | auto release lock

//  lock: efficent, intuitive, flexible (can use conditions)

//  lock() & unlock() surround critical-section

public class _3_lock extends _0_problem {

  //how to choose whether static lock ?
  //    static for cls, can be use for all obj
  //    non-static for 1 obj

  private Lock lock = new ReentrantLock(); // should be member of unsafe-cls, not thread !)
  //  ReentrantLock(boolean fair)
  //    T: longest-wait get   -> avoid starve, more predictable
  //    F: default, arbitrary -> high performance

  public void inc() {
    lock.lock();    // func from Lock IF
    super.inc();
    lock.unlock();
  }
  public void dec() {
    lock.lock();
    super.dec();
    lock.unlock();
  }

  //what's locked ?
  //  depends on: whether the lock is static
  //      Y: each obj have 1 lock
  //      N: all  obj use  1 lock
  public static void main(String[] args) {
    new _3_lock().method();
  }
}
