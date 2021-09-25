package 复习.消费者生产者模型.阻塞队列;


import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: ruan
 * Date: 2021/9/25 17:36
 * @Description: 生产者线程
 */
public class Producer implements Runnable {
    /**
     * 标识位---是否运行中
     */
    private volatile boolean isRunning = true;
    /**
     * 创建阻塞队列
     */
    private BlockingQueue<String> queue;
    /**
     * 用于记录库存量
     */
    private static AtomicInteger count = new AtomicInteger(0);

    public Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    /**
     * 构造函数
     */


    @Override
    public void run() {
        String data = null;
        Random random = new Random();
        System.out.println("生产者线程启动....");
        while (isRunning){
            try {
                System.out.println("正在生产数据...");
                Thread.sleep(random.nextInt(1000));
                data = "data" + count.incrementAndGet();
                System.out.println("将数据：" + data + "放入队列...");
                if (!queue.offer(data,2, TimeUnit.SECONDS)){
                    System.out.println("数据放入失败");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("生产者线程关闭");
            }
        }
    }

    public void stop(){
        isRunning = false;
    }
}
