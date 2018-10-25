package com.swp.netty2.server;

import com.swp.netty2.pojo.Time;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * 描述:
 * 服务器数据编码类
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-10-20 3:34 PM
 */
public class TimeEncoderPOJO extends MessageToByteEncoder<Time> {

    // 发送数据时调用
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Time time, ByteBuf byteBuf) throws Exception {
        // 只传输当前时间，精确到秒
        byteBuf.writeInt((int) time.value());
    }
}
