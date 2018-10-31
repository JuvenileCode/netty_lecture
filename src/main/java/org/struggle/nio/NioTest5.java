package org.struggle.nio;

import java.nio.ByteBuffer;

/**
 * @Auther: Bin.L
 * @Date: 2018/10/28 10:39
 * @Description:
 */
public class NioTest5 {

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(64);

        byteBuffer.putInt(15);
        byteBuffer.putLong(52342034L);
        byteBuffer.putDouble(56.24);
        byteBuffer.putChar('好');
        byteBuffer.putShort((short) 2);
        byteBuffer.putChar('不');

        byteBuffer.flip();

        System.out.println(byteBuffer.getInt());
        System.out.println(byteBuffer.getLong());
        System.out.println(byteBuffer.getDouble());
        System.out.println(byteBuffer.getChar());
        System.out.println(byteBuffer.getShort());
        System.out.println(byteBuffer.getChar());


    }
}
