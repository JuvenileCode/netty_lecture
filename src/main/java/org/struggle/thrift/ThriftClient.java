package org.struggle.thrift;

import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.struggle.thrift.generated.Person;
import org.struggle.thrift.generated.PersonService;

/**
 * @Auther: Bin.L
 * @Date: 2018/10/15 22:04
 * @Description:
 */
public class ThriftClient {

    public static void main(String[] args) {
        //数据传输格式和传输方式要与Server端保持一致
        TTransport transport = new TFramedTransport(new TSocket("localhost", 8899), 600);
        TProtocol protocol = new TCompactProtocol(transport);
        PersonService.Client client = new PersonService.Client(protocol);

        try {
            transport.open();
            Person person = client.getPersionByUsername("张三");
            System.out.println(person.getUsername() + " " + person.getAge() + " " + person.isMarried());

            System.out.println("---------");
            person.setAge(20);
            person.setUsername("李四");
            person.setMarried(true);
            client.savePerson(person);

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            transport.close();
        }
    }
}
