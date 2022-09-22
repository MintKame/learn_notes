package _0_2_methods;

public class _1_status {
    public static void main(String[] args) throws InterruptedException {
        //here, we 're in the main Thread ( 1st start, last terminate )

        Thread.State state = Thread.State.WAITING;
        //what does state change when methods invoked ?
        //ans:  see img.png.

        //! 1. t's state ? --------------------------------------
        // what's needed to ctrl a thread in another ?
        // the ref, how get ?
        //  a. get self thread
        Thread.currentThread();
        //  b. others (by: create / pass to methods)
        Thread t = new Thread();    // status: new

        t.start();                  // runnable(ready)

        // jvm invoke: t.run();     // runnable(running)

        t.interrupt();
        //  ready, running         ->  (set interrupt flag)
        //  blocked (sleep, wait)  -> ready (throws InterruptedEx)

        //! 2. current(main) state ? ------------------------------
        Thread.yield();             // running -> ready
        //  telling scheduler tmp release cpu (but scheduler can ignore)
        //  to avoid over-use CPU

        Thread.sleep(1);      // running -> time-wait

        // 线程插队：先执行完 t
        t.join();                   // running -> wait
        t.join(1);            // running -> time-wait

        // lock is similar as synchronized
        Object obj = new Object();
        synchronized (_1_status.class){ // running -> block (if lock not available)
            obj.wait();                 // running -> wait  (tmp release lock on _1_status.class
//            obj.wait(1);              // running -> time-wait
            // ......
            obj.notify();               // other threads wait for obj: (time)wait -> ready
        }

        t.isAlive();
        // not in state: new / terminated
    }
}

