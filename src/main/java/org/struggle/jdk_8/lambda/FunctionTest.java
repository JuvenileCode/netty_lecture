package org.struggle.jdk_8.lambda;

import java.util.function.Function;

/**
 * @Auther: Bin.L
 * @Date: 2019/1/26 16:46
 * @Description: Lambda {@link Function} example
 */
public class FunctionTest {

    public static void main(String[] args) {
        FunctionTest functionTest = new FunctionTest();
        System.out.println(functionTest.comput(5, v -> 5 * 2));

        System.out.println(functionTest.comput2("Hellow", s -> s.toUpperCase()));

        // method Reference Transfer
        System.out.println(functionTest.comput2("Hellow", String::toUpperCase));

        System.out.println(functionTest.comput3(2, v -> v * 3, v -> v * v));

        System.out.println(functionTest.comput4(2, v -> v * 3, v -> v * v));

    }


    private int comput(int digital, Function<Integer, Integer> function) {
        return function.apply(digital);
    }

    private <T> T comput2(T a, Function<T, T> function) {
        return function.apply(a);
    }

    private int comput3(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        return function1.compose(function2).apply(a);
    }

    private int comput4(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        return function1.andThen(function2).apply(a);
    }

}
