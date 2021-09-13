package sort;

import java.util.Arrays;

/**
 * @Author: ruan
 * Date: 2021/9/6 9:24
 * @Description: 希尔排序
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {23,32,42,1,312,412,31,4242,312,312,412,3124,3534,53,62,4,124,235,234,124,23124,12};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr){
        for(int gap = arr.length / 2;gap > 0;gap /= 2){
            for (int i = gap;i < arr.length; i++){
                //保存下标和待插入数字
                int j = i;
                int value = arr[j];
                if (arr[j] < arr[j - gap]){
                    while (j - gap >= 0 && value < arr[j - gap]){
                        arr[j] = arr[j - gap];
                        j = j - gap;
                    }
                    arr[j] = value;
                }
            }
        }
    }
}
