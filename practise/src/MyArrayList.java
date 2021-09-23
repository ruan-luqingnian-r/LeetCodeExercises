import java.io.Serializable;

/**
 * @Author: ruan
 * Date: 2021/9/14 19:17
 * @Description: 手写简单的ArrayList
 */
public class MyArrayList implements Serializable {
    /**
     * 用于并发判断
     * 使用
     */
    private transient int modCount = 0;
}
