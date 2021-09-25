package 复习.消费者生产者模型.阻塞队列;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Author: ruan
 * Date: 2021/9/25 17:56
 * @Description:
 */
public class Main {


    public static void main(String[] args) throws InterruptedException {
        /**
         * 创建阻塞队列
         */
        BlockingQueue<String> queue = new LinkedBlockingDeque<>(10);

        /**
         * 创建生产者和消费者
         */
        Producer producer1 = new Producer(queue);
        Producer producer2 = new Producer(queue);
        Producer producer3 = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        /**
         * 创建线程
         */
        ExecutorService service = Executors.newCachedThreadPool();

        service.execute(producer1);
        service.execute(producer2);
        service.execute(producer3);
        service.execute(consumer);
        Thread.sleep(10000);
        //停止生产
        producer1.stop();
        producer2.stop();
        producer3.stop();
        Thread.sleep(2000);
        service.shutdown();
    }
}
