package 复习.sort;

import java.util.Arrays;

/**
 * @Author: ruan
 * Date: 2021/9/21 9:38
 * @Description: 选择排序
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {72, 68, 71, 45, 68, 59, 37, 55, 41, 43};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        for (int i = 0;i < arr.length;i++){
            //保证下标和变量
            int minIndex = i;
            int minValue = arr[i];
            //遍历数组找到真正的最小值
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < minValue){
                    minIndex = j;
                    minValue = arr[j];
                }
            }
            if (minIndex != i){
                arr[minIndex] = arr[i];
                arr[i] = minValue;
            }
        }
    }
}
