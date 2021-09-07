package test;

import java.util.Arrays;

/**
 * @Author: ruan
 * Date: 2021/9/7 14:09
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        int[] arr = {23,32,42,1,312,412,31,4242,312,312,412,3124,3534,53,62,4,124,235,234,124,23124,12};
        //shellSort(arr);
        quickSort(arr,0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 冒泡排序
     * @param arr
     */
    public static void bubbleSort(int[] arr){
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
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
     */
    public static void selectSort(int[] arr){
        //默认第一个为最小值
        //遍历数组找到真正的最小值
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            int minValue = arr[i];
            //遍历数组找到最小值
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < minValue){
                    minIndex = j;
                    minValue = arr[j];
                }
            }
            //交换最小值
            if (minIndex != i){
                arr[minIndex] = arr[i];
                arr[i] = minValue;
            }
        }
    }

    /**
     * 插入排序
     * @param arr
     */
    public static void insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            //待插入的数据
            int value = arr[i];
            //待插入数据的前一个下标
            int index = i - 1;
            while (index >= 0 && arr[index] > value){
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = value;
        }
    }

    /**
     * 希尔排序
     * @param arr
     */
    public static void shellSort(int[] arr){
        for (int gap = (arr.length / 2); gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                //保存下标和待插入数字
                int j = i;
                int value = arr[j];
                if (arr[j] < arr[j - gap]){
                    while ((j - gap) >= 0 && value < arr[j - gap]){
                        arr[j] = arr[j - gap];
                        j = j - gap;
                    }
                    arr[j] = value;
                }
            }
        }
    }

    public static void quickSort(int[] arr,int left,int right){
        //保存相关变量
        int l = left;
        int r = right;
        int mid = (left + right) / 2;
        int value = arr[mid];
        int temp = 0;
        while (l < r){
            while (arr[l] < value){
                l++;
            }
            while (arr[r] > value){
                r--;
            }
            if (l >= r){
                break;
            }
            //开始交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l] == value){
                r--;
            }
            if (arr[r] == value){
                l++;
            }
        }
        if (arr[l] == arr[r]){
            l++;
            r--;
        }
        if (l < right){
            quickSort(arr, l, right);
        }
        if (r > left){
            quickSort(arr, left, r);
        }
    }



}
