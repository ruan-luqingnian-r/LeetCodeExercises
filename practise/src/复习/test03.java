package 复习;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ruan
 * Date: 2021/9/18 15:05
 * @Description: 递归输出某目录下文件数
 */
public class test03 {
    public static void main(String[] args) {
        //定义一个list用于存储目录
        List<String> paths = new ArrayList<>();
        getAllFilePast(new File("C:\\Users\\阮相歌\\Desktop\\LeetCodeExercises"),paths);
        for (String path : paths){
            System.out.println(path);
        }
        /*ArrayList<String> allFilePath = getAllFilePath(new File("C:\\Users\\阮相歌\\Desktop\\LeetCodeExercises"));
        for (String s : allFilePath) {
            System.out.println(s);
        }*/
    }

    public static ArrayList<String> getAllFilePath(File file){
        ArrayList<String> fileList = new ArrayList<>();
        File[] files = file.listFiles();
        if (files == null){
            return fileList;
        }
        for (File f : files){
            if (f.isDirectory()){
                fileList.add(f.getPath());
                //如果是文件夹继续递归
                getAllFilePath(f);
            }else {
                fileList.add(f.getName());
            }
        }
        return fileList;
    }

    private static void getAllFilePast(File file, List<String> paths) {
        File[] files = file.listFiles();
        if (files == null){
            return;
        }
        for (File f : files){
            if (f.isDirectory()){
                paths.add(f.getPath());
                getAllFilePast(f,paths);
            }else {
                paths.add(f.getPath());
            }
        }
    }
}
