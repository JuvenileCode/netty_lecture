package org.struggle.nio;

import com.google.common.primitives.Chars;
import io.netty.buffer.ByteBufUtil;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * @Auther: Bin.L
 * @Date: 2018/11/1 21:28
 * @Description: 字符编解码
 */
public class NioTest13 {

    public static void main(String[] args) throws Exception {
        String inputFile = "input.txt";
        String outputFile = "output.txt";
        RandomAccessFile inputRandomAccessFile = new RandomAccessFile(inputFile, "r");
        RandomAccessFile outputRandomAccessFile = new RandomAccessFile(outputFile, "rw");

        long inputLength = new File(inputFile).length();
        FileChannel inputFileChannel = inputRandomAccessFile.getChannel();
        FileChannel outputFileChannel = outputRandomAccessFile.getChannel();

        //直接在堆外内存映射文件
        MappedByteBuffer inputData = inputFileChannel.map(FileChannel.MapMode.READ_ONLY, 0, inputLength);

        //Charset
        Charset charset = Charset.forName("utf-8");
        //把字节数组转换成字符串
        CharsetDecoder decoder = charset.newDecoder();
        //把字符串转字节数组
        CharsetEncoder encoder = charset.newEncoder();

        CharBuffer charBuffer = decoder.decode(inputData);
        ByteBuffer outputDate = encoder.encode(charBuffer);

        outputFileChannel.write(outputDate);

        inputRandomAccessFile.close();
        outputRandomAccessFile.close();


    }

}
