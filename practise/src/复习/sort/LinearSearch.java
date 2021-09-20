package 复习.sort;

import java.util.ArrayList;

/**
 * @Author: ruan
 * Date: 2021/9/20 20:57
 * @Description: 线性搜索
 */
public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {72, 71, 68, 68, 59, 55, 45, 43, 41, 37,32,31,30,30,23,13};
        ArrayList<Integer> search = search(arr, 30);
        System.out.println(search);
    }
    public static ArrayList<Integer> search(int[] arr, int target){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target){
                list.add(i);
            }
        }
        return list;
    }
}
