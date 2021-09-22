package 复习;

import java.io.Serializable;

/**
 * @Author: ruan
 * Date: 2021/9/21 11:12
 * @Description:
 */
public class MyArrayList implements Serializable {
    /**
     * 初始扩容容量-用于第一次扩容，大小为10
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * 初始化空的list
     */
    private static final Object[] EMPTY_ELEMENT_DATA = {};
    /**
     * 真实存储数据的list
     */
    transient Object[] elementData;
    /**
     * 实际存储的数组大小
     */
    private int size;
    /**
     * 空参构造函数
     */
    public MyArrayList(){
        this.elementData = EMPTY_ELEMENT_DATA;
    }

    /**
     * 有参构造函数
     * @param initialCapacity 指定初始容量
     */
    public MyArrayList(int initialCapacity){
        if (initialCapacity > 0){
            //初始化数组
            this.elementData = new Object[initialCapacity];
        }else if (initialCapacity == 0){
            this.elementData = EMPTY_ELEMENT_DATA;
        }else{
            throw new IllegalArgumentException("参数异常");
        }
    }

    /**
     * 容量计算+扩容机制
     * @param mincapacity 最小容量
     */
    private void ensureCapacityInternal(int mincapacity){
        //如果初次扩容则使用默认容量
        if (elementData == EMPTY_ELEMENT_DATA){
            mincapacity = Math.max(DEFAULT_CAPACITY,mincapacity);
        }
        //判断是否需要扩容
        if (mincapacity - elementData.length > 0){
            int oldCapacity = elementData.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            //如果新的容量小于最小容量，则将最小容量赋给新容量
            if (newCapacity - mincapacity < 0){
                newCapacity = mincapacity;
            }
            //创建数组
            Object[] newObjects = new Object[newCapacity];
            //拷贝旧数据到新的数组中
            System.arraycopy(elementData,0,newObjects,0,elementData.length);
            //修改引用地址
            elementData = newObjects;
        }

    }

    /**
     * 检查下标是否越界
     * @param index 输入的下标
     */
    private void rangeCheck(int index){
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("索引越界");
        }
    }


    /**
     * 添加元素
     * @param e 待添加元素
     * @return 是否成功
     */
    public boolean add(Object e){
        //容量判断
        ensureCapacityInternal(size + 1);
        //下标赋值,尾部插入
        elementData[size++] = e;
        return true;
    }

    /**
     * 根据下标获取数组对象
     * @param index 下标
     * @return 对象
     */
    public Object get(int index){
        rangeCheck(index);
        return elementData[index];
    }

    /**
     * 判断对象位置
     * @param o
     * @return
     */
    public int indexOf(Object o){
        if (o == null){
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null){
                    return i;
                }
            }
        }else {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == o){
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 根据索引修改
     * @param index 待修改索引
     * @param o 新数据
     * @return 旧数据
     */
    public Object set(int index,Object o){
        rangeCheck(index);
        Object oldValue = elementData[index];
        elementData[index] = o;
        return oldValue;
    }

    /**
     * 删除
     * @param index 待删除的索引
     * @return 删除的数据
     */
    public Object remove(int index){
        rangeCheck(index);
        Object oldValue = elementData[index];
        //计算之后还有多少数据
        int numMoved = size - index - 1;
        if (numMoved > 0){
            System.arraycopy(elementData,index+1,elementData,index,numMoved);
        }
        elementData[--size] = null;
        return oldValue;
    }

    /**
     * 获取数组大小
     * @return 数组大小
     */
    public int size(){
        return this.size;
    }
}
