package org.struggle.jdk_8.lambda;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * @Auther: Bin.L
 * @Date: 2019/1/28 20:10
 * @Description:
 */
public class PersonTest {

    public static void main(String[] args) {
        Person person1 = new Person("zhangsan", 20);
        Person person2 = new Person("lisi", 30);
        Person person3 = new Person("wangwu", 40);

        List<Person> personList = Lists.newArrayList(person1, person2, person3);

        PersonTest personTest = new PersonTest();

        personTest.getPersonByUsername("zhangsan", personList).forEach(System.out::println);


        personTest.getPersonList("lisi", personList, (u, o) -> o.stream().filter(oa -> oa.getUsername().equals(u)).collect(Collectors.toList()))
        .forEach(System.out::println);

    }

    private List<Person> getPersonByUsername(String username, List<Person> personList) {

        return personList.stream().filter(u -> u.getUsername().equals(username)).collect(Collectors.toList());
    }

    private List<Person> getPersonList(String user, List<Person> personList, BiFunction<String, List<Person>, List<Person>> psersonFunction) {
        return psersonFunction.apply(user, personList);
    }
}


















