package org.struggle.netty.sixthexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.struggle.protobuf.DataInfo;

/**
 * @Auther: Bin.L
 * @Date: 2018/10/13 21:24
 * @Description:
 */
public class TestServerHandler extends SimpleChannelInboundHandler<DataInfo.MyMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DataInfo.MyMessage msg) throws Exception {
        DataInfo.MyMessage.DataType dataType = msg.getDataType();
        if (dataType == DataInfo.MyMessage.DataType.StudentType) {
            DataInfo.Student student = msg.getStudent();
            System.out.println(student.getName() + " " + student.getAge() + " " + student.getAddress());
        } else if (dataType == DataInfo.MyMessage.DataType.DogType) {
            DataInfo.Dog dog = msg.getDog();
            System.out.println(dog.getName() + " " + dog.getAge());
        } else {
            DataInfo.Cat cat = msg.getCat();
            System.out.println(cat.getName() + " " + cat.getCity());
        }
    }
}
