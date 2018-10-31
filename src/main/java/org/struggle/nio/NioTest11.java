package org.struggle.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * @Auther: Bin.L
 * @Date: 2018/10/28 16:38
 * @Description: buffer的Scattering(散开)与Gathering(合并)
 */
public class NioTest11 {
    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress address = new InetSocketAddress(7799);
        serverSocketChannel.socket().bind(address);

        int messageLength = 2 + 3 + 4;
        ByteBuffer[] buffers = new ByteBuffer[3];
        buffers[0] = ByteBuffer.allocate(2);
        buffers[1] = ByteBuffer.allocate(3);
        buffers[2] = ByteBuffer.allocate(4);

        SocketChannel socketChannel = serverSocketChannel.accept();

        while (true) {
            int bytesRead = 0;
            while (bytesRead < messageLength) {
                long r = socketChannel.read(buffers);
                bytesRead += r;
                System.out.println("byteRead:" + bytesRead);
                Arrays.asList(buffers).stream().
                        map(buffer -> "position: " + buffer.position() + ",limit: " + buffer.limit()).
                        forEach(System.out::println);
            }
            Arrays.asList(buffers).forEach(byteBuffer -> byteBuffer.flip());

            long bytesWritten = 0;
            while (bytesWritten < messageLength) {
                long r = socketChannel.write(buffers);
                bytesWritten += r;
            }
            Arrays.asList(buffers).forEach(buffer -> buffer.clear());
            System.out.println("bytesRead: " + bytesRead + ",bytesWriten: " + bytesWritten + ",messageLength: " + messageLength);
        }
    }
}
