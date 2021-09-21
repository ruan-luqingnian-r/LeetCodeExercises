package 复习.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author: ruan
 * Date: 2021/9/20 20:45
 * @Description: 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {72, 68, 71, 45, 68, 59, 37, 55, 41, 43};
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] < arr[j + 1]){
                    arr[j] = arr[j] ^ arr[j + 1];
                    arr[j + 1] = arr[j + 1] ^ arr[j];
                    arr[j] = arr[j] ^ arr[j + 1];
                }
            }
        }
    }
}
