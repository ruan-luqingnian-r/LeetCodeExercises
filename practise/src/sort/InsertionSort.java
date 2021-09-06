package sort;

import java.util.Arrays;

/**
 * @Author: ruan
 * Date: 2021/9/6 8:42
 * @Description: 插入排序
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {23,32,42,1,312,412,31,4242,312,312,412,3124,3534,53,62,4,124,235,234,124,23124,12};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            //待插入数据
            int value = arr[i];
            //待排数据的前一个下标
            int index = i - 1;
            while (index >= 0 && arr[index] > value){
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = value;
        }
    }
}
