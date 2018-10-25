package com.swp.netty2.client;

import com.swp.netty2.pojo.Time;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 描述:
 * 客户端处理类
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-10-20 4:04 PM
 */
public class TimeClientHandlerPOJO extends ChannelInboundHandlerAdapter {

    /**
     * 接收到消息时转换成Time类型输出即可
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Time time = (Time) msg;
        System.out.println(time);
        ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
