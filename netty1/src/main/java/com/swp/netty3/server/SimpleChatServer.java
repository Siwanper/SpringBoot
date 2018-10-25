package com.swp.netty3.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * 描述:
 * 服务器
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-10-23 12:11 PM
 */
public class SimpleChatServer {

    private int port;

    public SimpleChatServer(int port) {
        this.port = port;
    }

    public void run(){
        EventLoopGroup bossGroup = new NioEventLoopGroup(); // 用来接收进来的链接
        EventLoopGroup workerGroup = new NioEventLoopGroup(); //用来处理接收进来的链接

        try {

            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)          // 设置如何接收链接
                    .childHandler(new SimpleChatServerInitializer()) // channel 配置
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);

            System.out.println("SimpleChatServer 启动了");
            ChannelFuture future = b.bind(port).sync(); // 绑定端口
            future.channel().closeFuture().sync();

        } catch (InterruptedException e) {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
            System.out.println("SimpleChatServer 关闭了");
        }

    }

    public static void main(String[] args) {
        int port = 8080;
        new SimpleChatServer(port).run();
    }

}
