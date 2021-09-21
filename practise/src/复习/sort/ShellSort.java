package 复习.sort;

import java.util.Arrays;

/**
 * @Author: ruan
 * Date: 2021/9/21 10:02
 * @Description: 希尔排序
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {72, 68, 71, 45, 68, 59, 37, 55, 41, 43};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        //先分组
        for (int gap = (arr.length) / 2; gap > 0; gap /= 2) {
            //再排序
            for (int i = gap; i < arr.length; i++) {
                //保存下标和插入数字
                int j = i;
                int value = arr[j];
                if (arr[j] < arr[j - gap]){
                    while (j - gap > 0 && value < arr[j - gap]){
                        arr[j] = arr[j - gap];
                        j = j - gap;
                    }
                    arr[j] = value;
                }

            }
        }
    }
}
