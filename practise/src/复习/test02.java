package 复习;

import java.io.*;

/**
 * @Author: ruan
 * Date: 2021/9/18 14:35
 * @Description:
 */
public class test02 {
    public static void main(String[] args) {
        //读取文件到缓冲区
        File oldFile = new File("C:\\Users\\阮相歌\\Desktop\\LeetCodeExercises\\practise\\src\\复习\\test.txt");
        File newFile = new File("C:\\Users\\阮相歌\\Desktop\\LeetCodeExercises\\practise\\src\\复习\\copy.txt");
        try {
            //读入文件流
            FileInputStream fileInputStream = new FileInputStream(oldFile);
            BufferedInputStream bis = new BufferedInputStream(fileInputStream);
            FileOutputStream fileOutputStream = new FileOutputStream(newFile);
            BufferedOutputStream bos = new BufferedOutputStream(fileOutputStream);
            int size;
            byte[] buf = new byte[1024];
            while ( (size = bis.read(buf)) != -1){

                System.out.println(new String(buf,0,size));
            }
            fileInputStream.close();
            bis.close();
            bos.flush();
            fileOutputStream.close();
            bos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }
}
