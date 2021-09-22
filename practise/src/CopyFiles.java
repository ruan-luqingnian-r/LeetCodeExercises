import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @Author: ruan
 * Date: 2021/9/22 11:21
 * @Description: 文件读写与复制
 */
public class CopyFiles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        writeFiles(str);
        scanner.close();
        readFiles("text.txt");
        copyFile("text.txt","copy.txt");

    }

    /**
     * 文件写入
     * @param str 写入的内容
     */
    public static void writeFiles(String str){
        try(FileOutputStream fileOutputStream = new FileOutputStream("text.txt");
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        ) {
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            bufferedOutputStream.write(bytes);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * 读取文件打印再控制台上
     * @param path 被读取文件的路径
     */
    public static void readFiles(String path){
        try(FileInputStream fileInputStream = new FileInputStream(path);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        ) {
            int size;
            byte[] buf = new byte[1024];
            while ((size = bufferedInputStream.read(buf)) != -1)
            System.out.println(new String(buf,0,size));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 拷贝文件
     * @param oldPath 待拷贝的文件路径
     * @param newPath 拷贝后的文件路径
     */
    public static void copyFile(String oldPath,String newPath){
        try(FileInputStream fileInputStream = new FileInputStream(oldPath);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            FileOutputStream fileOutputStream = new FileOutputStream(newPath);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream)
        ) {
            int size;
            byte[] bytes = new byte[1024];
            while ((size = bufferedInputStream.read(bytes)) != -1){
                bufferedOutputStream.write(bytes,0,size);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
