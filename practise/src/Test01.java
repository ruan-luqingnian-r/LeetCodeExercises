/**
 * @Author: ruan
 * Date: 2021/9/22 18:36
 * @Description:
 */
public class Test01 {
    public static void main(String[] args) {
        //new开辟新的空间
        String str1 = new String("test");
        //这两个在常量池
        String str2 = "test";
        String str3 = "test";
        System.out.println(str1 == str2);
        System.out.println(str2 == str3);

        //变量s1,加上final之后变成常量
        final String s1 = "test";
        //变量+常量，来自堆
        String s2 = s1 + ".txt";
        //常量+常量，来自常量池
        String s3 = "test" + ".txt";
        System.out.println(s2 == "test.txt");
        System.out.println(s3 == "test.txt");

    }
}
