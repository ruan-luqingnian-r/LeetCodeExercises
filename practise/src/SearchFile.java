import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ruan
 * Date: 2021/9/22 16:42
 * @Description: 文件API使用，简单递归逻辑代码编写
 * 找出某目录下的所有子目录及文件并打印在控制台上wenj
 */
public class SearchFile {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        File file = new File("C:\\Users\\阮相歌\\Desktop\\LeetCodeExercises");
        getAllFilePast(file,strings);
        for (String string : strings) {
            System.out.println(string);
        }


    }
    public static void getAllFilePast(File file, List<String> paths){
         File[] files = file.listFiles();
         if (files == null){
             return;
         }
        for (File f : files) {
            if (f.isDirectory()){
                paths.add(f.getPath());
                getAllFilePast(f,paths);
            }else {
                paths.add(f.getName());
            }
        }

    }
}
