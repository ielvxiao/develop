package com.lvxiao.jvm.cache;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author lvxiao
 * @date 2020/5/7
 */
public class JvmDnsCacheTest implements Runnable{
    private int count = 1;

    /**
     * -Dsun.net.inetaddr.ttl=1 一秒解析一次
     * 每秒解析1次 www.baidu.com 的 IP
     */
    @Override
    public void run() {
        while (true) {
            System.out.println(count);
            printIp("test.com");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            count = count + 1;
            System.out.print("\r\n");
        }
    }

    /**
     * 解析并打印 IP
     */
    private void printIp(String host) {
        InetAddress address = null;
        try {
            address = Inet4Address.getByName(host);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        if (address == null) {
            return;
        }

        System.out.println(address.getHostAddress());
        System.out.println(address.getHostName());
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new JvmDnsCacheTest());
        thread.start();
    }
}
