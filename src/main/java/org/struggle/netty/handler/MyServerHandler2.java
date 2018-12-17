package org.struggle.netty.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Auther: Bin.L
 * @Date: 2018/12/11 22:00
 * @Description:
 */
public class MyServerHandler2 extends SimpleChannelInboundHandler<Long> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Long msg) throws Exception {
        System.out.println(ctx.channel().remoteAddress() + "," + msg);

        ctx.writeAndFlush(654321L);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
