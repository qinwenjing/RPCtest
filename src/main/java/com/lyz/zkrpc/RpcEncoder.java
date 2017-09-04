package com.lyz.zkrpc;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * Created by qwj on 2017/9/4.
 */

/**
 * Rpc编码
 */
public class RpcEncoder extends MessageToByteEncoder {
    private Class<?> genericClass;

    public RpcEncoder(Class<?> genericClass) {
        this.genericClass = genericClass;
    }
    protected void encode(ChannelHandlerContext ctx, Object in, ByteBuf out) throws Exception {

        if(genericClass.isInstance(in)){
            byte[] data = SerializationUtil.serialize(in);
            out.writeInt(data.length);
            out.writeBytes(data);
        }
    }
}
