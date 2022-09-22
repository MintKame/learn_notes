package _5_helper_cls;

import java.util.concurrent.Semaphore;

public class _3_semaphore {
    // see eg in _1_1, _1_2
    public static void main(String[] args) {
        // 多人使用3根笔
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    Thread.sleep(2000);
                    System.out.println("take: " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    System.out.println("release: " + Thread.currentThread().getName());
                    semaphore.release();
                }
            }, "t" + String.valueOf(i)).start();
        }
    }
}
