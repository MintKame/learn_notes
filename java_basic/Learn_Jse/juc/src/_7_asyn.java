import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class _7_asyn {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // asyn, no return
        CompletableFuture<Void> completableFuture1 = CompletableFuture.runAsync(()->{
            System.out.println("1");
        });

        completableFuture1.get();

        // asyn, with return
        CompletableFuture<Integer> completableFuture2 = CompletableFuture.supplyAsync(()->{
            System.out.println("2");
            return 1024;
        });

        completableFuture2.whenComplete((t, u)->{
            System.out.println("t: " + t);  // result
            System.out.println("u: " + u);  // ex
        }).get();
    }
}
