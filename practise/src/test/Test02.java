package test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: ruan
 * Date: 2021/9/12 10:51
 * @Description:
 */
public class Test02 {

    public static void main(String[] args) {
        int[] arr = {1,2,32,1,32,13123,123,1242,13124,12,3213,4,12,2,3,4,2,2,2,4,5,6,7};
        System.out.println("排序前:" + Arrays.toString(arr));
        shellSort(arr);
        System.out.println("排序后:" + Arrays.toString(arr));
        //ArrayList<Integer> list = linearSearch(arr, 2);
        int target = 2;
        ArrayList<Integer> list = binarySearch(arr, target, 0, arr.length);
        System.out.println("值为[" + target + "]的数值下标为:" + list);
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
            while (index >= 0 && arr[index] > value){
                //调整数值
                arr[index + 1] = arr[index];
                index--;
            }

            arr[index + 1] = value;
        }
    }

    /**
     * 希尔排序
     * @param arr
     * 时间复杂度：O(nlogn)
     */
    public static void shellSort(int[] arr){
        //分组排序
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                //类似于增强插入排序
                //保存下标与待插入数据
                int j = i;
                int value = arr[j];
                //遍历数据找到最小值
                if (arr[j] < arr[j - gap]){
                    while ( j - gap >= 0 && value < arr[j - gap]){
                        arr[j] = arr[j - gap];
                        j = j - gap;
                    }
                    arr[j] = value;
                }
            }
        }
    }

    /**
     * 线性查找
     * @param arr
     * @param target
     * @return
     */
    public static ArrayList<Integer> linearSearch(int[] arr,int target){

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target){
                list.add(i);
            }
        }
        return list;
    }

    public static ArrayList<Integer> binarySearch(int[] arr,int target,int left,int right){
        int mid = (left + right) / 2;
        int value = arr[mid];

        if (left > right){
            return new ArrayList<>();
        }

        if (value > target){
            //向左
            return binarySearch(arr, target, left, mid - 1);
        }else if (value < target){
            return binarySearch(arr, target, mid + 1, right);
        }else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(mid);
            int temp1 = mid + 1;
            while (true){
                if (temp1 > arr.length || arr[temp1] != target){
                    break;
                }
                list.add(temp1);
                temp1++;
            }
            int temp2 = mid - 1;
            while (true){
                if (temp2 < 0 || arr[temp2] != target){
                    break;
                }
                list.add(temp2);
                temp2--;
            }
            return list;
        }
    }

    /**
     * 快速排序
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort(int[] arr,int left,int right){
        int l = left;
        int r = right;


    }

}
