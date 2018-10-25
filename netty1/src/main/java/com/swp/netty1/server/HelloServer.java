package com.swp.netty1.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * 描述:
 * Netty服务器
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-10-20 2:28 PM
 */
public class HelloServer {

    private int port;

    public HelloServer(int port) {
        this.port = port;
    }

    public void run(){

        EventLoopGroup bossGroup = new NioEventLoopGroup(); // 用来接受进来的链接
        EventLoopGroup workerGroup = new NioEventLoopGroup(); // 用来处理已经被接收的链接
        System.out.println("准备运行端口 : " + port);

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            // 自定义处理类
                            socketChannel.pipeline().addLast(new HelloServerHandler());
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE,true);
            // 绑定端口，开始接收进来的链接
            ChannelFuture future = bootstrap.bind(port).sync();
            // 等待服务器soccer关闭
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        new HelloServer(10110).run();
    }

}
