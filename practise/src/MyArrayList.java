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
    private transient int modCount = 0;
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

    /**
     * 检查下标索引是否越界
     * @param index 索引
     */
    private void rangeCheck(int index){
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("索引越界");
        }
    }

    /**
     * 扩容机制
     * @param minimumCapacity 最小容量
     */
    private void ensureCapacityInternal(int minimumCapacity){
        //初次扩容直接直接使用默认容量10
        if(elementDate == EMPTY_ELEMENT_DATA){
            minimumCapacity = Math.max(minimumCapacity,DEFAULT_CAPACITY);
        }
        //如果不是第一次扩容则需要判断是否需要扩容
        if (minimumCapacity - elementDate.length > 0){
            //最小容量大于当前数组容量，需要扩容，扩容大小为之前容量的1.5倍
            int oldCapacity = elementDate.length;
            int newCapacity = oldCapacity + (oldCapacity >> 2);
            //如果扩容后的新容量还是小于最小容量则将最小容量直接赋给新容量
            if (newCapacity - minimumCapacity < 0){
                newCapacity = minimumCapacity;
            }
            //创建一个最新容量的数组
            Object[] objects = new Object[newCapacity];
            //将旧数组的数据拷贝到新数组中
            System.arraycopy(elementDate,0,objects,0,elementDate.length);
            //修改老数组的引用
            elementDate = objects;
        }
    }

    /**
     * 写入数据
     * @param o 数据
     */
    public boolean add(Object o){
        //用于并发判断
        modCount++;
        //确保容量
        ensureCapacityInternal(size + 1);
        //下标写入
        elementDate[size++] = o;
        return true;
    }

    /**
     * 根据索引获取数据
     * @param index 索引
     * @return 数据
     */
    public Object get(int index){
        //检查索引
        rangeCheck(index);
        //根据下标获取数据
        return elementDate[index];
    }

    /**
     * 判断对象的位置
     * @param o 对象
     * @return 索引下标
     */
    public int indexOf(Object o){
        if (o == null){
            for (int i = 0; i < size; i++) {
                if (elementDate[i] == o){
                    return i;
                }
            }
        }else {
            for (int i = 0; i < size; i++) {
                if(elementDate[i] == o){
                    return i;
                }
            }
        }
        return -1;
    }



}
