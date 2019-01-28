package org.struggle.jdk_8.lambda;

import com.google.common.base.Objects;

/**
 * @Auther: Bin.L
 * @Date: 2019/1/28 20:07
 * @Description: 为测试创立的对象
 */
public class Person {

    private String username;

    private int age;

    public Person() {
    }

    public Person(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equal(username, person.username);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(username, age);
    }
}
