package 复习.消费者生产者模型;

/**
 * @Author: ruan
 * Date: 2021/9/25 11:14
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage();
        Thread p = new Thread(new Producer(storage));
        p.setName("--生产者--线程");
        Thread c = new Thread(new Consume(storage));
        c.setName("--消费者--线程");
        p.start();
        c.start();
    }
}
