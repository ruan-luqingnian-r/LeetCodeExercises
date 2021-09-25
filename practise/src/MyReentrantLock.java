/**
 * @Author: ruan
 * Date: 2021/9/25 16:00
 * @Description: 可重入锁
 */
public class MyReentrantLock {
    /**
     * 标识位---记录被锁状态
     */
    private boolean isLock = false;
    /**
     * 标识位---记录持锁线程
     */
    private Thread lockOrder = null;
    /**
     * 标识位---记录加锁次数
     */
    private int count = 0;

    public synchronized void lock() throws InterruptedException {
        System.out.println("进入Lock加锁");
        //获取当前线程
        Thread thread = Thread.currentThread();
        //判断是否是同个锁持有线程
        while (isLock && lockOrder != thread){
            System.out.println("进入等待状态-当前锁状态：" + isLock);
            wait();
        }
        //加锁
        isLock = true;
        lockOrder = thread;
        count++;
    }

    public synchronized void unLock(){
        System.out.println("进入Lock解锁");
        //获取当前线程
        Thread thread = Thread.currentThread();
        if (thread == this.lockOrder){
            count--;
            if (count == 0){
                isLock = false;
                lockOrder = null;
                notify();
            }

        }
    }
}
