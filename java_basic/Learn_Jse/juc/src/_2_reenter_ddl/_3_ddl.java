package _2_reenter_ddl;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//when can cause deadlock ?
//  2 thread wait for the other
//how to avoid ?
//  acquire resource in order
public class _3_ddl {
    public static void main(String[] args) {
        // check ddl ?
        // in terminal:
        //      1. jps: get java process
        //      2. jstack pid: jvm get stack info of threads
        Lock a = new ReentrantLock(),
                b = new ReentrantLock();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    a.lock();
                    System.out.println("t1 get a");
                    Thread.sleep(1000);
                    b.lock();
                    System.out.println("t1 get b");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    b.unlock();
                    a.unlock();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    b.lock();
                    System.out.println("t2 get b");
                    Thread.sleep(1000);
                    a.lock();
                    System.out.println("t2 get a");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    a.unlock();
                    b.unlock();
                }
            }
        }).start();
    }
}
