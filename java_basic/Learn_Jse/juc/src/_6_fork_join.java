import java.util.Date;
import java.util.concurrent.*;


// fork: 拆分任务
// join: 合并结果
public class _6_fork_join {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int times = 10000;
        int begin = 0, end = 1000;
        long t0 = 0, t1 = 0;

        ForkJoinPool pool = new ForkJoinPool();

        t0 = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            MyRecursiveTask task0 = new MyRecursiveTask(begin, end);
            ForkJoinTask<Integer> forkJoinTask = pool.submit(task0);
//            System.out.println(forkJoinTask.get());
        }
        t1 = System.currentTimeMillis();
        System.out.println(t1 - t0);

        pool.shutdown();

        // --------------------------------------------

        ExecutorService es = Executors.newSingleThreadExecutor();

        t0 = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            MyTask task1 = new MyTask(begin, end);
            es.execute(task1);
        }
        t1 = System.currentTimeMillis();
        System.out.println(t1 - t0);

        es.shutdown();
    }
}

// sum, need (end - begin) < 10
class MyRecursiveTask extends RecursiveTask<Integer> { // result is an Integer

    int begin, end, result = 0;

    MyRecursiveTask(int begin, int end){this.begin = begin; this.end = end;}

    @Override
    protected Integer compute() {
        if (end - begin >= 10){ // fork
            int mid = (begin + end)/2;
            MyRecursiveTask left = new MyRecursiveTask(begin, mid);
            MyRecursiveTask right = new MyRecursiveTask(mid + 1, end);

            left.fork();
            right.fork();

            result = left.join() + right.join();
        }else { //compute
            for (int i = begin; i <= end; i++) {
                result += i;
            }
        }
        return result;
    }
}


class MyTask implements Runnable{
    int begin, end;

    public MyTask(int begin, int end){this.begin = begin; this.end = end;}

    @Override
    public void run() {
        sum(begin, end);
//        System.out.println();
    }

    Integer sum(int begin, int end){
        int result = 0;
        if (end - begin >= 10) { // recur
            int mid = (begin + end)/2;
            result = sum(begin, mid) + sum(mid + 1, end);
        }else {  //compute
            for (int i = begin; i <= end; i++) {
                result += i;
            }
        }
        return result;
    }
}