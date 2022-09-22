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
