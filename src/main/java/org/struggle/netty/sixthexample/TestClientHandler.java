package org.struggle.netty.sixthexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.struggle.protobuf.DataInfo;

/**
 * @Auther: Bin.L
 * @Date: 2018/10/13 21:38
 * @Description:
 */
public class TestClientHandler extends SimpleChannelInboundHandler<DataInfo.Student> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DataInfo.Student msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        DataInfo.Student student = DataInfo.Student.newBuilder().setName("张三").setAge(22).setAddress("北京").build();
        ctx.channel().writeAndFlush(student);
    }
}
