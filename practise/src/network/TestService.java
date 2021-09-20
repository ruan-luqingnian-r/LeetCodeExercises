package network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: ruan
 * Date: 2021/9/20 14:11
 * @Description: 服务端
 */
public class TestService {
    public static void main(String[] args) throws IOException {
        //创建套接字监听端口
        ServerSocket serverSocket = new ServerSocket(8888);

        //监听信息
        Socket accept = serverSocket.accept();
        //接收信息
        InputStream inputStream = accept.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        String str = dataInputStream.readUTF();
        System.out.println("客户端发来的消息---"+str);
        OutputStream outputStream = accept.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeUTF("你好，我是服务端，我接收到你的请求了！");
        //关闭流
        outputStream.close();
        dataOutputStream.close();
        inputStream.close();
        dataInputStream.close();
        accept.close();
        serverSocket.close();
    }
}
