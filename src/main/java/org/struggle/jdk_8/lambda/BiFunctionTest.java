package org.struggle.jdk_8.lambda;

import java.util.function.BiFunction;

/**
 * @Auther: Bin.L
 * @Date: 2019/1/26 20:52
 * @Description: Lambda {@link java.util.function.BiFunction} example
 */
public class BiFunctionTest {

    public static void main(String[] args) {

        BiFunctionTest biFunctionTest = new BiFunctionTest();

        // Function 只有一个输入参数，BiFunction可以带二个输入参数
        System.out.println(biFunctionTest.operatingInt(4, 5, (a, b) -> a * b));

        System.out.println(biFunctionTest.operating("hello", "world", (a, b) -> a.toUpperCase() + b.toUpperCase()));


    }


    private int operatingInt(int a, int b, BiFunction<Integer, Integer, Integer> biFunction) {
        return biFunction.apply(a, b);
    }

    private <T> T operating(T a, T b, BiFunction<T, T, T> biFunction) {
        return biFunction.apply(a, b);
    }

}
