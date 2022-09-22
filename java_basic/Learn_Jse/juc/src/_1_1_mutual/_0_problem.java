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

