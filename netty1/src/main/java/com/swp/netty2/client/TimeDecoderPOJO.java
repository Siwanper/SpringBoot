package com.swp.netty2.client;

import com.swp.netty2.pojo.Time;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * 描述:
 * 客服端数据解码类
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-10-20 3:57 PM
 */
public class TimeDecoderPOJO extends ByteToMessageDecoder {

    /**
     * 有新数据接收时调用
     *
     * @param channelHandlerContext
     * @param byteBuf
     * @param list
     * @throws Exception
     */
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        if (byteBuf.readableBytes() < 4) {
            return;
        }
        // list添加成功则表示解码成功
        list.add(new Time(byteBuf.readUnsignedInt()));
    }
}
