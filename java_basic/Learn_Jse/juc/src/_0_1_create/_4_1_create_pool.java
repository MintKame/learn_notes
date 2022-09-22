package _0_1_create;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class _4_1_create_pool {
    public static void main(String[] args) {

        //what diff of 3 cls ? (type | rel | usage)
        //         a.Executor     b.ExecutorService    c.Executors
        //type         IF               IF                 CLS
        //rel       b's super       extends a           create b (factory)
        //usage   execute()    func to manage executor  create b

        ExecutorService es1 = Executors.newCachedThreadPool();
        ExecutorService es2 = Executors.newFixedThreadPool(1);
        ExecutorService es3 = Executors.newSingleThreadExecutor();  // single: 1 thread in pool
        // cache:
        //      not enough -> create
        //      idle 60s -> terminate Thread
        // fixed: para == max num of Thread
        //      Thread complete -> reuse
        //      Thread fail     -> terminate -> not enough && (< size_
        //            -> new one (if enough, not create)
        //      task wait in queue

        //how to choose ?
        // cache for many short tasks
        try {
            //how to use func in ES ?
            es1.execute(()->{}); // pass Runnable to execute()
        } finally {
            es1.shutdown();     //seldom call
            es1.shutdownNow();
            //what's diff ?
            //  both stop accept new task
            //  not allow task to complete,
        }
        es1.isShutdown();
        es1.isTerminated(); //all task
    }
}

