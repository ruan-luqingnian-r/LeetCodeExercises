import java.io.Serializable;

/**
 * @Author: ruan
 * Date: 2021/9/14 19:17
 * @Description: 手写简单的ArrayList
 */
public class MyArrayList implements Serializable {
    /**
     * 用于并发判断
     * 使用迭代器的fail-fast机制
     */
    private transient int modCount = 0;

    /**
     * 第一次扩容默认的扩容容量默认为10
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 初始默认的空数组
     */
    private static final Object[] EMPTY_ELEMENT_DATA = {};

    /**
     * 实际存储的数据的数组并且无法被序列化
     */
    transient Object[] elementDate;

    /**
     * 实际的list集合容量大小
     */
    private int size;

    /**
     * 空参构造函数
     */
    public MyArrayList(){
        this.elementDate = EMPTY_ELEMENT_DATA;
    }

    /**
     * 有参构造函数
     * @param initialCapacity 指定容量
     */
    public MyArrayList(int initialCapacity){
        if(initialCapacity == 0){
            this.elementDate = EMPTY_ELEMENT_DATA;
        }else if (initialCapacity > 0){
            this.elementDate = new Object[initialCapacity];
        }else {
            throw new IllegalArgumentException("参数异常");
        }
    }
}
