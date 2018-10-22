package org.struggle.proto.grpc;

import io.grpc.stub.StreamObserver;
import org.struggle.proto.*;

import java.util.UUID;

/**
 * @Auther: Bin.L
 * @Date: 2018/10/21 20:21
 * @Description:
 */
public class StudentTwoServiceImpl extends StudentServiceGrpc.StudentServiceImplBase {

    @Override
    public void getRealNameByUsername(MyRequest request, StreamObserver<MyResponse> responseObserver) {
        System.out.println("接受到客户端信息：" + request.getUsername());

        responseObserver.onNext(MyResponse.newBuilder().setRealname("张三").build());

        responseObserver.onCompleted();
    }

    @Override
    public void getStudentsByAge(StudentRequest request, StreamObserver<StudentResponse> responseObserver) {
        System.out.println("接受到客户端信息：" + request.getAge());
        //返回流式数据-实质时迭代器
        responseObserver.onNext(StudentResponse.newBuilder().setName("张三").setAge(20).setCity("北京").build());
        responseObserver.onNext(StudentResponse.newBuilder().setName("李四").setAge(22).setCity("上海").build());
        responseObserver.onNext(StudentResponse.newBuilder().setName("王五").setAge(23).setCity("长沙").build());
        responseObserver.onNext(StudentResponse.newBuilder().setName("赵六").setAge(24).setCity("成都").build());
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<StudentRequest> getStudentsWrapperByAges(StreamObserver<StudentResponseList> responseObserver) {
        return new StreamObserver<StudentRequest>() {

            /**
             * 客户端传Stream<T>参数解析模式
             * @param value
             */
            @Override
            public void onNext(StudentRequest value) {
                System.out.println("onNext:" + value.getAge());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                /**
                 * 当客户端参数接收完后调用此方法
                 */
                StudentResponse studentResponse = StudentResponse.newBuilder().setName("占三").setAge(20).setCity("西安").build();
                StudentResponse studentResponse2 = StudentResponse.newBuilder().setName("李四").setAge(22).setCity("西安").build();

                StudentResponseList list = StudentResponseList.newBuilder().addStudentResponse(studentResponse)
                        .addStudentResponse(studentResponse2).build();
                responseObserver.onNext(list);
                responseObserver.onCompleted();
            }

        };
    }

    @Override
    public StreamObserver<StreamRequest> biTalk(StreamObserver<StreamResponse> responseObserver) {

        return new StreamObserver<StreamRequest>() {
            @Override
            public void onNext(StreamRequest value) {
                System.out.println("onNext:" + value.getRequestInfo());

                responseObserver.onNext(StreamResponse.newBuilder().setResponseInfo(UUID.randomUUID().toString()).build());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }
}
