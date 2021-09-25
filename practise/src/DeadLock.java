import java.util.Objects;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: ruan
 * Date: 2021/9/25 15:32
 * @Description:
 */
public class DeadLock {
    private static final String lockA = "A";
    private static final String lockB = "B";

    public static void methodA(){
        synchronized (lockA){
            System.out.println("我是A方法，获得锁A" + Thread.currentThread().getName());
            //释放cpu资源但不释放锁
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        synchronized (lockB){
            System.out.println("我是A方法，获得锁B" + Thread.currentThread().getName());
        }
    }

    public static void methodB(){
        synchronized (lockB) {
            System.out.println("我是B方法，获得锁B" + Thread.currentThread().getName());
            //释放cpu资源但不释放锁
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        synchronized (lockA){
            System.out.println("我是B方法，获得锁A" + Thread.currentThread().getName());
        }

    }

    public static void main(String[] args) {
        System.out.println("主线程运行开始" + Thread.currentThread().getName());
        Thread thread = new Thread(() -> {
            methodA();
        });
        Thread thread1 = new Thread(() -> {
            methodB();
        });
        thread.setName("线程A");
        thread1.setName("线程B");
        thread.start();
        thread1.start();
        System.out.println("主线程运行结束" + Thread.currentThread().getName());
    }


}
