package find;

/**
 * @Author: ruan
 * Date: 2021/9/5 17:20
 * @Description: 线性查找
 */
public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {1, 4, 12, 23, 31, 32, 42, 53, 62, 124, 124, 234, 235, 312, 312, 312, 412, 412, 3124, 3534, 4242, 23124};
        System.out.println(select(arr,1113));
    }

    public static int select(int[] arr,int target){

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target){
                return i;
            }
        }
        return -1;
    }
}
