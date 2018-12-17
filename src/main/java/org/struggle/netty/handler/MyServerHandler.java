package org.struggle.netty.handler;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Description netty 自定义编解码器
 * @Author Bin.Liu
 * @Date 2018/09/21 11:25
 */
public class MyServerHandler {

    public static void main(String[] args) throws Exception {
        EventLoopGroup boosGroup = new NioEventLoopGroup(1);
        EventLoopGroup workeGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(boosGroup, workeGroup).channel(NioServerSocketChannel.class)
                    .childHandler(new MyServerInitializer2());

            ChannelFuture channelFuture = serverBootstrap.bind(7779).sync();
            channelFuture.channel().closeFuture().sync();
        } finally {
            boosGroup.shutdownGracefully();
            workeGroup.shutdownGracefully();
        }
    }
}
