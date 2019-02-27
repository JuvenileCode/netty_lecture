package org.struggle.jdk_8.optional;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.Optional;

/**
 * @Auther: Bin.L
 * @Date: 2019/2/24 17:18
 * @Description:
 */
public class OptionalTest2 {

    public static void main(String[] args) {

        Employee employee1 = new Employee();
        employee1.setName("zhangsan");

        Employee employee2 = new Employee();
        employee1.setName("lisi");

        Company company = new Company();
        company.setName("company1");
        company.setEmployees(Lists.newArrayList(employee1, employee2));

        Optional<Company> optional = Optional.ofNullable(company);
        System.out.println(optional.map(d -> d.getEmployees()).orElse(Collections.emptyList()));


    }
}
