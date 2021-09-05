package find;

import java.util.ArrayList;

import static find.LinearSearch.select;

/**
 * @Author: ruan
 * Date: 2021/9/5 19:52
 * @Description:
 */
public class BinarySelect {
    public static void main(String[] args) {
        int[] arr = {1, 4,4,4, 12, 23, 31, 32, 42, 53, 62, 124, 124, 234, 235, 312, 312, 312, 412, 412, 3124, 3534, 4242, 23124};
        System.out.println(select(arr,4,0,arr.length - 1));
    }

    private static ArrayList<String> select(int[] arr, int target, int left, int right) {
        ArrayList<String> arrayList = new ArrayList<>();
        return arrayList;
    }
}
