package producerConsumerModel;

/**
 * @Author: ruan
 * Date: 2021/9/8 15:01
 * @Description: 消费者线程
 */
public class ConsumerThread extends Thread {
    /**
     * 共享商品
     */
    private Product product;

    public ConsumerThread(Product product){
        this.product = product;
    }

    @Override
    public void run() {
        //如果没有商品则进入阻塞队列
        if (!product.isFlag()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("消费者消费了：" + product.getBrand() + "---" + product.getName());
            product.setFlag(false);
            notify();
        }
    }
}
