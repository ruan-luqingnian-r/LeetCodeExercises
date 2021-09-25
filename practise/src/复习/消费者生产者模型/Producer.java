package 复习.消费者生产者模型;

/**
 * @Author: ruan
 * Date: 2021/9/24 20:48
 * @Description: 生产者线程
 */
public class Producer implements Runnable {
    private Storage storage;

    public Producer(){}

    public Producer(Storage storage){
        this.storage = storage;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
                storage.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
