package org.struggle.zerocopy;

import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * @Auther: Bin.L
 * @Date: 2018/11/4 20:34
 * @Description: 零拷贝测试客户端
 */
public class NewIoClient {

    public static void main(String[] args) throws Exception {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 8899));
        socketChannel.configureBlocking(true);
        String fileName = "/Library/Audio/Sounds/大的文件";
        FileChannel fileChannel = new FileInputStream(fileName).getChannel();

        long startTime = System.currentTimeMillis();
        long transferCount = fileChannel.transferTo(0, fileChannel.size(), socketChannel);
        System.out.println("发送总字节数： " + transferCount + ", 耗时间: " + (System.currentTimeMillis() - startTime));

        fileChannel.close();

    }
}
