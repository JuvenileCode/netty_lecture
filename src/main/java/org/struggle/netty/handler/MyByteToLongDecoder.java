package org.struggle.netty.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @Auther: Bin.L
 * @Date: 2018/12/11 22:27
 * @Description: netty 自定义解码器（字节转Long）实现 - 入站处理器
 */
public class MyByteToLongDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("decode invoked!");
        System.out.println("可读的字节大小为：" + in.readableBytes());

        if (in.readableBytes() >= 8) {
            out.add(in.readLong());
        }

    }
}
