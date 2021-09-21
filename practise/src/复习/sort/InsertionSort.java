package 复习.sort;

import java.util.Arrays;

/**
 * @Author: ruan
 * Date: 2021/9/21 9:50
 * @Description:
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {72, 68, 71, 45, 68, 59, 37, 55, 41, 43};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            //待插入数据
            int value = arr[i];
            //待插入数据的前一个的下标
            int index = i - 1;
            //遍历数组
            while (index >= 0 && arr[index] > value){
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = value;
        }
    }
}
