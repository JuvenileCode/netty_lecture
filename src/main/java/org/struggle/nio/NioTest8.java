package org.struggle.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Auther: Bin.L
 * @Date: 2018/10/28 12:02
 * @Description:
 */
public class NioTest8 {

    public static void main(String[] args) throws Exception {

        FileInputStream fileInputStream = new FileInputStream("");
        FileOutputStream fileOutputStream = new FileOutputStream("");

        FileChannel inputChannel = fileInputStream.getChannel();
        FileChannel outputChannel = fileOutputStream.getChannel();
        //堆外内存
        ByteBuffer buffer = ByteBuffer.allocateDirect(512);

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
