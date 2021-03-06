package org.struggle.nio;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * @Auther: Bin.L
 * @Date: 2018/10/28 16:34
 * @Description: 文件锁
 */
public class NioTest10 {
    public static void main(String[] args) throws Exception {
        RandomAccessFile randomAccessFile = new RandomAccessFile("NioTest10", "rw");
        FileChannel fileChannel = randomAccessFile.getChannel();

        FileLock fileLock = fileChannel.lock(3, 6, true);
        System.out.println("valid:" + fileLock.isValid());
        System.out.println("lock type:" + fileLock.isShared());

        fileLock.release();
        randomAccessFile.close();
    }
}
