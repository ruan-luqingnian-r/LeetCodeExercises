package test;

import java.util.Arrays;

/**
 * @Author: ruan
 * Date: 2021/9/12 10:51
 * @Description:
 */
public class Test02 {

    public static void main(String[] args) {
        int[] arr = {1,2,32,1,32,13123,123,1242,13124,12,3213,4,12,2,3,4,2,2,2,4,5,6,7};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 冒泡排序
     * 时间复杂度
     * O(n^2)
     */
    public static void bubbleSort(int[] arr){
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }


    /**
     * 选择排序
     * @param arr
     * 时间复杂度
     * O(n^2)
     */
    public static void selectSort(int[] arr){
        //初始默认第一个数值为最小值
        //遍历后续数值直到找出真正的最小值
        for (int i = 0; i < arr.length; i++) {
            //保存下标与最小值
            int minIndex = i;
            int minValue = arr[i];
            //判断后面的值是否有更小的
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < minValue){
                    //更新保存数据作为新的最小值
                    minIndex = j;
                    minValue = arr[j];
                }
            }
            //进行数据交换
            if (minIndex != i){
                arr[minIndex] = arr[i];
                arr[i] = minValue;
            }
        }
    }

    /**
     * 插入排序
     * @param arr
     * 时间复杂度:O(n^2)
     */
    public static void insertionSort(int[] arr){
        //从第二个数值开始与其之前的数据做比较找到待插入位置
        for (int i = 1; i < arr.length; i++) {
            //保存数据——（当前待插入值和之前数据的下标）
            //待插入数据
            int value = arr[i];
            //待插入数值的下标
            int index = i - 1;
            //遍历之前的数据找到待插入的位置
        }
    }

}
