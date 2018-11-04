package org.struggle.zerocopy;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.Socket;

/**
 * @Auther: Bin.L
 * @Date: 2018/11/4 14:18
 * @Description: 普通发送发送数据
 */
public class OldIoClient {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 8899);

        String fileName = "/Library/Audio/Sounds/大的文件";
        InputStream inputStream = new FileInputStream(fileName);

        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        byte[] buffer = new byte[1024];
        long readCount;
        long total = 0;

        long startTime = System.currentTimeMillis();

        while ((readCount = inputStream.read(buffer)) >= 0) {
            total += readCount;
            dataOutputStream.write(buffer);
        }

        System.out.println("发送总字节数： " + total + ", 耗时间: " + (System.currentTimeMillis() - startTime));

        dataOutputStream.close();
        socket.close();
        inputStream.close();

    }
}
