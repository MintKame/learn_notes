# coordinate



## 问题

```java
/**
 * @Author: 闫昭
 * @Date: 2020-11-08- 19:55:00
 * @LastEditors:
 * @Description:
 */
package _1_2_coordinate;
//call what in OS concept ?
//  monitor: mutex access using lock
//        && tmp release when condition not satisfied ( to avoid ddl
//  sync / lock can achieve monitor by anObj / condition

/** three. limit reSrc (2-cases)
 *         need coordinate between threads
 *
 *    1,2 lock sync
 *      access have condition
 *    3 sem
 *      only n thread can access critical section
 *          (here, the critical section is reSrc)
 *

 eg: producer - consumer (can 1 time change n)
    full / empty -> print & wait
    change buffer & print
 */

/** steps of multitask:
 * 1. define resource class (attr, op)    [ eg. 0
 * 2. op: a. lock                         [ eg. 123
 *        b. judge & wait (while)
 *        c. work
 *        d. notify
 *        e. unlock
 * 3. multitasks call op                  [ eg. 123
* */


public class _0_problem {
    public static void main(String[] args) {
        /** 3. multitasks call op */
        _1_lock buffer = new _1_lock();    // cls can be change: 1, 2, 3
        //10 consumer, 10 producer
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                buffer.consume();
            }).start();
            new Thread(() -> {
                buffer.produce();
            }).start();
        }
    }
}
```

## 1.sync块

```java
package _1_2_coordinate;

/**  1. define resource class (attr, op) */
public class _2_sync {
  private static int capacity = 3;
  private static int remain = 0;

  //how sync replace lock & condition ?
  //  1 * lock               -> sync block / method
  //  n * conditions on lock -> n * obj

  //what's methods change ?
  //  condition.await()  -> anObj.wait()
  //  condition.signal() -> anObj.notify()

  //what anObj need to be ?
  //  must same as synchronized obj ?????
  //    block  -> obj passed to "sync(objName)"  // always pass this
  //    method -> this obj

  //how to choose lock or sync ?
  //  lock: flexible

  //what's a-d 's function ?
  public void produce(){
    synchronized (this){  /** 2a. op: lock  */
      try{
        Thread.sleep(200);

        /** 2b. op: judge & wait   */
        while (remain == capacity){ // full
          System.out.println("producer = not full-----");
          this.wait();
        }

        /** 2c. op: work */
        remain++;
        System.out.println("produce->\t\tremain: " + remain);

      }catch (InterruptedException ex){}
      finally {
        this.notify();     /** 2d. op: notify */
      }
    }
  }
  //a. sync -> mutual access data -> avoid err
  //b. full -> must wait for not full -> release lock
  //d. signal waiting consumer to continue

  // note: both consume() && produce() use same obj (this)
  //       in lock, they use diff obj (2 * condition)
  // what's diff caused ?
  //    consumer can notify other consumer (but we hope to just notify producer)

  public synchronized void consume(){
    try{
      while (remain == 0){
        System.out.println("consumer = not empty-----");
        this.wait();
      }
      remain = remain - 1;
      System.out.println("consume->\t\tremain: " + remain);
    }catch (InterruptedException ex){}
    finally {
      this.notify();
    }
  }
}
```

## 2.lock

```java
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
```

## 3.semaphore

```java
package _1_2_coordinate;
import java.util.concurrent.Semaphore;

/**  1. define resource class (attr, op) */
public class _3_semaphore {
    //why use semaphore ?
    //  n * thread access critical section / reSrc can same time
    //  (n's limited)

    //what's diff from lock ?
    //  same: sem(1) == lock / synchronized
    //        sem(n) == condition + cnter

    private static Semaphore available = new Semaphore(3);
    private static Semaphore occupied = new Semaphore(0); //nothing in buffer.
    private static Semaphore mutex = new Semaphore(1);

    //what's passed as para ?
    //  1. how many remain now
    //      <= 0 -> thread coordinate (must release before acquire)
    //      > 0  -> limit resource
    //      1    -> as a lock
    //  2. is fair (default: F)

    private static int remain = 0;

    //how to use them in producer & consumer ?
    //  producer: available++, occupied--
    //  consumer: occupied++,  available--
    public void produce(){
        try{
            available.acquire();
            mutex.acquire();
            //why need semaphore "mutex" ? ------------
            //  to mutually access "remain" (like a lock)
            remain++;
            System.out.println("produce->\t\tremain: " + remain);
            Thread.sleep(200);
        }
        //what methods can cause ex ?
        //  which need thread to stop for a while.: sleep, join
        catch (InterruptedException ex){}
        finally {
            mutex.release();
            occupied.release(); //! always release in finally
        }
    }

    public synchronized void consume(){
        try{
            occupied.acquire();
            mutex.acquire();

            remain--;
            System.out.println("consume->\t\tremain: " + remain);
        }catch (InterruptedException ex){}
        finally {
            mutex.release();
            available.release();
        }
    }
}
```

## 4.eg

```java
package _1_2_coordinate;

// require:
//      in order print A, B, C

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

enum Alpa{
    A, B, C
}

class Printer{

    Alpa flag = Alpa.A; // 接下来 print 哪个字母

    Lock lock = new ReentrantLock();

    Condition finishA = lock.newCondition();
    Condition finishB = lock.newCondition();
    Condition finishC = lock.newCondition();

    public void printA(){
        try {
            lock.lock();

            while (flag != Alpa.A) // 接下来 print 非A
                finishC.await(); // 等待打印完C

            System.out.println("A");
            flag = Alpa.B; // 下一个打印B

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            finishA.signalAll();
            lock.unlock();
        }
    }

    public void printB() {
        try {
            lock.lock();

            while (flag != Alpa.B)
                finishC.await();

            System.out.println("B");
            flag = Alpa.C;

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            finishA.signalAll();

            lock.unlock();
        }
    }

    public void printC(){
        try {
            lock.lock();

            while (flag != Alpa.C)
                finishC.await();

            System.out.println("C");
            flag = Alpa.A;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            finishA.signalAll();

            lock.unlock();
        }
    }
}

public class _4_eg {
    public static void main(String[] args) {
        Printer printer = new Printer();

        for (int i = 0; i < 5; i++) {
            new Thread(()-> printer.printA()).start();
            new Thread(()-> printer.printB()).start();
            new Thread(()-> printer.printC()).start();
        }
    }
}
```