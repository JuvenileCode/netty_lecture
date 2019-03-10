package org.struggle.jdk_8.stream;

import com.google.common.collect.Lists;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Auther: Bin.L
 * @Date: 2019/3/4 20:19
 * @Description: {@link java.util.stream.Collector} example
 */
public class StreamThoroughTest1 {

    public static void main(String[] args) {
        Student s1 = new Student("zhangsan", 80);
        Student s2 = new Student("lisi", 90);
        Student s3 = new Student("wangwu", 100);
        Student s4 = new Student("zhaoliu", 90);
        Student s5 = new Student("zhaoliu", 90);

        List<Student> studentList = Lists.newArrayList(s1, s2, s3, s4, s5);

        List<Student> studentStream1 = studentList.stream().collect(Collectors.toList());
        studentStream1.forEach(System.out::println);

        System.out.println("----------------------------");
        //collect JDK8 stream很重要

        System.out.println("count: " + studentList.stream().collect(Collectors.counting()));
        System.out.println("count: " + studentList.stream().count());

        /*
        collect : 收集器 / Collector 为collect方法的参数
        Collector是一个接口,它是一个可变的汇聚操作,将输入元素累积到一个可变的结果容器中；它会将所有元素处理完毕后,
        将累积的结果转换为一个最终的表示(这是一个可选操作)；它支持串行与并行。
        Collectors本身提供了关于Collector的常见汇聚实现,Collectors本身实际上是一个工厂。
        */


        // 找到最小值
        studentList.stream().collect(Collectors.minBy(Comparator.comparingInt(Student::getScore))).ifPresent(System.out::println);
        // 找到最大值
        studentList.stream().collect(Collectors.maxBy(Comparator.comparingInt(Student::getScore))).ifPresent(System.out::println);
        // 平均值
        System.out.println(studentList.stream().collect(Collectors.averagingDouble(Student::getScore)));
        // 分数总和
        System.out.println(studentList.stream().collect(Collectors.summingInt(Student::getScore)));


        System.out.println("----------------------------");
        // 字符串拼接
        System.out.println(studentList.stream().map(Student::getName).collect(Collectors.joining(",")));
        System.out.println("----------------------------");

        // 多级分组
        Map<Integer, Map<String, List<Student>>> duoGroup = studentList.stream().collect(Collectors.groupingBy(Student::getScore, Collectors.groupingBy(Student::getName)));
        System.out.println(duoGroup);

        System.out.println(studentList.stream().collect(Collectors.partitioningBy(d -> d.getScore() > 80)));

        System.out.println(studentList.stream().collect(Collectors.partitioningBy(d -> d.getScore() > 80, Collectors.summingInt(Student::getScore))));

        System.out.println(studentList.stream().collect(Collectors.groupingBy(Student::getName, Collectors.collectingAndThen(Collectors
                .minBy(Comparator.comparingInt(Student::getScore)), Optional::get))));

    }
}
