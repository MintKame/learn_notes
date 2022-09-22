package _0_1_create;
import java.util.concurrent.*;

public class _4_3_pool_define {
    public static void main(String[] args) {
        // always self define thread pool:   ( same as the img
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(3);
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        RejectedExecutionHandler handler = new ThreadPoolExecutor.DiscardOldestPolicy();

          new ThreadPoolExecutor(2, 5,
                  2, TimeUnit.SECONDS, // thread in maxPool
                workQueue, threadFactory, handler);
    }
}
