package org.struggle.netty.sixthexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.struggle.protobuf.DataInfo;

/**
 * @Auther: Bin.L
 * @Date: 2018/10/13 21:24
 * @Description:
 */
public class TestServerHandler extends SimpleChannelInboundHandler<DataInfo.Student> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DataInfo.Student msg) throws Exception {
        System.out.println(msg.getName() + " " + msg.getAge() + " " + msg.getAddress());
    }
}
