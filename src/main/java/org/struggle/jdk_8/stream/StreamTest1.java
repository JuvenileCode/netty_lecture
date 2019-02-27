package org.struggle.jdk_8.stream;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Auther: Bin.L
 * @Date: 2019/2/27 20:37
 * @Description: {@link java.util.stream.Stream} example
 */
public class StreamTest1 {

    public static void main(String[] args) {
        streamCreate();

        StreamInteger();

        List<Integer> integerList = Lists.newArrayList(2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println(integerList.stream().map(d -> d * 2).reduce(0, Integer::sum));
    }

    public static void StreamInteger() {
        IntStream.of(new int[]{5, 6, 7, 8, 9}).forEach(System.out::println);
        System.out.println("------------");
        IntStream.range(3, 8).forEach(System.out::println);
        System.out.println("------------");
    }

    public static void streamCreate() {
        //Stream Create the way

        Stream stream1 = Stream.of("wo", "shi", "ni");

        String[] myArray = new String[]{"de", "yi", "ge"};
        Stream stream2 = Stream.of(myArray);
        Stream stream3 = Arrays.stream(myArray);

        List<String> list = Lists.newArrayList("hao", "bu", "hao");
        Stream stream4 = list.stream();
    }
}
