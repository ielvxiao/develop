package com.lvxiao.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2020/2/21 5:22 下午
 */
public class NettyDemo {
    /*
    编写服务器入站事件，直接继承ChannelInboundHandlerAdapter就可以
     */
    //标识一个ChannelHandler可以被多个Channel安全地分享
    @ChannelHandler.Sharable
    private static class EchoServerHandler extends ChannelInboundHandlerAdapter {
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            var in = (ByteBuf) msg;
            System.out.println("Server received:" + in.toString(CharsetUtil.UTF_8));
            //将受到的消息写给发送者， 而不冲刷出站消息
            ctx.write(in);
        }

        @Override
        public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
            //将未决消息冲刷到远程节点，并且关闭该Channel
            ctx.writeAndFlush(Unpooled.EMPTY_BUFFER)
                    .addListener(ChannelFutureListener.CLOSE);
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            cause.printStackTrace();
            //关闭该Channel
            ctx.close();
        }
    }

    private static class EchoServer {
        private static void startServer(int port) throws InterruptedException {
            var serverHandler = new EchoServerHandler();
            var group = new NioEventLoopGroup();
            try {
                var b = new ServerBootstrap();
                b.group(group)
                        .channel(NioServerSocketChannel.class)  //指定Channel类型
                        .localAddress(new InetSocketAddress(port))
                        .childHandler(new ChannelInitializer<SocketChannel>() {
                            @Override
                            protected void initChannel(SocketChannel ch) throws Exception {
                                ch.pipeline().addLast(serverHandler);
                            }
                        });
                var future = b.bind().sync();   //异步绑定服务器
                future.channel().closeFuture().sync();  //获取closeFuture并且阻塞当前线程直到结束
            } finally {
                group.shutdownGracefully().sync(); //关闭EventLoopGroup释放所有资源
            }
        }

        public static void main(String[] args) throws InterruptedException {
            startServer(9999);
        }
    }

    @ChannelHandler.Sharable
    public static class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {
        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            ctx.writeAndFlush(Unpooled.copiedBuffer("Netty rocks!", CharsetUtil.UTF_8));    //当被通知channel活跃的时候返回消息
        }

        @Override
        protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
            System.out.println("Client received: " + msg.toString(CharsetUtil.UTF_8));     //记录已接收消息
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            cause.printStackTrace();
            //关闭该Channel
            ctx.close();
        }
    }

    private static class EchoClient {
        public static void startClient(String host, int port) throws InterruptedException {
            var g = new NioEventLoopGroup();
            try {
                var b = new Bootstrap();
                b.group(g)
                        .channel(NioSocketChannel.class) //与server的不同
                        .remoteAddress(new InetSocketAddress(host, port))
                        .handler(new ChannelInitializer<SocketChannel>() {
                            @Override
                            protected void initChannel(SocketChannel ch) throws Exception {
                                ch.pipeline().addLast(new EchoClientHandler());
                            }
                        });
                var f = b.connect().sync();
                f.channel().closeFuture().sync();
            } finally {
                g.shutdownGracefully().sync();
            }
        }

        public static void main(String[] args) throws InterruptedException {
            startClient("localhost", 9999);
        }
    }
}