package 复习.消费者生产者模型.阻塞队列;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author: ruan
 * Date: 2021/9/25 17:48
 * @Description: 消费者线程
 */
public class Consumer implements Runnable {
    /**
     * 创建阻塞队列
     */
    private BlockingQueue<String> queue;
    /**
     * 构造函数
     */
    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("消费者线程启动...");
        Random random = new Random();
        boolean isRunning = true;
        while (isRunning){
            System.out.println("正在从队列中获取数据");
            try {
                String data = queue.poll(2, TimeUnit.SECONDS);
                if (null != data){
                    System.out.println("拿到数据：" + data);
                    System.out.println("正在消费数据：" + data);
                    Thread.sleep(random.nextInt(1000));
                }else {
                    //如果2s内无数据，认为生产者线程退出，消费者线程也退出
                    isRunning = false;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("消费者线程退出");
            }
        }
    }
}
