package org.struggle.netty.handler3;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @Auther: Bin.L
 * @Date: 2018/12/18 22:17
 * @Description:
 */
public class MyPersonEncoder extends MessageToByteEncoder<PersonProtocol> {

    @Override
    protected void encode(ChannelHandlerContext ctx, PersonProtocol msg, ByteBuf out) throws Exception {
        System.out.println("MyPersonEncoder encode invoked!");

        out.writeInt(msg.getLength());
        out.writeBytes(msg.getContent());
    }
}
