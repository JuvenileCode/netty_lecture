package org.struggle.thrift;

import org.apache.thrift.TException;
import org.struggle.thrift.generated.DataException;
import org.struggle.thrift.generated.Person;
import org.struggle.thrift.generated.PersonService;

/**
 * @Auther: Bin.L
 * @Date: 2018/10/15 21:54
 * @Description: 实现thrift定义的接口
 */
public class PersonServiceImpl implements PersonService.Iface {
    @Override
    public Person getPersionByUsername(String username) throws DataException, TException {
        System.out.println("Got Client Param:" + username);
        Person person = new Person();
        person.setAge(20);
        person.setUsername(username);
        person.setMarried(false);

        return person;

    }

    @Override
    public void savePerson(Person person) throws DataException, TException {
        System.out.println("Got Client Param: ");
        System.out.println(person.getAge() + " " + person.getUsername() + " " + person.isMarried());
    }
}
