package com.work.base.netty.nio;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

public class TimeSeverInitialize extends ChannelInitializer<SocketChannel> {
    //channel注册的回调
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast("httpsServerCodec", new HttpServerCodec());
        pipeline.addLast("myServerHandler", new TimeServerHandler());
    }
}
