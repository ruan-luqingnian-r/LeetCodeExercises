package sort;

import java.util.Arrays;

/**
 * @Author: ruan
 * Date: 2021/9/5 17:21
 * @Description: 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {23,32,42,1,312,412,31,4242,312,312,412,3124,3534,53,62,4,124,235,234,124,23124,12};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr){
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0 ;j < arr.length - i - 1; j++){
                if (arr[j] > arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

}
