package org.struggle.thrift;

import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.struggle.thrift.generated.PersonService;

/**
 * @Auther: Bin.L
 * @Date: 2018/10/15 21:59
 * @Description:
 */
public class ThriftServer {

    public static void main(String[] args) throws Exception {
        TNonblockingServerSocket socket = new TNonblockingServerSocket(8899);
        THsHaServer.Args arg = new THsHaServer.Args(socket).minWorkerThreads(2).maxWorkerThreads(4);
        PersonService.Processor<PersonServiceImpl> processor = new PersonService.Processor<>(new PersonServiceImpl());
        //数据传输的格式
        arg.protocolFactory(new TCompactProtocol.Factory());
        //数据传输的方式
        arg.transportFactory(new TFramedTransport.Factory());
        arg.processorFactory(new TProcessorFactory(processor));
        //服务模型
        TServer server = new THsHaServer(arg);
        System.out.println("Thrift Service Started...");
        server.serve();
    }
}
