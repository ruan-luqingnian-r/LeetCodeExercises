package 复习;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: ruan
 * Date: 2021/9/21 10:37
 * @Description:
 */
public class Test04 {
    public static void main(String[] args) {
        String s1 = "测试";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("");
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<Integer> integers = new LinkedList<>();
        Collections.synchronizedList(list);
    }
}
