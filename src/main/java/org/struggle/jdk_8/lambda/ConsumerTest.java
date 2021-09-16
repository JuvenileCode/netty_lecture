package org.struggle.jdk_8.lambda;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

/**
 * @auther: Bin.L
 * @date: 2019-04-10 21:46
 * @Description:
 */
public class ConsumerTest {

    public void test(Consumer<Integer> consumer) {
        consumer.accept(100);
    }

    public static void main(String[] args) {
        ConsumerTest consumerTest = new ConsumerTest();

        Consumer<Integer> consumer = i -> System.out.println(i);
        IntConsumer intConsumer = i -> System.out.println(i);

        System.out.println((consumer instanceof Consumer) + " " + (intConsumer instanceof IntConsumer));
        // 面向对象方式
        consumerTest.test(consumer);
        // 传递行为，函数式方式
        consumerTest.test(consumer::accept);
        consumerTest.test(intConsumer::accept);
    }
}
