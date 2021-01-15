import java.util.concurrent.*;

public class Test10 {

    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4,
                10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2));
        //预加载
        threadPoolExecutor.prestartAllCoreThreads();
    }
}
