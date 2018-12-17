package org.struggle.netty.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.time.LocalDateTime;

/**
 * @Auther: Bin.L
 * @Date: 2018/12/11 22:01
 * @Description:
 */
public class MyClientHandler2 extends SimpleChannelInboundHandler<Long> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Long msg) throws Exception {
        System.out.println(ctx.channel().remoteAddress());
        System.out.println("clent output:" + msg);
        //写的为String类型数据，不会经过自定义的Long解码器
        ctx.writeAndFlush("from client: " + LocalDateTime.now());
    }


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(123456L);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
