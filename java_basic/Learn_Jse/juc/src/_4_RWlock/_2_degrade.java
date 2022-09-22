package _4_RWlock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class _2_degrade {
    public static void main(String[] args) {
        ReadWriteLock lock = new ReentrantReadWriteLock();
        lock.writeLock().lock();
        System.out.println("write");

        lock.readLock().lock();
        System.out.println("read");

        lock.writeLock().unlock();// 降级
    }
}
