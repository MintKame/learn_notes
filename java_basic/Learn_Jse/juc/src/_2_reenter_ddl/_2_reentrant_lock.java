package _2_reenter_ddl;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class _2_reentrant_lock {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        new Thread(()->{
            try {
                lock.lock();// after acquire lock
                System.out.println("1");
                try {
                    lock.lock(); // acquire same lock, can enter directly
                    System.out.println("2");
                }finally {
                    lock.unlock(); // must
                }
            }finally {
                lock.unlock();
            }
        }).start();
    }
}
