package io.khasang.moikaplus.dao;

import io.khasang.moikaplus.SpringBootWebApplication;
import io.khasang.moikaplus.entity.Person;
import io.khasang.moikaplus.entity.Phone;
import io.khasang.moikaplus.entity.PhoneDetails;
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
public class OneToOneTest {

    @Autowired
    PhoneRepository phoneRepository;
    @Autowired
    PhoneDetailRepository phoneDetailRepository;

    @Test
    @Transactional
    public void OneToOne() throws Exception {
        phoneRepository.deleteAll();
        phoneDetailRepository.deleteAll();

        PhoneDetails  phoneDetails = new PhoneDetails("Provider1","Technology1");
        phoneDetails = phoneDetailRepository.save(phoneDetails);
        Phone phone = new Phone("zzz002",phoneDetails);
        phone = phoneRepository.save(phone);
        phone = phoneRepository.findOne(phone.getId());
        phone.getDetails().getProvider();
    }
}

