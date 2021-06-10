import java.util.Arrays;

/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TowSun
 * @Author: 小天才
 * Date: 2021/6/2 15:14
 * project name: LeetCodeExercises
 * @Version: 0.0.1
 * @Description:
 */
public class TowSun {
    public static void main(String[] args) {
        int[] arr = {2,1,9,4,4,56,90,3};
        TowSun towSun = new TowSun();
        int[] ints = towSun.twoSum(arr, 8);
        System.out.println(Arrays.toString(ints));
    }


    
    /**
     *
     * @param numbers int整型一维数组
     * @param target int整型
     * @return int整型一维数组
     */
    public int[] twoSum (int[] numbers, int target) {
        // write code here
        int[] var = new int[2];
        for(int i = 0;i < numbers.length ;i++){
            for(int j = i + 1; j < numbers.length ;j++){
                if(numbers[i] + numbers[j] == target){
                    var[0] = j+1;
                    var[1] = i+1;
                    return var;
                }
            }
        }
        return var;
    }
}