package org.struggle.netty.handler2;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import org.struggle.netty.handler.MyByteToLongDecoder2;
import org.struggle.netty.handler.MyLongToByteEncoder;
import org.struggle.netty.handler.MyServerHandler2;

/**
 * @Auther: Bin.L
 * @Date: 2018/12/11 21:57
 * @Description:
 */
public class MyServerInitializer extends ChannelInitializer<SocketChannel> {


    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();


        pipeline.addLast(new MyServerHandler());
    }
}
