import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author: ruan
 * Date: 2021/9/29 17:03
 * @Description:
 */
public class Service {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("服务端上线...");
        System.out.println("正在连接中...");
        //监听信息
        Socket accept = serverSocket.accept();
        System.out.println("链接成功！");
        OutputStream outputStream = null;
        DataOutputStream dataOutputStream = null;
        InputStream inputStream;
        DataInputStream dataInputStream;
        while (true){
            //接收信息
            inputStream = accept.getInputStream();
            dataInputStream = new DataInputStream(inputStream);
            String str = dataInputStream.readUTF();
            System.out.println("客户端发来的消息---"+str);
            if (str.equals("BayBay~")){
                break;
            }
            String msg = scanner.nextLine();
            outputStream = accept.getOutputStream();
            dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeUTF(msg);
        }

        //关闭流
        inputStream.close();
        dataInputStream.close();
        outputStream.close();
        dataOutputStream.close();
        accept.close();
        serverSocket.close();
    }
}
