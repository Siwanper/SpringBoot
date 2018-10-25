package com.swp.netty3.server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * 描述:
 * 服务端处理器
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-10-23 11:31 AM
 */
public class SimpleChatServerHanlder extends SimpleChannelInboundHandler<String> {

    public static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    /**
     * 收到新的客服端连接时调用
     * 将新的客户端channel存入列表，并广播消息
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        // 广播加入消息
        channelGroup.writeAndFlush("[SERVER] - " + channel.remoteAddress() + "加入\n");
        channelGroup.add(channel); // 存入列表
    }

    /**
     * 客户端离开操作
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        // 广播加入消息
        channelGroup.writeAndFlush("[SERVER] - " + channel.remoteAddress() + "离开\n");
    }

    /**
     * 收到消息时将消息转发给其他客户端
     *
     * @param ctx
     * @param s
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String s) throws Exception {
        Channel incoming = ctx.channel();

        for (Channel channel : channelGroup) {
            if (channel != incoming) { // 其他客服端
                channel.writeAndFlush("[" + incoming.remoteAddress() + "] " + s + "\n");
            } else { // 自己
                channel.writeAndFlush("[you] " + s + "\n");
            }
        }
    }

    /**
     * 监听到客户端活动时调用
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        // 广播加入消息
        channelGroup.writeAndFlush("[SERVER] - " + channel.remoteAddress() + "在线\n");
    }

    /**
     * 监听到客户端不活动时调用
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        // 广播加入消息
        channelGroup.writeAndFlush("[SERVER] - " + channel.remoteAddress() + "掉线\n");
    }

    /**
     * 监听到客户端异常时调用
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        Channel channel = ctx.channel();
        // 广播加入消息
        channelGroup.writeAndFlush("[SERVER] - " + channel.remoteAddress() + "异常\n");
    }
}
