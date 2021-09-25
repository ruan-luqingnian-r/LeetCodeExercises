package 复习.多线程;

import java.util.concurrent.ThreadFactory;

/**
 * @Author: ruan
 * Date: 2021/9/24 16:53
 * @Description:
 */
public class Thread02 implements Runnable {

    @Override
    public void run() {
        System.out.println("实现Runnable接口创建线程");
    }
}
