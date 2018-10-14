package org.struggle.netty.sixthexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.struggle.protobuf.DataInfo;

import java.util.Random;

/**
 * @Auther: Bin.L
 * @Date: 2018/10/13 21:38
 * @Description:
 */
public class TestClientHandler extends SimpleChannelInboundHandler<DataInfo.MyMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DataInfo.MyMessage msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        int randomInt = new Random().nextInt(3);
        DataInfo.MyMessage myMessage = null;
        if (0 == randomInt) {
            myMessage = DataInfo.MyMessage.newBuilder()
                    .setDataType(DataInfo.MyMessage.DataType.StudentType)
                    .setStudent(DataInfo.Student.newBuilder().setName("张三").setAge(22).setAddress("北京").build())
                    .build();
        } else if (1 == randomInt) {
            myMessage = DataInfo.MyMessage.newBuilder()
                    .setDataType(DataInfo.MyMessage.DataType.DogType)
                    .setDog(DataInfo.Dog.newBuilder().setName("小白").setAge(3).build())
                    .build();
        } else {
            myMessage = DataInfo.MyMessage.newBuilder()
                    .setDataType(DataInfo.MyMessage.DataType.CatType)
                    .setCat(DataInfo.Cat.newBuilder().setCity("上海").setName("hah").build())
                    .build();
        }

        ctx.channel().writeAndFlush(myMessage);
    }
}
