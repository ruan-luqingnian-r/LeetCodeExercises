package simple;

/**
 * @Author: ruan
 * Date: 2021/7/26 16:45
 * @Description: 整数反转
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 */
public class reverse {


    public static int reverse (int x){
        //定义遍历用于接收结果
        int result = 0;
        //遍历取值
        while (x != 0){
            int temp = x % 10;
            //判断溢出
            if (result > Integer.MAX_VALUE / 10 || result < Integer.MIN_VALUE / 10)  {
                return 0;
            }
            result = result * 10 + temp;

            x /= 10;
        }
        return result;
    }
}
