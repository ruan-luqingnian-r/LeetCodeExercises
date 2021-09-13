package test;

import java.util.Arrays;

/**
 * @Author: ruan
 * Date: 2021/9/12 10:51
 * @Description:
 */
public class Test02 {

    public static void main(String[] args) {
        int[] arr = {1,2,32,1,32,13123,123,1242,13124,12,3213,4,12,2,3,4,2,2,2,4,5,6,7};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
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
}
