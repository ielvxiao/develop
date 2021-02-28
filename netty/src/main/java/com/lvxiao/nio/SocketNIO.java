package com.lvxiao.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.LinkedList;
import java.util.List;

/**
 * 不带多路复用器的版本
 * @author lvxiao
 * @date 2021/2/28
 */
public class SocketNIO {
    public static void main(String[] args) throws IOException, InterruptedException {
        List<SocketChannel> clients = new LinkedList<>();

        ServerSocketChannel ss = ServerSocketChannel.open();
        ss.bind(new InetSocketAddress(9999));
        ss.configureBlocking(false);
        while (true) {
            Thread.sleep(1000);
            SocketChannel client = ss.accept();
            if (client == null) {
                System.out.println("client is null");
            } else {
                client.configureBlocking(false);
                int port = client.socket().getPort();
                System.out.println("this client port:" + port);
                clients.add(client);
            }
            ByteBuffer buffer = ByteBuffer.allocate(4096);
            for (SocketChannel c : clients) {
                int num = c.read(buffer);
                if (num > 0) {
                    buffer.flip();
                    byte[] bytes = new byte[buffer.limit()];
                    buffer.get(bytes);
                    System.out.println("get data from buffer,data:"+ new String(bytes));
                    buffer.clear();
                }
            }
        }
    }
}
