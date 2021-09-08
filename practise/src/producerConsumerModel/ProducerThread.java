package producerConsumerModel;

/**
 * @Author: ruan
 * Date: 2021/9/8 14:46
 * @Description: 生产者线程
 */
public class ProducerThread extends Thread {
    /**
     * 共享线程
     */
    private Product product;

    public ProducerThread(Product product){
        this.product = product;
    }

    /**
     * 消费者线程
     */
    @Override
    public synchronized void run() {
        //如果缓冲区有商品
        if (product.isFlag()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果缓冲区没有商品则开始生产商品
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0){
                product.setBrand("DOVE");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                product.setName("巧克力");
            }else {
                product.setBrand("哈尔滨");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                product.setName("啤酒");
            }
            System.out.println("工厂生产了" + product.getBrand() + "---" + product.getName());
            //产品生产结束，缓冲区存在商品通知消费者线程进入消费
            product.setFlag(true);
            notify();
        }

    }
}
