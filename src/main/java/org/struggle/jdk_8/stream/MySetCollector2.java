package org.struggle.jdk_8.stream;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @Auther: Bin.L
 * @Date: 2019/3/12 20:34
 * @Description: 自定义收集器2 - [Set<String> - Map<String,String>]
 */
public class MySetCollector2<T> implements Collector<T, Set<T>, Map<T, T>> {


    @Override
    public Supplier<Set<T>> supplier() {
        System.out.println("supplier invoked!");
        return HashSet::new;
    }

    @Override
    public BiConsumer<Set<T>, T> accumulator() {
        System.out.println("accumulator invoked!");
        return (ts, t) -> {
            /*
             *  枚举为Characteristics.CONCURRENT 打印 ts 有时会抛异常
             */
            // System.out.println("accumulator: " + ts + " " + Thread.currentThread().getName());

            System.out.println("accumulator:  " + Thread.currentThread().getName());
            ts.add(t);
        };
        // return Set::add;
    }

    @Override
    public BinaryOperator<Set<T>> combiner() {
        System.out.println("combiner invoked!");
        return (set1, set2) -> {
            set1.addAll(set2);
            return set1;
        };
    }

    @Override
    public Function<Set<T>, Map<T, T>> finisher() {
        System.out.println("finisher invoked!");

        /*return set -> {
            Map<T, T> map = new HashMap<>();
            set.stream().forEach(d -> map.put(d, d));
            return map;
        };*/

        return set -> set.stream().collect(Collectors.toMap(o -> o, o -> o));
    }

    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("characteristics invoked!");
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.UNORDERED,Characteristics.CONCURRENT));
        // return Collections.unmodifiableSet(EnumSet.of(Characteristics.UNORDERED));
    }

    public static void main(String[] args) {
        /*
          Characteristics.IDENTITY_FINISH 属性加上数据会直接执行强制类型转换，不会执行finisher方法；当然，如果数据类型不一致会抛异常
         */

        List<String> list = Lists.newArrayList("hello", "world", "hello", "a", "b", "c", "d", "e", "welcome");

        /*
            Characteristics.CONCURRENT 属性加上，在并发执行是多个线程有多个中间容器并在最后执行combiner方法合并数据
            反之，并发执行多个线程对一个中间容器执行操作，最后无需执行combiner方法。
         */

        Map<String, String> convMap = list.stream().collect(new MySetCollector2<>());

        // Map<String, String> convMap = list.parallelStream().collect(new MySetCollector2<>());

        System.out.println(convMap);
    }
}
