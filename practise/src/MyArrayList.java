import java.io.Serializable;

/**
 * @Author: ruan
 * Date: 2021/9/14 19:17
 * @Description: ArrayList
 */
public class MyArrayList implements Serializable {
    /**
     * 用于并发判断判断是否是当前集合
     * 如果不是当前集合，使用迭代器并发修改的fail-fast
     */
    private final int modCount = 0;
    /**
     * 第一次扩容的默认容量
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * 集合大小
     */
    private int size;
    /**
     * 默认初始化的数值
     */
    private static final Object[] EMPTY_ELEMENT_DATA = {};

    /**
     * 实际存储的数组
     * transient使其无法被序列化
     */
    transient Object[] elementDate;

    /**
     * 空参构造方法
     */
    public MyArrayList(){
        this.elementDate = EMPTY_ELEMENT_DATA;
    }

    /**
     * 有参构造方法
     * @param initialCapacity 指定的初始容量
     */
    public MyArrayList(int initialCapacity){
        if(initialCapacity == 0){
            this.elementDate = EMPTY_ELEMENT_DATA;
        }else if (initialCapacity > 0){
            this.elementDate = new Object[initialCapacity];
        }else {
            throw new IllegalArgumentException("参数异常，无法创建小于零的数组");
        }
    }


}
