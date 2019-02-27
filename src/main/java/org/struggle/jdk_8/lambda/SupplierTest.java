package org.struggle.jdk_8.lambda;

import java.util.function.Supplier;

/**
 * @Auther: Bin.L
 * @Date: 2019/1/29 20:39
 * @Description: Lambda {@link Supplier} example
 */

public class SupplierTest {

    public static void main(String[] args) {

        Supplier<String> supplier = () -> "Hello Supplier";
        System.out.println(supplier.get());

        // ------------------------------------------------

        // 构造方法引用
        Supplier<Person> supplier2 = Person::new;


    }
}
