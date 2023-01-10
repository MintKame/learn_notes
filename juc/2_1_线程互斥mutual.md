# 互斥

## 问题

```java
package _1_1_mutual;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// important: separate ADT (data & op on data) && thread
//            thread just invoke op

/** 1. mutual access (2-cases)
 *    only 1 available resource
 *    only 1 thread can access critical section
 *    (multi reSrc in 8_3
 *  */

//ADT: cls have the data & op
public class _0_problem {

  static int data = 0; // the data changed by op

  // op
  public void inc() {
    int tmp = data;
    System.out.print("+");
    data = tmp + 1;
  }

  public void dec() {
    int tmp = data;       
    System.out.print("_");
    data = tmp - 1;
  }

  //create 50-inc, 50-dec (non-static)
  void method() {
    data = 0;
    System.out.print(data + "\t");
    ExecutorService es = Executors.newCachedThreadPool();
    //execute 100 thread (50 inc, 50 dec), static depends on para
    for(int i = 0; i < 50; i++) {
        es.execute(()->inc());
        es.execute(()->dec());
    }
    //why use a, b ?
    es.shutdown();              //a
    while(!es.isTerminated());  //b
    //  if no a, CachedThreadPool -> need wait 60s for threads ends
    //  b, to make sure all thread ends before print result
    System.out.println("\t" + data);
  }

  public static void main(String[] args) {
    System.out.println("data = " + data);
    _0_problem a = new _0_problem();
    a.method();
    //result: not 0

    //what's the problem ?
    //  multi-thread call op of same obj -> race condition
    //  so, the cls -> not thread-safe
    //op: critical section

    //how to solve the problem (-> thread-safe) ?
    //  synchronize, lock, semaphore(1)
    //how to choose sync / lock ?
  }
}
```

## 1.sync方法

```java
package _1_1_mutual;
//solve 1: synchronized_methods

//where to use ?
//  to make: thread-safe cls
//  add lock to the ADT cls which is not thread-safe (not the thread !)
public class _1_syn_methods extends _0_problem {
    @Override
    public synchronized void inc() {
        super.inc();
    }

    @Override
    public synchronized void dec() {
        super.dec();
    }

    // what's locked ?
    //      this obj's (all non-static syn_method

    // if op are static, what's locked?
    //      cls  (all syn_method (all objs)
    //      note: static & non-static not share lock.

    //how to synchronize static with non-static ?
    //  use syn block / lock
    //  all synchronized on cls, not on obj;

    public static void main(String[] args) {
        _1_syn_methods a = new _1_syn_methods();
        a.method();
        //result: 0 (success)
  }
}
```

## 2.sync块

```java
package _1_1_mutual;

//solve 2: synchronized_blocks
public class _2_syn_block extends _0_problem {

  //what should pass to synchronized() ?
  //    non-static:
  //      obj's ref (this / other obj[not used])
  //
  //    static:
  //      cls / other obj[not used]
  //          _2_syn_block.class (XX is cls name)
  //          getClass()

  @Override
  public void inc() {
    synchronized(this) {
      super.inc();
    }
  }

  @Override
  public void dec() {
    synchronized(this) {
      super.dec();
    }
  }

  //what's locked ?
  //non-static: obj's all syn_block, should pass same obj (here is "this")

  //what's benefit VS sync-method  ?
  //    inc concurrency by dec critical section's field

  public static void main(String[] args) {
    new _2_syn_block().method();
  }

}
```

## 3.锁

```java
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
```

## 4.semaphore

```java
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
```

## eg

```java
package _1_1_mutual;
/**
 * @task 观察无同步情况下，存取款两个线程导致的账户余额混乱
 */
public class Demo07P111 {

  public static void main(String[] args) throws InterruptedException {

    MyAccount account = new MyAccount();

    // 创建存款和取款线程并运行
    // 观察账户余额
    Thread t1 = new Deposit(account);

    Thread t2 = new Thread(new Withdraw(account));
    System.out.println("存入\t取出\t余额");
    System.out.println("\t\t" + account.getBalance());
    // 启动线程
    t1.start();
    t2.start();
    t1.join();//等存钱线程结束后，判断取钱线程若为等待，说明存的总金额 < 取的总金额
    if(t2.getState() == Thread.State.WAITING){
      t2.interrupt();
    }
    t2.join();
  }
}

/**
 * @desc 创建一个账户类
 * @desc 有一个账户成员；
 * @desc 有一个存款函数deposit()，一个取款函数withdraw()
 */
class MyAccount {
  int balance = 0;
  public int getBalance() {
    return balance;
  }

  public void setBalance(int b) {
    balance = b;
  }

  public int deposit(int money) {
    synchronized (this){
      // 为了展示存取款线程导致的余额混乱，我们故意将存取款过程分为2步
      int newBalance = this.getBalance() + money;
      this.setBalance(newBalance);
      // 输出语句也要放到当前函数中，主要是考虑使用synchronized之后的效果
      System.out.println(money + "\t\t" + this.getBalance());
      this.notifyAll();
      return this.getBalance(); // 返回余额。该返回值可以不使用
    }
  }

  public int withdraw(int money) throws InterruptedException {
    synchronized (this){
      //金额不足则wait
      try {
        while(balance < money){
          this.wait();
        }
      }catch (InterruptedException ex){
        throw new InterruptedException("余额不足,且此时deposit已经结束");
      }
      // 为了展示存取款线程导致的余额混乱，我们故意将存取款过程分为2步
      int newBalance = this.getBalance() - money;
      this.setBalance(newBalance);
      // 输出语句也要放到当前函数中，主要是考虑使用synchronized之后的效果
      System.out.println("\t" + money + "\t" + this.getBalance());
      return this.getBalance(); // 返回余额。该返回值可以不使用
    }
  }
}

/**
 * @desc 创建一个存款线程类，继承Thread
 * @task 调用账户的存款函数，不断存款，并且输出账户余额
 */
class Deposit extends Thread {
  MyAccount account;

  public Deposit(MyAccount account) {
    this.account = account;
  }

  @Override
  public void run() {
    for (int i = 0; i < 20; i++) {
      int money = (int) (Math.random() * 10);
      account.deposit(money);
      try {
        Thread.sleep(200);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println("deposit end");
  }
}

/**
 * @desc 创建一个取款线程类，实现Runnable接口
 * @task 调用账户的取款函数，不断取款，并且输出账户余额
 */
class Withdraw implements Runnable {
  MyAccount account;

  public Withdraw(MyAccount account) {
    this.account = account;
  }

  @Override
  public void run() {
    try {
      Thread.sleep(200);
      for (int i = 0; i < 20; i++) {
        int money = (int) (Math.random() * 10);
        account.withdraw(money);
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }finally {
      System.out.println("withdraw end");
    }
  }
}
```