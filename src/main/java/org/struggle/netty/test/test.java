package org.struggle.netty.test;

import io.netty.util.internal.SystemPropertyUtil;

/**
 * @Auther: Bin.L
 * @Date: 2018/11/5 21:05
 * @Description:
 */
public class test {

    public static void main(String[] args) {

        //NioEventLoopGroup不指定线程数,默认的线程树代码实现
        int max = Math.max(1, SystemPropertyUtil.getInt(
                "io.netty.eventLoopThreads", Runtime.getRuntime().availableProcessors() * 2));
        System.out.println(max);

    }
}
