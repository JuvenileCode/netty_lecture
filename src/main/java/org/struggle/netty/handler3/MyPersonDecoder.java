package org.struggle.netty.handler3;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * @Auther: Bin.L
 * @Date: 2018/12/18 22:12
 * @Description: 解码器
 */
public class MyPersonDecoder extends ReplayingDecoder<Void> {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("MyPersonDecoder decode invoked !");

        int length = in.readInt();
        byte[] content = new byte[length];
        in.readBytes(content);

        PersonProtocol personProtocol = new PersonProtocol();
        personProtocol.setLength(length);
        personProtocol.setContent(content);
        out.add(personProtocol);
    }
}
