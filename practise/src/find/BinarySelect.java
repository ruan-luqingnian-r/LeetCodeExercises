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

    private static ArrayList<Integer> select(int[] arr, int target, int left, int right) {
        int mid = (left + right) / 2;
        int midValue = arr[mid];

        if (left > right){
            return new ArrayList<>();
        }

        if (midValue > target){
            //目标值在中间值左边，向左递归
            return select(arr, target, left, mid - 1);
        }else if (target > midValue){
            return select(arr, target, mid + 1, right);
        }else {
            //找到mid的就是中间值
            ArrayList<Integer> list = new ArrayList<>();
            list.add(mid);
            //扫描相同值
            int temp1 = mid - 1;
            while (true){
                if (temp1 < 0 || arr[temp1] != target){
                    break;
                }
                list.add(temp1);
                temp1--;
            }
            int temp2 = mid + 1;
            while (true){
                if (temp2 > arr.length || arr[temp2] != target){
                    break;
                }
                list.add(temp2);
                temp2++;
            }
            return list;
        }

    }
}
