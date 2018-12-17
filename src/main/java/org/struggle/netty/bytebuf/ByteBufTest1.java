package org.struggle.netty.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;

/**
 * @Auther: Bin.L
 * @Date: 2018/12/2 20:34
 * @Description:
 */
public class ByteBufTest1 {

    public static void main(String[] args) {
        //Unpooled 未被池化的，用完就丢弃
        ByteBuf byteBuf = Unpooled.copiedBuffer("张hello world", Charset.forName("utf-8"));

        if (byteBuf.hasArray()) {
            //判断当前ByteBuf是堆上缓冲还是直接缓冲
            byte[] content = byteBuf.array();
            System.out.println(new String(content, Charset.forName("utf-8")));

            System.out.println(byteBuf);

            System.out.println(byteBuf.arrayOffset());
            System.out.println(byteBuf.readerIndex());
            System.out.println(byteBuf.writerIndex());
            System.out.println(byteBuf.capacity());
            System.out.println(byteBuf.readableBytes());

            for (int i = 0; i < byteBuf.readableBytes(); i++) {
                System.out.println((char) byteBuf.getByte(i));
            }

            System.out.println(byteBuf.getCharSequence(0, 4, Charset.forName("utf-8")));
            System.out.println(byteBuf.getCharSequence(0, byteBuf.readableBytes(), Charset.forName("utf-8")));
        }

    }
}
