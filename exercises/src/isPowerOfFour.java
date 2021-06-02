/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: isPowerOfFour
 * @Author: 小天才
 * Date: 2021/5/31 9:54
 * project name: LeetCodeExercises
 * @Version: 0.0.1
 * @Description: LeetCode——342. 4的幂
 */
public class isPowerOfFour {
    public static void main(String[] args) {
        isPowerOfFour isPowerOfFour = new isPowerOfFour();
        isPowerOfFour.isPowerOfFour(16);
    }
    public boolean isPowerOfFour(int n) {
        if (n <= 0) return false;
        int x = (int)Math.sqrt(n);
        return x * x == n && (x & -x) == x;
    }




}
