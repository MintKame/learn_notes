package _3_collection;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

public class _2_block_queue {
    public static void main(String[] args) {

        //cls: ArrayBlockingQueue, LinkedBlockingQueue, PriorityBlockingQueue

        //para when create ?
        //  Array    capacity    (fairness)
        //  Linked  (capacity)
        //  Prior   (capacity)  [if no cap -> unbounded]
        PriorityBlockingQueue<Integer> bq = new PriorityBlockingQueue<>();

        ExecutorService es = Executors.newCachedThreadPool();
        for(int i = 0; i < 10; i++){
            es.execute(()->{
                int a = (int)(Math.random() * 100);
                bq.put(a);  //  op of queue: implement lock & condition
//                bq.take();

                // method: (see img
                //  put/take: block if
                //              put to full / take from empty
            });
        }

        es.shutdown();
        System.out.println(bq);
    }
}

