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
