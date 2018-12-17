package org.struggle.netty.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @Auther: Bin.L
 * @Date: 2018/12/13 21:33
 * @Description: 自定义编码器，将{@link Long}编码{@link ByteBuf}
 */
public class MyLongToByteEncoder extends MessageToByteEncoder<Long> {

    @Override
    protected void encode(ChannelHandlerContext ctx, Long msg, ByteBuf out) throws Exception {
        System.out.println("encoder invoked !" + msg);
        out.writeLong(msg);
    }
}
