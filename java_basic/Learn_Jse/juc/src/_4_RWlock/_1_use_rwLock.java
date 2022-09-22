package _4_RWlock;

import java.util.HashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyHashMap{
    HashMap<String, String> hashMap = new HashMap<>();

    // rw lock
    //      to avoid: write --  read -- write finish
    ReadWriteLock lock = new ReentrantReadWriteLock();

    // read
    String get(String key){
        String res = null;
        try {
            lock.readLock().lock();

            System.out.println("read " + key);
            res = hashMap.get(key);
            Thread.sleep(1000);
            System.out.println("finish read " + key);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
        return res;
    }

    // write
    void put(String key, String value){
        try {
            lock.writeLock().lock();

            System.out.println("write " + key);
            hashMap.put(key, value);
            Thread.sleep(1000);
            System.out.println("finish write " + key);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }
}

public class _1_use_rwLock {
    public static void main(String[] args) throws InterruptedException {
        MyHashMap hashMap = new MyHashMap();

        // write
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(()->{
                hashMap.put("k" + finalI, "v" + finalI);
            }).start();
        }

        // read
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(()->{
                hashMap.get("k" + finalI);
            }).start();
        }
    }
}
