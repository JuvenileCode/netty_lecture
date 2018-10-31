package org.struggle.nio;

import java.nio.IntBuffer;
import java.security.SecureRandom;

/**
 * @Auther: Bin.L
 * @Date: 2018/10/27 13:42
 * @Description:
 */
public class NioTest1 {

    public static void main(String[] args) {
        IntBuffer buffer = IntBuffer.allocate(10);

        for (int i = 0; i < buffer.capacity(); ++i) {
            int randomNumber = new SecureRandom().nextInt(20);
            buffer.put(randomNumber);
        }
        buffer.flip();

        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }
    }
}
