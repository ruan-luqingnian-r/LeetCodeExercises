package sort;

import java.util.Arrays;

/**
 * @Author: ruan
 * Date: 2021/9/6 9:48
 * @Description: 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {23,32,42,1,312,412,31,4242,312,312,412,3124,3534,53,62,4,124,235,234,124,23124,12};
        sort(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, int left, int right) {
        //保存相关变量
        int l = left;
        int r = right;
        int midValue = arr[(left + right) / 2];
        int temp = 0;
        while (l < r){
            while (arr[l] < midValue){
                l++;
            }
            while (arr[r] > midValue){
                r--;
            }
            if (l >= r){
                break;
            }
            //开始交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l] == midValue){
                r--;
            }
            if (arr[r] == midValue){
                l++;
            }
        }
        if (l == r){
            l++;
            r--;
        }
        if (l < right){
            sort(arr, l, right);
        }
        if (r > left){
            sort(arr, left, r);
        }
    }
}
