package 复习.多线程;

import java.util.concurrent.Callable;

/**
 * @Author: ruan
 * Date: 2021/9/24 17:06
 * @Description:
 */
public class Thread04 implements Callable<Object> {
    @Override
    public Object call() throws Exception {
        System.out.println("实现Callable接口创建线程，有返回值");
        return "返回值";
    }
}
