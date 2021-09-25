import java.util.Date;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: ruan
 * Date: 2021/9/22 18:36
 * @Description:
 */
public class UnsafeThread {
    private static AtomicInteger num;
    private static CountDownLatch countDownLatch = new CountDownLatch(10);
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int j = 0; j < 100; j++) {
                    add();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                countDownLatch.countDown();
            }).start();
        }
        while (true){
            if (countDownLatch.getCount() == 0){
                System.out.println(num);
                break;
            }
        }
    }
    public static void add(){
        num.incrementAndGet();
    }
}
