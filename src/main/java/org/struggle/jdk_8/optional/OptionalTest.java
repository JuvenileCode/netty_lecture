package org.struggle.jdk_8.optional;

import java.util.Optional;

/**
 * @Auther: Bin.L
 * @Date: 2019/2/24 16:58
 * @Description: {@link java.util.Optional} example
 */
public class OptionalTest {

    public static void main(String[] args) {
        Optional<String> optional = Optional.of("hello");

        Optional<String> optional2 = Optional.empty();


        if (optional.isPresent()) {
            System.out.println(optional.get());
        }

        // -----------------------推荐Optional使用方式

        optional.ifPresent(item -> System.out.println(item));

        System.out.println(optional2.orElse("好人"));
        System.out.println(optional2.orElseGet(() -> "每天都要前进"));

    }

}
