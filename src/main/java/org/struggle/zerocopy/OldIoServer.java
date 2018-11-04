package org.struggle.zerocopy;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Auther: Bin.L
 * @Date: 2018/11/4 14:02
 * @Description: 普通拷贝测试服务端
 */
public class OldIoServer {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8899);

        while (true) {
            Socket socket = serverSocket.accept();
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            byte[] byteArray = new byte[1024];
            while (true) {
                int readCount = dataInputStream.read(byteArray, 0, byteArray.length);


                if (-1 == readCount) {
                    break;
                }
            }

        }
    }
}
