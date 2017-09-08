package io.khasang.moikaplus.dao;

import io.khasang.moikaplus.SpringBootWebApplication;
import io.khasang.moikaplus.entity.Person;
import io.khasang.moikaplus.entity.Phone;
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
//@Transactional
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
    public void OneToManyBidirect() throws Exception {
        phoneRepository.deleteAll();
        personRepository.deleteAll();

        Person person = new Person();
        person.setName("Ivanov");
        phoneList.add(new Phone(0l,"001",person));
        phoneList.add(new Phone(0l,"002",person));
        person.setPhones(phoneList);
        person = personRepository.save(person);

        personList.clear();
        phoneList.clear();
        personRepository.findAll().forEach(personList::add);
        phoneRepository.findAll().forEach(phoneList::add);
    }

}

//    BookCategory categoryA = new BookCategory("Category A");
//    Set bookAs = new HashSet<Book>(){{
//        add(new Book("Book A1", categoryA));
//        add(new Book("Book A2", categoryA));
//        add(new Book("Book A3", categoryA));
//    }};
//        categoryA.setBooks(bookAs);
//
//                BookCategory categoryB = new BookCategory("Category B");
//                Set bookBs = new HashSet<Book>(){{
//        add(new Book("Book B1", categoryB));
//        add(new Book("Book B2", categoryB));
//        add(new Book("Book B3", categoryB));
//        }};
//        categoryB.setBooks(bookBs);
//
//        bookCategoryRepository.save(new HashSet<BookCategory>() {{
//        add(categoryA);
//        add(categoryB);
//        }});
