package org.struggle.netty.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * @Auther: Bin.L
 * @Date: 2018/12/1 22:01
 * @Description: Netty ByteBuf Example
 */
public class ByteBufTest0 {

    public static void main(String[] args) {

        ByteBuf buf = Unpooled.buffer(10);
        for (int i = 0; i < 10; i++) {
            //这是相对方法,调用此方法会改变writerIndex指针位置
            buf.writeByte(i);
        }

        for (int i = 0; i < buf.capacity(); i++) {
            //这是绝对方法，调用此方法ByteBuf的指针不会发生任何改变
            System.out.println(buf.getByte(i));
        }

        for (int i = 0; i < buf.capacity(); i++) {
            //这是相对方法,调用此方法会改变readerIndex指针位置
            System.out.println(buf.readByte());
        }

    }
}
