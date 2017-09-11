package io.khasang.moikaplus.dao;

import io.khasang.moikaplus.SpringBootWebApplication;
import io.khasang.moikaplus.entity.Person;
import io.khasang.moikaplus.entity.Phone;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootWebApplication.class)
@Transactional
@Commit
//@Rollback
public class OneToManyBidirectTest {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    PhoneRepository phoneRepository;

    Person person;
    List<Person> personList = new ArrayList<>();
    List<Phone> phoneList = new ArrayList<>();

    @Test
    @Transactional
    public void OneToManyBidirect() throws Exception {
        phoneRepository.deleteAll();
        personRepository.deleteAll();

        Person person = new Person("Ali Baba");
//        person = personRepository.save(person);
//        person = personRepository.findOne(person.getId());
        for (int i = 0; i < 3 ; i++) {
            person.addPhone(new Phone(null,"xxx" + i,person));
        }

        person = personRepository.save(person);

        personList.clear();
        phoneList.clear();
        personRepository.findAll().forEach(personList::add);
        phoneRepository.findAll().forEach(phoneList::add);
    }

}

