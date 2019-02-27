package org.struggle.jdk_8.optional;

import java.util.List;

/**
 * @Auther: Bin.L
 * @Date: 2019/2/24 17:16
 * @Description:
 */
public class Company {

    private String name;

    private List<Employee> employees;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
