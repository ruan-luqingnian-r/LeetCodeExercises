package 复习.消费者生产者模型;

import java.util.LinkedList;

/**
 * @Author: ruan
 * Date: 2021/9/24 20:34
 * @Description: 生产者消费者模型---产品仓库
 */
public class Storage {
    //仓库容量
    private final int MAX_SIZE = 10;
    //仓库载体
    private LinkedList<Object> list = new LinkedList<>();

    /**
     * 生产
     */
    public void produce(){
        synchronized (list){
            while (list.size() + 1 > MAX_SIZE){
                System.out.println("【生产者" + Thread.currentThread().getName() + "】仓库已满");
                try {
                    //生产者线程暂停
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(new Object());
            System.out.println("【生产者" + Thread.currentThread().getName() + "】生产一个产品，现库存" + list.size());
            //通知消费者线程进行消费
            list.notifyAll();
        }

    }

    /**
     * 消费
     */
    public void consume(){
        synchronized (list){
            while (list.size() == 0){
                System.out.println("【消费者" + Thread.currentThread().getName() + "】仓库为空");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.remove();
            System.out.println("【消费者" + Thread.currentThread().getName() + "】消费一个产品，现库存" + list.size());
            list.notifyAll();
        }
    }
}
