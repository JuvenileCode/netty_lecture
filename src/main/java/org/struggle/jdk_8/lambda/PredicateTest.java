package org.struggle.jdk_8.lambda;

import java.util.function.Predicate;

/**
 * @Auther: Bin.L
 * @Date: 2019/1/28 20:52
 * @Description: Lambda {@link Predicate} example
 */
public class PredicateTest {

    public static void main(String[] args) {

        Predicate<String> predicate = p -> p.length() > 5;

        System.out.println(predicate.test("hello"));

    }
}
