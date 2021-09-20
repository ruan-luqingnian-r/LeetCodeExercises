package network;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author: ruan
 * Date: 2021/9/20 13:53
 * @Description: 客户端
 */
public class TestClient {
    public static void main(String[] args) throws IOException {


        System.out.println("客户端:");
        Scanner scanner = new Scanner(System.in);
        String msg = scanner.nextLine();
        //创建套接字
        Socket socket = new Socket("localhost",8888);
        //输出消息
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeUTF(msg);
        //接收消息
        InputStream inputStream = socket.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        String str = dataInputStream.readUTF();
        System.out.println("客户端返回的消息--"+str);
        //关闭所有的流
        scanner.close();
        inputStream.close();
        dataInputStream.close();
        dataOutputStream.close();
        outputStream.close();
        socket.close();
    }
}
