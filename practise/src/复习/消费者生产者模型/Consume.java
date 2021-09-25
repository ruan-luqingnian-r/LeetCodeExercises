package 复习.消费者生产者模型;

/**
 * @Author: ruan
 * Date: 2021/9/25 11:01
 * @Description:
 */
public class Consume implements Runnable {
    private Storage storage;
    public Consume(){}
    public Consume(Storage storage){
        this.storage = storage;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            storage.consume();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
