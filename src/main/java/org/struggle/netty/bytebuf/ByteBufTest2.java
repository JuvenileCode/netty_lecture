package org.struggle.netty.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;

/**
 * @Auther: Bin.L
 * @Date: 2018/12/4 21:39
 * @Description: Netty ByteBuf 所提供的3种缓冲区类型：
 * <li>1.heap buffer. 堆内缓冲区</li>
 * <li>2.direct buffer.直接缓冲区，操作系统在本地内存分配，JVM引用指向此内存地址</li>
 * <li>3.composite buffer. 复合缓冲区(buffer 容器)</li>
 */
public class ByteBufTest2 {

    public static void main(String[] args) {
        CompositeByteBuf compositeByteBuf = Unpooled.compositeBuffer();

        ByteBuf heapBuf = Unpooled.buffer(10);
        ByteBuf directBuf = Unpooled.directBuffer(8);
        compositeByteBuf.addComponents(heapBuf, directBuf);

        // compositeByteBuf.removeComponent(0);
        compositeByteBuf.forEach(System.out::println);
    }
}






