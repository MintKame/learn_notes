import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Tmp {
    public static void main(String[] params) throws ExecutionException, InterruptedException {
        Runnable r = new Runnable(){
            @Override
            public void run() {
                System.out.println("run");
            }
        };
        new Thread(r).start();
//
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("call");
                return "rrr";
            }
        };

        FutureTask<String> task = new FutureTask<>(callable);

        new Thread(task).start();;
        while (!task.isDone()){

        }
        System.out.println(task.get());
    }
}
