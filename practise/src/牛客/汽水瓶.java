package 牛客;

import java.util.Scanner;

/**
 * @Author: ruan
 * Date: 2021/9/18 12:02
 * @Description:
 */
public class 汽水瓶 {
    public static void main(String[] args) {
        System.out.println(test());
    }

    public static int test(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            int i = scanner.nextInt();
            return i / 2;
        }
    }
}
