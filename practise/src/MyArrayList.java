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

    /**
     * 添加元素
     * @param e
     * @return
     */
    public boolean add(Object e){
        //用于并发判断
        modCount++;
        //容量判断
        ensureCapacityInternal(size + 1);
        //使用下标插入，尾部赋值
        elementData[size++] = e;
        return true;
    }

    /**
     * 计算容量+确保容量
     * @param minCapacity
     */
    public void ensureCapacityInternal(int minCapacity){
        //初次扩容使用默认容量
        if(elementData == EMPTY_ELEMENT_DATA){
            minCapacity = Math.max(DEFAULT_CAPACITY,minCapacity);
        }
        //判断是否需要扩容
        if (minCapacity - elementData.length > 0){
            int oldCapacity = elementData.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            //如果新容量小于最小容量，者将最小容量付给新容量
            if (newCapacity - minCapacity < 0){
                newCapacity = minCapacity;
            }
            //创建新数组
            Object[] objects = new Object[newCapacity];
            //拷贝数据
            System.arraycopy(elementData,0,objects,0,elementData.length);
            //修改引用
            elementData = objects;
        }
    }

    /**
     * 检查下标是否越界
     * @param index
     */
    private void rangeCheck(int index){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("索引越界");
        }
    }

    /**
     * 通过下标获取对象
     * @param index
     * @return
     */
    public Object get(int index){
        rangeCheck(index);
        return elementData[index];

    }




}
