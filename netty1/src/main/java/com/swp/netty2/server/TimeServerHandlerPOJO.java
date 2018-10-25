package com.swp.netty2.server;

import com.swp.netty2.pojo.Time;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 描述:
 * 服务器处理类
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-10-20 3:41 PM
 */
public class TimeServerHandlerPOJO extends ChannelInboundHandlerAdapter {


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println(msg);
    }

    /**
     * 建立连接时并且准备进行通信时调用
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // 发送当前时间信息
        ChannelFuture channelFuture = ctx.writeAndFlush(new Time());
        // 发送完毕之后关闭 Channel
        channelFuture.addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
