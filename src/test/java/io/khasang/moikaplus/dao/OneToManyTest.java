package io.khasang.moikaplus.dao;

import io.khasang.moikaplus.SpringBootWebApplication;
import io.khasang.moikaplus.entity.Person;
import io.khasang.moikaplus.entity.Phone;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootWebApplication.class)
@Transactional
@Commit
//@Rollback
public class OneToManyTest {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    PhoneRepository phoneRepository;

    Person person;
    List<Person> personList = new ArrayList<>();
    List<Phone> phoneList = new ArrayList<>();

    @Test
    @Transactional
    public void OneToMany() throws Exception {
        phoneRepository.deleteAll();
        personRepository.deleteAll();

        Person person = new Person("Baba Yaga");

            for (int i = 0; i < 3 ; i++) {
                person.getPhones().add(new Phone("xxx"+i));
            }

        person = personRepository.save(person);

        personList.clear();
        phoneList.clear();
        personRepository.findAll().forEach(personList::add);
        phoneRepository.findAll().forEach(phoneList::add);
    }

}

