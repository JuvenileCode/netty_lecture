package org.struggle.nio;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Auther: Bin.L
 * @Date: 2018/10/27 14:15
 * @Description:
 */
public class NioTest2 {

    public static void main(String[] args) throws Exception {

        FileInputStream fileInputStream = new FileInputStream("readme.md");
        FileChannel fileChannel = fileInputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        fileChannel.read(byteBuffer);

        byteBuffer.flip();

        while (byteBuffer.hasRemaining()) {
            System.out.println((char) byteBuffer.get());
        }

        fileInputStream.close();
    }

}
