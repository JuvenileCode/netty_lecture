package org.struggle.netty.handler3;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;

/**
 * @Auther: Bin.L
 * @Date: 2018/12/18 22:28
 * @Description:
 */
public class MyClentHandler extends SimpleChannelInboundHandler<PersonProtocol> {

    private int count;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i = 0; i < 10; i++) {
            String messageToBeSent = "sent from client ";
            byte[] content = messageToBeSent.getBytes("utf-8");
            int length = content.length;
            ctx.writeAndFlush(new PersonProtocol(length, content));
        }
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, PersonProtocol msg) throws Exception {
        int length = msg.getLength();
        byte[] content = msg.getContent();

        System.out.println("客户端接收到的消息：");
        System.out.println("长度：" + length);
        System.out.println("内容："+ new String(content, Charset.forName("utf-8")));
        System.out.println("客户端接收到的消息数量：" + (++count));

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
