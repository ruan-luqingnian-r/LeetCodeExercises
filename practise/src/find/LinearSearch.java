package find;

import java.util.ArrayList;

/**
 * @Author: ruan
 * Date: 2021/9/5 17:20
 * @Description: 线性查找
 */
public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {1, 4,4,4, 12, 23, 31, 32, 42, 53, 62, 124, 124, 234, 235, 312, 312, 312, 412, 412, 3124, 3534, 4242, 23124};
        System.out.println(select(arr,4));
    }

    public static ArrayList<String> select(int[] arr, int target){

        ArrayList<String> arrayList = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target){
                arrayList.add(i+"");
            }
        }
        return arrayList;
    }
}
