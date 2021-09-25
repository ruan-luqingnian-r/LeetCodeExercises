/**
 * @Author: ruan
 * Date: 2021/9/25 15:50
 * @Description: 不可重入锁
 */
public class MyUnReentrantLock {
    private boolean isLock = false;

    public void lock(){
        System.out.println("开始加锁");
        while (isLock){
            System.out.println("已经被锁进入等待时间");
        }
        isLock = true;
        System.out.println("加锁成功");
    }

    public void unLock(){
        isLock = false;
        System.out.println("解锁成功");
        notify();
    }
}
