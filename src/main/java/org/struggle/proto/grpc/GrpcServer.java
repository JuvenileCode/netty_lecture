package org.struggle.proto.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;

/**
 * @Auther: Bin.L
 * @Date: 2018/10/21 20:28
 * @Description:
 */
public class GrpcServer {

    private Server server;

    private void start() throws Exception {
        this.server = ServerBuilder.forPort(7799).addService(new StudentTwoServiceImpl()).build().start();
        System.out.println("server started");

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("关闭jvm");
            GrpcServer.this.stop();
        }));
        System.out.println("执行到这里");
    }

    private void stop() {
        if (null != this.server) {
            this.server.shutdown();
        }
    }

    private void awaitTermination() throws Exception {
        if (this.server != null) {
            this.server.awaitTermination();
        }
    }

    public static void main(String[] args) throws Exception {
        GrpcServer server = new GrpcServer();
        server.start();
        server.awaitTermination();
    }

}
