package org.struggle.nio;

import java.nio.ByteBuffer;

/**
 * @Auther: Bin.L
 * @Date: 2018/10/28 11:07
 * @Description:
 */
public class NioTest7 {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put((byte) i);
        }
        //生成一个新的只读buffer
        ByteBuffer readonlyBuffer = buffer.asReadOnlyBuffer();

    }
}
