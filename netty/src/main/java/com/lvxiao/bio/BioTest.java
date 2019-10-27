package com.lvxiao.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/10/27 7:14 下午
 */
class BioClient{

    private static Socket socket;
    private static InputStream inputStream;
    private static OutputStream outputStream;

    public static void main(String[] args) throws Exception{
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 500; i++) {
            socket = new Socket("127.0.0.1", 3608);
            outputStream = socket.getOutputStream();
            String str = "client -" + i;
            Charset charset = Charset.forName("utf-8");
            byte[] buffer = str.getBytes(charset);
            outputStream.write(buffer);
            outputStream.flush();
            inputStream = socket.getInputStream();
            byte[] fromServer = new byte[1024];
            int ren = inputStream.read(fromServer);
            int len = fromServer.length;
            String stssr = new String(fromServer, "utf-8");
            System.out.println(" ren:" + ren + " len:" + len + " stssr:" + stssr);
            outputStream.close();
            inputStream.close();
            inputStream = null;
            outputStream = null;
            socket.close();
            socket = null;
            fromServer = null;
        }
        long end = System.currentTimeMillis();
        long total = end - begin;
        System.out.println("Client-total:" + total);
    }
}
class BioServer {
    private static class Handler implements Runnable {
        private Socket socket;
        private InputStream inputStream;
        private OutputStream outputStream;

        public Handler() {
        }

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                inputStream = socket.getInputStream();
                outputStream = socket.getOutputStream();
                byte[] buffer = new byte[1024];
                int result = inputStream.read(buffer);
                String str = new String(buffer, "utf-8");
                System.err.println("from client info:" + str + "thread:" + Thread.currentThread().getId());
                String server = new String("from server：" + str);
                Charset cs = Charset.forName("utf-8");
                TimeUnit.MILLISECONDS.sleep(100);
                byte[] bytes = server.getBytes(cs);
                outputStream.write(bytes);
                outputStream.flush();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                try {
                    outputStream.close();
                    inputStream.close();
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

        }
    }
    private static ServerSocket serverSocket;
    private static Socket socket;
    private static ExecutorService executeService = Executors.newCachedThreadPool();

    static {
        System.out.println("server begin……");
        try {
            serverSocket = new ServerSocket(3608); // 等待客户端连接
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        while (true) {
            socket = serverSocket.accept(); // 这就是bio同步阻塞
            Handler handler = new Handler(socket);// 创建一个任务
            executeService.execute(handler);// 任务交给线程池
        }
    }
}

public class BioTest {
    public static void main(String[] args) {

    }
}
