package _2_reenter_ddl;

// both synchronized, lock are ReentrantLock， 递归锁

public class _1_reentrant_sync {
    public static synchronized void func(){
        func();
    }

    public static void main(String[] args) {
        Object o = new Object();
        new Thread(()->{
           synchronized (o){  // after acquire lock
               System.out.println("1");
               synchronized (o){ // acquire same lock, can enter directly
                   System.out.println("2");
               }
           }
        }).start();
    }
}
