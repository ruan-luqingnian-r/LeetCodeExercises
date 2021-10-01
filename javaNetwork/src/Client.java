import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author: ruan
 * Date: 2021/9/29 16:47
 * @Description:
 */
public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("创建服务器");
        Scanner scanner = new Scanner(System.in);
        Socket socket = new Socket("localhost", 8080);
        OutputStream outputStream;
        DataOutputStream dataOutputStream;
        InputStream inputStream;
        DataInputStream dataInputStream;
        while (true){
            String str = scanner.nextLine();
            outputStream = socket.getOutputStream();
            dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeUTF(str);
            //接收消息
            inputStream = socket.getInputStream();
            dataInputStream = new DataInputStream(inputStream);
            String msg = dataInputStream.readUTF();
            System.out.println("接收到消息: " + msg);
            if (msg.equals("BayBay~")){
                break;
            }
        }
        //关闭流
        scanner.close();
        inputStream.close();
        dataInputStream.close();
        outputStream.close();
        dataOutputStream.close();
        socket.close();

    }
}
