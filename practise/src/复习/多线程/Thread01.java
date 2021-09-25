package 复习.多线程;

/**
 * @Author: ruan
 * Date: 2021/9/24 16:52
 * @Description:
 */
public class Thread01 extends Thread{
    @Override
    public void run() {
        System.out.println("继承Thread创建线程");
    }
}
