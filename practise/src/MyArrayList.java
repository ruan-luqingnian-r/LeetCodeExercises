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

    /**
     * 扩容机制
     * @param minCapacity 最小容量
     */
    private void ensureCapacityInternal(int minCapacity){
        //初次扩容
        if (this.elementDate == EMPTY_ELEMENT_DATA){
            minCapacity = Math.max(minCapacity,DEFAULT_CAPACITY);
        }
        //如果当前数组容量小于最小容量（需要扩容）
        if (elementDate.length - minCapacity < 0){
            int oldCapacity = elementDate.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            if (newCapacity - minCapacity < 0){
                newCapacity = minCapacity;
            }
            //创建数组
            Object[] objects = new Object[newCapacity];
            //拷贝数据
            System.arraycopy(elementDate,0,objects,0,elementDate.length);
            //修改索引
            elementDate = objects;
        }
    }

    /**
     * 索引检查
     * @param index 索引
     */
    private void rangeCheck(int index){
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("索引越界");
        }
    }

    public boolean add(Object o){
        //并发判断
        modCount++;
        //扩容
        ensureCapacityInternal(size + 1);
        elementDate[size++] = o;
        return true;
    }

    public Object get(int index){
        rangeCheck(index);
        return elementDate[index];
    }

    public int indexOf(Object o){
        if (o == null){
            for (int i = 0; i < size; i++) {
                if (elementDate[i] == null){
                    return i;
                }
            }
        }else {
            for (int i = 0; i < size; i++) {
                if (elementDate[i] == o){
                    return i;
                }
            }
        }
        return -1;
    }

    public Object set(int index,Object o){
        rangeCheck(index);
        Object oldValue = elementDate[index];
        elementDate[index] = o;
        return oldValue;
    }

    public Object remove(int index){
        rangeCheck(index);
        Object o = elementDate[index];
        //计算要后移多少数据
        int numMove = size - index - 1;
        if (numMove > 0){
            System.arraycopy(elementDate,index + 1,elementDate,index,numMove);
        }
        elementDate[--size] = null;
        return o;
    }


}
