package org.struggle.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Auther: Bin.L
 * @Date: 2018/10/27 21:33
 * @Description: NIO 从一个文件读然后写到另外一个文件
 */
public class NioTest4 {
    public static void main(String[] args) throws Exception {

        FileInputStream fileInputStream = new FileInputStream("");
        FileOutputStream fileOutputStream = new FileOutputStream("");

        FileChannel inputChannel = fileInputStream.getChannel();
        FileChannel outputChannel = fileOutputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(512);

        while (true) {
            buffer.clear();
            int read = inputChannel.read(buffer);

            if (-1 == read) {
                break;
            }
            buffer.flip();
            outputChannel.write(buffer);
        }

        inputChannel.close();
        outputChannel.close();
    }
}
