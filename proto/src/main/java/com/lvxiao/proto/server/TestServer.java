package com.lvxiao.proto.server;

import com.lvxiao.proto.GreeterGrpc;
import com.lvxiao.proto.HelloReply;
import com.lvxiao.proto.HelloRequest;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import lombok.SneakyThrows;

/**
 * @author lvxiao
 * @date 2020/8/18
 */
public class TestServer {
    public static class Greeter extends GreeterGrpc.GreeterImplBase {
        @Override
        public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
            System.out.println(request);
            System.out.println("aaaaaaaaa");
        }
    }
    @SneakyThrows
    public static void main(String[] args) {
        Server server = ServerBuilder.forPort(8080)
                .addService(new Greeter()).build();
        System.out.println("start server....");
        server.start();
        System.out.println("Server started!");
        server.awaitTermination();
    }
}
