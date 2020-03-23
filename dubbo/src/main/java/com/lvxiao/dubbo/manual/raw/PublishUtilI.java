package com.lvxiao.dubbo.manual.raw;

import com.lvxiao.dubbo.manual.raw.server.ServerHandler;
import com.lvxiao.dubbo.manual.raw.service.CalculateService;
import com.lvxiao.dubbo.manual.raw.service.impl.CalculateServiceImpl;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/10/28 5:48 下午
 */
public class PublishUtilI {
    //服务接口集合
    private static List<Object> serviceList;
    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(5,10,10, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(10));

    public static void publish(int port,Object... services) throws IOException {
        serviceList= Arrays.asList(services);
        ServerSocket server = new ServerSocket(port);
        Socket client;
        while (true) {
            //阻塞等待请求
            client = server.accept();
            //使用线程池处理请求
            executor.submit(new ServerHandler(client, serviceList));
        }
    }

    public static void main(String[] args) throws IOException {
        CalculateService calculateService = new CalculateServiceImpl();
        publish(1111, calculateService);
    }

}
