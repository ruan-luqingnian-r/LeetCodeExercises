package 复习.多线程;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: ruan
 * Date: 2021/9/24 16:51
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Thread01 thread01 = new Thread01();
        Thread02 thread = new Thread02();
        Thread thread02 = new Thread(thread);
        thread01.start();
        thread02.start();
        Thread thread03 = new Thread(()->{
            System.out.println("使用lanmbda表创建线程");
        });
        thread03.start();
        Thread04 thread4 = new Thread04();
        FutureTask<Object> futureTask = new FutureTask<>(thread4);
        Thread thread04 = new Thread(futureTask);
        thread04.start();

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(thread02);
        executorService.shutdown();


    }
}
