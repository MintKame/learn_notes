package _0_1_create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class _3_callable {
    public static void main(String[] args) {
        //diff: runnable    callable
        //      run()       call()
        //      no ret      have ret
        //      no ex       ex if can't calc result
        //------------------------------------
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("run");
            }
        };

        new Thread(runnable).start();
        //------------------------------------
        // 泛型：T = return type
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("call");
                return 1024;
            }
        };

        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        // FutureTask implement runnable && can pass callable to ctor

        new Thread(futureTask).start();
        //------------------------------------
        // get result of the end thread
        try {
            while (!futureTask.isDone()){
                Thread.sleep(200);
                System.out.println("wait...");
            }
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
