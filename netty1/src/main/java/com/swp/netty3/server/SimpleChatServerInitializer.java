package com.swp.netty3.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * 描述:
 * 服务器配置初始化
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-10-23 12:02 PM
 */
public class SimpleChatServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel channel) throws Exception {

        ChannelPipeline pipeline = channel.pipeline();
        // 添加处理类
        // 使用"\r"'\n'分割帧
        pipeline.addLast("framer", new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));
        pipeline.addLast("decoder", new StringDecoder());
        pipeline.addLast("encoder",new StringEncoder());

        pipeline.addLast("handler",new SimpleChatServerHanlder());

        System.out.println("SimpleChatClient: " + channel.remoteAddress() + "连接上");
    }
}
