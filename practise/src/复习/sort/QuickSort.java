package 复习.sort;

import java.util.Arrays;

/**
 * @Author: ruan
 * Date: 2021/9/21 10:14
 * @Description:
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {72, 68, 71, 45, 68, 59, 37, 55, 41, 43};
        sort(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr,int left,int right) {
        int l = left;
        int r = right;
        int midValue = arr[(left + right) / 2];
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
            arr[l] = arr[l] ^ arr[r];
            arr[r] = arr[r] ^ arr[l];
            arr[l] = arr[l] ^ arr[r];
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
        if (left < r){
            sort(arr, left, r);
        }
    }
}
