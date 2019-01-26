package org.struggle.netty.handler2;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import org.struggle.netty.handler.MyByteToLongDecoder2;
import org.struggle.netty.handler.MyClientHandler2;
import org.struggle.netty.handler.MyLongToByteEncoder;

/**
 * @Auther: Bin.L
 * @Date: 2018/12/11 22:42
 * @Description:
 */
public class MyClientInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        pipeline.addLast(new MyClientHandler());
    }
}
