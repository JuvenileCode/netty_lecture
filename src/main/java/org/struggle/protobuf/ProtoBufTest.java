package org.struggle.protobuf;

/**
 * @Description
 * @Author Bin.Liu
 * @Date 2018/10/13 20:22
 */
public class ProtoBufTest {

    public static void main(String[] args) throws Exception {
        DataInfo.Student student = DataInfo.Student.newBuilder()
                .setName("zhangsan").setAge(25).setAddress("Beijing").build();

        byte[] student2ByteArray = student.toByteArray();
        DataInfo.Student student2 = DataInfo.Student.parseFrom(student2ByteArray);
        System.out.println(student2);
    }
}
