package org.struggle.netty.handler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @Auther: Bin.L
 * @Date: 2018/12/11 22:42
 * @Description:
 */
public class MyClientInitializer2 extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        // pipeline.addLast(new MyByteToLongDecoder());
        pipeline.addLast(new MyByteToLongDecoder2());
        pipeline.addLast(new MyLongToByteEncoder());
        pipeline.addLast(new MyClientHandler2());
    }
}
