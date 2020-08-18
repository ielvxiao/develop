package com.lvxiao.proto.client;

import com.lvxiao.proto.GreeterGrpc;
import com.lvxiao.proto.HelloReply;
import com.lvxiao.proto.HelloRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * @author lvxiao
 * @date 2020/8/18
 */
public class TestClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();
        GreeterGrpc.GreeterBlockingStub stub = GreeterGrpc.newBlockingStub(channel);
        HelloReply reply = stub.sayHello(HelloRequest
                .newBuilder()
                .setName("a")
                .build());
        System.out.println(reply);
        channel.shutdown();
    }
}
