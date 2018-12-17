package org.struggle.netty.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.util.List;

/**
 * @Auther: Bin.L
 * @Date: 2018/12/16 21:34
 * @Description: 使用 {@link MessageToMessageDecoder}
 */
public class MyLongToStringDecoder extends MessageToMessageDecoder<Long> {

    @Override
    protected void decode(ChannelHandlerContext ctx, Long msg, List<Object> out) throws Exception {
        System.out.println("MyLongToStringDecoder decode invoked!");
        out.add(String.valueOf(msg));
    }
}
