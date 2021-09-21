package 复习.find;

import java.util.ArrayList;

/**
 * @Author: ruan
 * Date: 2021/9/20 21:06
 * @Description: 二分查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {72, 71, 68, 68, 59, 55, 45, 43, 41, 37,32,31,30,30,23,13};
        ArrayList<Integer> search = search(arr, 30,0,arr.length - 1);
        System.out.println(search);
    }

    private static ArrayList<Integer> search(int[] arr, int target,int left,int right) {
        int mid = (left + right) / 2;
        int midValue = arr[mid];
        if (left > right){
            return new ArrayList<>();
        }
        if (target < midValue){
            return search(arr, target, mid + 1, right);
        }else if (target > midValue){
            return search(arr, target, left, mid - 1);
        }else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(mid);
            int temp1 = mid + 1;
            while (true){
                if (temp1 > arr.length || arr[temp1] != target){
                    break;
                }
                list.add(temp1);
                temp1++;
            }
            int temp2 = mid - 1;
            while (true){
                if (temp2 < 0 || arr[temp2] != target){
                    break;
                }
                list.add(temp2);
                temp2--;
            }
            return list;
        }

    }
}
