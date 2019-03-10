package org.struggle.jdk_8.stream;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Auther: Bin.L
 * @Date: 2019/3/10 15:57
 * @Description: {@link Comparator} example
 */
public class MyComparatorTest {

    public static void main(String[] args) {

        List<String> list = Lists.newArrayList("nihao","hello","world","welcome");

        // 升序排序
        //Collections.sort(list);

        // 字符串长度升序排序
        // Collections.sort(list,(o1, o2) -> o1.length() - o2.length());
        // 方法引用形式
        // Collections.sort(list,Comparator.comparingInt(String::length));
        // 取反-字符串长度降序排序
        // Collections.sort(list,Comparator.comparingInt(String::length).reversed());


        // list.sort(Comparator.comparingInt(String::length));
        // list.sort(Comparator.comparingInt(String::length).reversed());

        // 多层排序

        // list.sort(Comparator.comparingInt(String::length).thenComparing(String.CASE_INSENSITIVE_ORDER));

        // list.sort(Comparator.comparingInt(String::length).thenComparing(String::compareToIgnoreCase));
        list.sort(Comparator.comparingInt(String::length).thenComparing(String::toLowerCase,Comparator.reverseOrder()));
        System.out.println(list);


    }
}
