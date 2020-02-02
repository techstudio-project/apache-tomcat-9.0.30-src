package com.techstudio.webserver;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author lj
 * @date 2020/2/1
 */
public class Client {

    public static void main(String[] args) throws IOException {
        int port = 30000;
        String host = "127.0.0.1";
        Socket socket = new Socket(host, port);
        OutputStream outputStream = socket.getOutputStream();
        String message = "你好，我是客户端";

        outputStream.write(message.getBytes(StandardCharsets.UTF_8));

        outputStream.close();
        socket.close();
    }
}
