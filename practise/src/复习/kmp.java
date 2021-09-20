package 复习;

/**
 * @Author: ruan
 * Date: 2021/9/19 15:16
 * @Description: 字符串匹配
 */
public class kmp {
    public static void main(String[] args) {
        String str1 = "硅硅谷 尚硅谷你尚硅 尚硅谷你尚硅谷你尚硅你好";
        String str2 = "尚硅谷你尚硅你";
        int index = violenceMatch(str1, str2);
        System.out.println("index=" + index);
    }

    /**
     * 字符串匹配
     * @param str1 字符串集
     * @param str2 匹配字段
     * @return 下标
     */
    private static int violenceMatch(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        return 0;
    }
}
