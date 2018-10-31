package org.struggle.nio;

import java.nio.ByteBuffer;

/**
 * @Auther: Bin.L
 * @Date: 2018/10/28 10:48
 * @Description:
 */
public class NioTest6 {

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        for (int i = 0; i < byteBuffer.capacity(); i++) {
            byteBuffer.put((byte) i);
        }

        byteBuffer.position(2);
        byteBuffer.limit(6);
        //是byteBuffer中指定截取位置的引用，共享相同的底层数组
        ByteBuffer sliceBuffer = byteBuffer.slice();
        for (int i = 0; i < sliceBuffer.capacity(); i++) {
            byte b = sliceBuffer.get(i);
            sliceBuffer.put(i, b *= 2);
        }

        byteBuffer.position(0);
        byteBuffer.limit(byteBuffer.capacity());
        while (byteBuffer.hasRemaining()) {
            System.out.println(byteBuffer.get());
        }

    }
}
