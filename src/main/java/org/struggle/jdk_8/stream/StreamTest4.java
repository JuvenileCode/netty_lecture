package org.struggle.jdk_8.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Auther: Bin.L
 * @Date: 2019/3/3 21:23
 * @Description: Stream 分组与分区
 */
public class StreamTest4 {

    public static void main(String[] args) {

        Student student1 = new Student("zhangsan", 100, 20);
        Student student2 = new Student("lisi", 90, 20);
        Student student3 = new Student("wangwu", 90, 30);
        Student student4 = new Student("zhangsan", 80, 40);

        List<Student> students = Arrays.asList(student1, student2, student3, student4);

        Map<String, List<Student>> nameMap = students.stream().collect(Collectors.groupingBy(Student::getName));
        System.out.println(nameMap);

        Map<Integer, List<Student>> scopeMap = students.stream().collect(Collectors.groupingBy(Student::getScore));
        System.out.println(scopeMap);

        Map<String, Long> nameCountMap = students.stream().collect(Collectors.groupingBy(Student::getName, Collectors.counting()));
        System.out.println(nameCountMap);

        Map<String, Double> scopeAvgMap = students.stream().collect(Collectors.groupingBy(Student::getName, Collectors.averagingDouble(Student::getScore)));
        System.out.println(scopeAvgMap);

        Map<Boolean, List<Student>> partiScopeMap = students.stream().collect(Collectors.partitioningBy(student -> student.getScore() >= 90));
        System.out.println(partiScopeMap);


    }
}
