package io.khasang.moikaplus.dao;

import io.khasang.moikaplus.SpringBootWebApplication;
import io.khasang.moikaplus.entity.Address;
import io.khasang.moikaplus.entity.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootWebApplication.class)
@Transactional
@Commit
//@Rollback
public class ManyToManyBidirectTest {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    AddressRepository addressRepository;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void ManyToMany() throws Exception {
        Person person1 = new Person("ABC-123", "Мадорин");
        Person person2 = new Person("DEF-456", "Путин");

        Address address1 = new Address("12th Avenue", "12A", "4005A");
        Address address2 = new Address("18th Avenue", "18B", "4007B");

        person1.addAddress(address1);
        person1.addAddress(address2);

        person2.addAddress(address1);

        personRepository.save(person1);
        personRepository.save(person2);
        person1.removeAddress(address1);
//        logger.info(person1.toString());
//        logger.info(person2.toString());

    }
}

