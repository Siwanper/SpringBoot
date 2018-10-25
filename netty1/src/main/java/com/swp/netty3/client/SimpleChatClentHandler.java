package com.swp.netty3.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * 描述:
 * 客户端处理器
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-10-23 2:09 PM
 */
public class SimpleChatClentHandler extends SimpleChannelInboundHandler<String> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        System.out.println(s);
    }
}
