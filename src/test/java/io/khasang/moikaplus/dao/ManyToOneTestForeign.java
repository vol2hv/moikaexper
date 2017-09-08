package io.khasang.moikaplus.dao;

import io.khasang.moikaplus.SpringBootWebApplication;
import io.khasang.moikaplus.entity.Person;
import io.khasang.moikaplus.entity.Phone;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootWebApplication.class)
@Transactional
@Rollback
public class ManyToOneTest {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    PhoneRepository phoneRepository;

    Person person;
    Phone [] phones = new Phone[2];
    List<Person> personList = new ArrayList<>();
    List<Phone> phoneList = new ArrayList<>();

    @Test
    public void ManyToOne() throws Exception {
        phoneRepository.deleteAll();
        personRepository.deleteAll();

//        Person person = new Person(0l,"Ivanov");
        person = personRepository.save(person);
        for (int i = 0; i <2 ; i++) {
            phones[i] = new Phone(0l, "000000000"+Integer.toString(i+1),person );
            phones[i] = phoneRepository.save(phones[i]);
        }


//        personList.clear();
//        phoneList.clear();
        personRepository.findAll().forEach(personList::add);
        phoneRepository.findAll().forEach(phoneList::add);
    }

}