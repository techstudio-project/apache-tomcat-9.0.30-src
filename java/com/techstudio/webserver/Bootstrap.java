package com.techstudio.webserver;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author lj
 * @date 2020/1/31
 */
public class Bootstrap {

    public static void main(String[] args) throws IOException {

        int port = 30000;
        ServerSocket serverSocket = new ServerSocket(port);

        System.out.println("等待客户端连接");
        Socket socket = serverSocket.accept();

        // 建立好连接后，从socket中获取输入流，并建立缓冲区进行读取
        InputStream inputStream = socket.getInputStream();
        String receive = input2String(inputStream);
        System.out.println("客户端：" + receive);

        inputStream.close();
        socket.close();
        serverSocket.close();
    }

    private static String input2String(InputStream inputStream) throws IOException {
        byte[] bytes = new byte[1024];
        int len;
        StringBuilder sb = new StringBuilder();
        while ((len = inputStream.read(bytes)) != -1) {
            sb.append(new String(bytes, 0, len, StandardCharsets.UTF_8));
        }
        return sb.toString();
    }

}
