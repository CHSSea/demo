import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Test14 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<FutureTask<Integer>> futureTaskList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    //十秒
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        return 0;
                    }
                    return finalI;
                }
            });
            futureTaskList.add(futureTask);
            executorService.submit(futureTask);
        }
        new Thread(() -> {
            try {
                for (FutureTask<Integer> futureTask : futureTaskList) {
                    System.out.println(futureTask.get());
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }, "监视线程").start();

        executorService.shutdown();
    }
}
