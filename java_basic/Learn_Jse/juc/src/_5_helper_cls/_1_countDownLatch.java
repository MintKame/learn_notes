package _5_helper_cls;


import java.util.concurrent.CountDownLatch;

public class _1_countDownLatch {
    public static void main(String[] args) {
        // 3人离开后，关门
        CountDownLatch countDownLatch = new CountDownLatch(3);

        new Thread(()->{
            try {
                countDownLatch.await();  // 2.block until count == 0
                System.out.println("close");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        for (int i = 0; i < 3; i++) {
            new Thread(()->{
                System.out.println("leave");
                countDownLatch.countDown();  // 1.count --
                // min = 0, even cnt > 3 times
            }).start();
        }
    }
}
