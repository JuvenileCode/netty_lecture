package org.struggle.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: Bin.L
 * @Date: 2018/10/31 21:36
 * @Description:
 */
public class NioClient {

    public static void main(String[] args) {

        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);

            Selector selector = Selector.open();
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
            socketChannel.connect(new InetSocketAddress("127.0.0.1", 9977));

            while (true) {
                selector.select();
                Set<SelectionKey> ketSet = selector.selectedKeys();
                ketSet.forEach(selectionKey -> {
                    if (selectionKey.isConnectable()) {
                        SocketChannel client = (SocketChannel) selectionKey.channel();
                        //判断链接是否处于活动状态
                        if (client.isConnectionPending()) {
                            try {
                                client.finishConnect();
                                ByteBuffer writeBuffer = ByteBuffer.allocate(512);
                                writeBuffer.put((LocalDateTime.now().toString() + "链接成功").getBytes());
                                writeBuffer.flip();
                                client.write(writeBuffer);
                                //新起线程-用户输入
                                ExecutorService executorService = Executors.newSingleThreadExecutor(Executors.defaultThreadFactory());
                                executorService.submit(() -> {
                                    while (true) {
                                        writeBuffer.clear();
                                        InputStreamReader input = new InputStreamReader(System.in);
                                        BufferedReader br = new BufferedReader(input);
                                        String sendMessage = br.readLine();

                                        writeBuffer.put(sendMessage.getBytes());
                                        writeBuffer.flip();
                                        client.write(writeBuffer);
                                    }
                                });
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });

            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
