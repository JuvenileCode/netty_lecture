package org.struggle.jdk_8.lambda;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Auther: Bin.L
 * @Date: 2019/2/25 20:04
 * @Description: 方法引用
 */
public class MethodReferenceDemo {

    public static void main(String[] args) {

        mrTest1();

        mrTest2();

    }

    public static void mrTest2() {
        Person p1 = new Person("zhangsan", 16);
        Person p2 = new Person("lisi", 24);
        Person p3 = new Person("wangwu", 33);
        Person p4 = new Person("zhaoliu", 12);
        List<Person> personList = Lists.newArrayList(p1, p2, p3, p4);
        personList.sort((p11, p22) -> Person.comparePersonByName(p11, p22));

        System.out.println("----------------------");

        //类名::静态方法
        personList.sort(Person::comparePersonByAge);

        //引用名(对象名)::实例方法名
        personList.stream().map(Person::getUsername).forEach(System.out::println);

        System.out.println("----------------------");

        //类名::实例方法名
        personList.sort(Person::compareByAge);

        List<String> cityList = Lists.newArrayList("tianjing", "shanghai", "beijing", "chongqi");
        // Collections.sort(cityList, (c1, c2) -> c1.compareToIgnoreCase(c2));
        // cityList.forEach(System.out::println);
        Collections.sort(cityList, String::compareToIgnoreCase);
        System.out.println("----------------------");

        //类名::new
        MethodReferenceDemo methodReferenceDemo = new MethodReferenceDemo();
        System.out.println(methodReferenceDemo.getString(String::new));
        System.out.println(methodReferenceDemo.getString2("Hello", String::new));

    }


    public static void mrTest1() {
        List<String> list = Arrays.asList("hello", "world", "hello world");

        // list.forEach( d -> System.out.println(d));

        list.forEach(System.out::println);
    }

    public String getString(Supplier<String> supplier) {
        return supplier.get() + "test";
    }

    public String getString2(String str1, Function<String, String> function) {
        return function.apply(str1);
    }
}
