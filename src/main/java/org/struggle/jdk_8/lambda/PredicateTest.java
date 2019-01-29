package org.struggle.jdk_8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @Auther: Bin.L
 * @Date: 2019/1/28 20:52
 * @Description: Lambda {@link Predicate} example
 */
public class PredicateTest {

    public static void main(String[] args) {
        PredicateTest predicateTest = new PredicateTest();

        Predicate<String> predicate = p -> p.length() > 5;
        System.out.println(predicate.test("hello"));
        System.out.println(predicate.test("I live you"));

        // -------------------------------------------------

        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        predicateTest.conditionFilter(intList, d -> d > 5);
        predicateTest.conditionFilterGeneric(intList, d -> d % 2 == 0);

        // -------------------------------------------------



    }

    private void conditionFilter(List<Integer> list, Predicate<Integer> predicate) {
        list.stream().filter(predicate).forEach(System.out::println);
        //list.stream().filter(d -> d % 2 == 0).forEach(System.out::println);
    }

    private <T> void conditionFilterGeneric(List<T> list,Predicate<T> predicate){
        list.stream().filter(predicate).forEach(System.out::println);
    }



}
