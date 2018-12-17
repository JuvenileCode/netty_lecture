package org.struggle.netty.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * @Auther: Bin.L
 * @Date: 2018/12/16 14:26
 * @Description: 继承 {@link ReplayingDecoder}
 */
public class MyByteToLongDecoder2 extends ReplayingDecoder<Void> {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("MyByteToLongDecoder2 decode invoked !");
        out.add(in.readLong());
    }
}
