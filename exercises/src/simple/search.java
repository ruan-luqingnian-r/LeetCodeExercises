package simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ruan
 * Date: 2021/7/27 16:04
 * @Description: 二分查找
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 */
public class search {
    public static void main(String[] args) {
        int [] nums = {-1,0,3,5,9,9,12};
        int target = 9;
        List<Integer> search = search(0, nums.length - 1, nums, target);
        Integer integer = search.get(0);
        System.out.println(search);
    }

    /**
     * 二分查找
     * @param left  首索引
     * @param right    尾索引
     * @param mums   带查找数组
     * @param target 目标值
     * @return
     */
    public static List<Integer> search(int left, int right, int[] mums, int target){

        int mid = (left + right) / 2;
        int midVal = mums[mid];

        if (left > right){
            return new ArrayList<>();
        }

        if (target > midVal){
            //向右递归
            return search(mid + 1, right, mums, target);
        }else if (target < midVal){
            //向左递归
            return search(left, mid - 1, mums, target);
        }else {

            ArrayList<Integer> indexList = new ArrayList<>();
            //向左扫描
            int temp = mid - 1;
            while (true){
                if (temp < 0 || mums[temp] != target){
                    break;
                }
                indexList.add(temp);
                temp -= 1;
            }
            indexList.add(mid);
            temp = mid + 1;
            while (true){
                if (temp > mums.length - 1 || mums[temp] != target){
                    break;
                }
                indexList.add(temp);
                temp += 1;
            }
            return indexList;
        }

    }

}
