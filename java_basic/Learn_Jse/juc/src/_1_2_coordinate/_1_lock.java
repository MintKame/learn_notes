package _1_2_coordinate;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**  1. define resource class (attr, op) */
public class _1_lock {
  //what's usage of lock && condition ?
  //  1*lock                -> mutual access reSrc(critical section)
  //  1*lock + n*conditions -> wait for condition && tmp release lock  -> to avoid ddl

  private static int capacity = 3;
  private static int remain = 0;
  private Lock lock = new ReentrantLock();

  // condition:
  //  how to name condition ?
  //    the reSrc waited by thread.
  private Condition notEmpty = lock.newCondition();
  private Condition notFull = lock.newCondition();

  //what do a-e do ?
  // must produce when not full
  public void produce(){
    lock.lock();  /** 2a. op: lock  */

    try{ // must using try -> unlock even ex
      Thread.sleep(200);

      /** 2b. op: judge & wait   */
      while (remain == capacity){ // full
        System.out.println("producer wait not full-----");
        notFull.await();
      }

      /** 2c. op: work */
      remain++; // not full, can produce
      System.out.println("produce->\t\tremain: " + remain);
    }catch (InterruptedException ex){}
    finally {
      notEmpty.signal();        /** 2d. op: notify */
      lock.unlock();            /** 2e. op: unlock */
    }
  }
  //a.e. lock / unlock -> critical section -> mutual access -> avoid err
  //b. full -> producer wait for not full  -> tmp release lock
  //d. signal, tell other consumers not empty, so that can continue

  //why bd must surround by ae (or exception: tmp release when not have)
  //  not obtain lock, but await() try to release lock
  //  cause IllegalMonitorStateException

  //what if no: notFull.await() ?
  //  may deadlock:
  //      (producer hold lock && loop for not full)
  //      consumer can't get lock -> can't make it not full

  //what if while -> if ?
  //  errCase: a waiting thread can be signaled, but may still not enough
  //  虚假唤醒

  //why d?
  //  maybe there is consumer waiting for not empty

  public void consume(){
    lock.lock();
    try{
      while (remain == 0){
        System.out.println("consumer wait not empty");
        notEmpty.await();
      }
      remain = remain - 1;
      System.out.println("consume->\t\tremain: " + remain);
    }catch (InterruptedException ex){}
    finally {
      notFull.signal();
      lock.unlock();
    }
  }
}
