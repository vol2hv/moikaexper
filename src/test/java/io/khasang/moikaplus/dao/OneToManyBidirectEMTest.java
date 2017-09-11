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
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootWebApplication.class)
@Transactional
//@Rollback
//@Commit
public class OneToManyBidirectEMTest {
    @PersistenceContext
    private EntityManager entityManager;


    Person person;
    List<Person> personList = new ArrayList<>();
    List<Phone> phoneList = new ArrayList<>();

    @Test
    public void OneToManyBidirect() throws Exception {
        entityManager.clear();

        Person person = new Person("Мадорин");
        Phone phone1 = new Phone( "123-456-7890" );
        Phone phone2 = new Phone( "321-654-0987" );

        person.addPhone( phone1 );
        person.addPhone( phone2 );
        entityManager.persist( person );
        entityManager.flush();

        person.removePhone( phone1 );
        entityManager.flush();
        entityManager.close();


    }

}
