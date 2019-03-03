package org.struggle.jdk_8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: Bin.L
 * @Date: 2019/3/3 20:21
 * @Description: 并发流
 */
public class StreamTest3 {

    public static void main(String[] args) {
        // parallelStream();
        System.out.println("----------------");

        List<String> list = Arrays.asList("hello", "world", "hello world");
        list.stream().filter(s -> s.length() == 5).limit(1).mapToInt(String::length).forEach(System.out::println);

        List<String> list2 = Arrays.asList("hello welcome", "world hello", "hello world hello","hello welcome");
        list2.stream().flatMap( s -> Arrays.stream(s.split(" "))).distinct().forEach(System.out::println);


        List<String> list3 = Arrays.asList("Hi","Hello","您好");
        List<String> list4 = Arrays.asList("zhangsan","lisi","wangwu","zhaoliu");
        list3.stream().flatMap(item -> list4.stream().map(item2 -> item + " "+item2)).forEach(System.out::println);

    }

    public static void parallelStream() {
        List<String> list = new ArrayList<>(5000000);
        for (int i = 0; i < 5000000; i++) {
            list.add(UUID.randomUUID().toString());
        }
        System.out.println("开始排序");

        long startTime = System.nanoTime();
        // list.stream().sorted().count();
        list.parallelStream().sorted().count();
        long endTime = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
        System.out.println("排序耗时:" + millis);
    }
}
