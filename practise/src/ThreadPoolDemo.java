import java.util.concurrent.*;

/**
 * @Author: ruan
 * Date: 2021/9/25 18:21
 * @Description: 线程池创建线程
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        BlockingQueue<Runnable> queue = new LinkedBlockingDeque<>();
        ThreadFactory factory = Executors.defaultThreadFactory();
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(10,20,3, TimeUnit.SECONDS,queue,factory);


    }
}
