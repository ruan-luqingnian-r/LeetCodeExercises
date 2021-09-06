package sort;

import java.util.Arrays;

/**
 * @Author: ruan
 * Date: 2021/9/6 9:11
 * @Description: 选择排序
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {23,32,42,1,312,412,31,4242,312,312,412,3124,3534,53,62,4,124,235,234,124,23124,12};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int index = i;
            int minValue = arr[index];
            //遍历数组找到最小值
            for (int j = i + 1; j < arr.length; j++) {
                if (minValue > arr[j]){
                    index = j;
                    minValue = arr[j];
                }
            }
            if (index != i){
                arr[index] = arr[i];
                arr[i] = minValue;
            }

        }
    }
}
