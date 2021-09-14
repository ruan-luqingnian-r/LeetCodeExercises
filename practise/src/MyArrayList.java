import java.io.Serializable;

/**
 * @Author: ruan
 * Date: 2021/9/14 19:17
 * @Description: ArrayList
 */
public class MyArrayList implements Serializable {

    /**
     * 用于判断当前集合状态是否被并发修改
     * 使用迭代器的并发修改fail-fast机制
     * transient关键词 用于非序列化
     */
    private transient int modCount = 0;
    /**
     * 第一次扩容容量
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * 用于初始化的空元素
     */
    private static final Object[] EMPTY_ELEMENT_DATA = {};
    /**
     * 实际存储的元素
     */
    transient Object[] elementData;
    /**
     * 实际存储list集合大小
     */
    private int size;
    /**
     * 空构造函数
     */
    public MyArrayList(){
        this.elementData = EMPTY_ELEMENT_DATA;
    }
    /**
     * 有参构造函数,创建初始容量
     */
    public MyArrayList(int initialCapacity){
        if (initialCapacity > 0){
            this.elementData = new Object[initialCapacity];
        }else if(initialCapacity == 0){
            this.elementData = EMPTY_ELEMENT_DATA;
        }else {
            throw new IllegalArgumentException("参数异常");
        }
    }


}
