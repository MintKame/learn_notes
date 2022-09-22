package _5_helper_cls;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class _2_cyclicBarrier {
    public static void main(String[] args) {
        // 每3人准备好后，出发

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, ()->{
            //2. after 3 ready, execute by last thread ready
            System.out.println("take off");
        });

        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                try {
                    System.out.println("ready");
                    cyclicBarrier.await(); //1. ready, wait for others
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
