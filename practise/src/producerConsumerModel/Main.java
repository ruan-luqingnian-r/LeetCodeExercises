package producerConsumerModel;

/**
 * @Author: ruan
 * Date: 2021/9/8 15:08
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Product product = new Product();
        ProducerThread producerThread = new ProducerThread(product);
        ConsumerThread customerThread = new ConsumerThread(product);
        producerThread.setName("生产者线程");
        customerThread.setName("消费者线程");
        customerThread.start();
        producerThread.start();
    }
}
