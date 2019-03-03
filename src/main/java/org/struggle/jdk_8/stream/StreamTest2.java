package org.struggle.jdk_8.stream;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Auther: Bin.L
 * @Date: 2019/2/28 21:47
 * @Description:
 */
public class StreamTest2 {

    public static void main(String[] args) {
        collectMenthod();
        System.out.println("--------------------------");
        mapMenthod();
        System.out.println("--------------------------");
        complexMenthod();
        System.out.println("--------------------------");

        List<String> strList = Lists.newArrayList("hello", "world", "yuw", "test");
        strList.stream().map(str -> str.substring(0, 1).toUpperCase() + str.substring(1)).forEach(System.out::println);
        strList.stream().map(str -> {
            String result = str.substring(0, 1).toUpperCase() + str.substring(1);
            System.out.println("<<---------->>");
            return result;
        }).forEach(System.out::println);

        // IntStream.iterate(0,i->(i+1)%2).distinct().limit(6).forEach(System.out::println);
        IntStream.iterate(0,i->(i+1)%2).limit(6).distinct().forEach(System.out::println);


    }

    public static void complexMenthod() {
        Stream<String> stream = Stream.generate(UUID.randomUUID()::toString);
        // Stream<String> stream = Stream.empty();
        System.out.println(stream.findFirst().orElse("no"));

        Stream.iterate(1, item -> item + 1).limit(6).forEach(System.out::println);

        System.out.println(Stream.iterate(1, item -> item + 2).limit(6).filter(d -> d > 2).mapToInt(d -> d * 2).skip(2).limit(2).sum());
        System.out.println(Stream.iterate(1, item -> item + 2).limit(6).filter(d -> d > 2).mapToInt(d -> d * 2).skip(2).limit(2).min().orElse(0));
        IntSummaryStatistics summaryStatistics = Stream.iterate(1, item -> item + 2).limit(6).filter(d -> d > 2).mapToInt(d -> d * 2).skip(2).limit(2).summaryStatistics();
        System.out.println(summaryStatistics.getCount() + " " + summaryStatistics.getMin() + " " + summaryStatistics.getMax());
    }

    public static void mapMenthod() {
        List<String> lista = Lists.newArrayList("hello", "world", "yuw", "test");
        lista.stream().map(String::toUpperCase).forEach(System.out::println);

        List<List<Integer>> intList = Lists.newArrayList(Arrays.asList(4, 5), Arrays.asList(6, 2));
        System.out.println(intList.stream().flatMap(integers -> integers.stream()).map(d -> String.valueOf(d * d)).collect(Collectors.joining(":")));
    }

    public static void collectMenthod() {
        Stream<String> stream = Stream.of("hello", "world", "yuw");
        String[] strings = stream.toArray(length -> new String[length]);

        Stream<String> stream2 = Stream.of("hello", "world", "yuw");
        String[] stringsRefer = stream2.toArray(String[]::new);

        Stream<String> stream3 = Stream.of("hello", "world", "yuw");
        // List<String> stringList1 = stream3.collect(Collectors.toList());
        List<String> stringList2 = stream3.collect(() -> new ArrayList<>()
                , (l1, d) -> l1.add(d)
                , (l1, l2) -> l1.addAll(l2));
        //List<String> stringList3 = stream3.collect(LinkedList::new, LinkedList::add, LinkedList::addAll);

        Stream<String> stream4 = Stream.of("hello", "world", "yuw");
        List<String> stringList4 = stream4.collect(Collectors.toCollection(LinkedList::new));


        Stream<String> stream5 = Stream.of("hello", "world", "yuw");
        // Set<String> stringSet1 = stream5.collect(Collectors.toSet());
        Set<String> stringSet1 = stream5.collect(Collectors.toCollection(TreeSet::new));

        Stream<String> stream6 = Stream.of("hello", "world", "yuw");
        // String str = stream6.collect(Collectors.joining());
        String str = stream6.collect(Collectors.joining(":"));
        System.out.println(str);
    }
}
