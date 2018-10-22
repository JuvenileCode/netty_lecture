package org.struggle.proto.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.struggle.proto.*;

import java.time.LocalDateTime;
import java.util.Iterator;

/**
 * @Auther: Bin.L
 * @Date: 2018/10/21 20:37
 * @Description:
 */
public class GrpcClient {

    public static void main(String[] args) {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 7799).usePlaintext().build();
        //阻塞方式
        StudentServiceGrpc.StudentServiceBlockingStub blockingStub = StudentServiceGrpc.newBlockingStub(managedChannel);
        MyResponse myResponse = blockingStub.getRealNameByUsername(MyRequest.newBuilder().setUsername("zhangsan").build());
        System.out.println(myResponse.getRealname());

        System.out.println("----------------------");
        //返回参数为stream<T>
        Iterator<StudentResponse> iter = blockingStub.getStudentsByAge(StudentRequest.newBuilder().setAge(20).build());
        while (iter.hasNext()) {
            StudentResponse studentResponse = iter.next();
            System.out.println(studentResponse.getName() + " " + studentResponse.getAge() + " " + studentResponse.getCity());
        }


        System.out.println("----------------------");
        //传输参数为stream<T>
        /*StreamObserver<StudentResponseList> slo = new StreamObserver<StudentResponseList>() {
            @Override
            public void onNext(StudentResponseList value) {
                value.getStudentResponseList().forEach(studentResponse -> {
                    System.out.println(studentResponse.getName() + " " + studentResponse.getAge() + " " + studentResponse.getCity());
                });
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("completed!");
            }
        };
        //异步方式-客户端传输Stream<T>必须用异步
        StudentServiceGrpc.StudentServiceStub stub = StudentServiceGrpc.newStub(managedChannel);

        StreamObserver<StudentRequest> sr = stub.getStudentsWrapperByAges(slo);
        sr.onNext(StudentRequest.newBuilder().setAge(20).build());
        sr.onNext(StudentRequest.newBuilder().setAge(30).build());
        sr.onNext(StudentRequest.newBuilder().setAge(40).build());
        sr.onNext(StudentRequest.newBuilder().setAge(50).build());
        sr.onNext(StudentRequest.newBuilder().setAge(60).build());
        sr.onCompleted();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        //双向流式传递
        StudentServiceGrpc.StudentServiceStub stub = StudentServiceGrpc.newStub(managedChannel);
        StreamObserver<StreamRequest> bisq = stub.biTalk(new StreamObserver<StreamResponse>() {
            @Override
            public void onNext(StreamResponse value) {
                System.out.println(value.getResponseInfo());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("completed!");
            }
        });

        for (int i = 0; i < 10; i++) {
            bisq.onNext(StreamRequest.newBuilder().setRequestInfo(LocalDateTime.now().toString()).build());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
