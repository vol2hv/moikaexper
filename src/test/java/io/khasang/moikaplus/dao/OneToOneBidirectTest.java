package io.khasang.moikaplus.dao;

import io.khasang.moikaplus.SpringBootWebApplication;
import io.khasang.moikaplus.entity.Phone;
import io.khasang.moikaplus.entity.PhoneDetails;
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
public class OneToOneBidirectTest {

    @Autowired
    PhoneRepository phoneRepository;
    @Autowired
    PhoneDetailRepository phoneDetailRepository;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void OneToOne() throws Exception {
        Phone phone = new Phone( "123-456-7890" );
        PhoneDetails details = new PhoneDetails( "T-Mobile", "GSM" );

        phone.addDetails( details );
        phone = phoneRepository.save(phone);
        phone = phoneRepository.findOne(phone.getId());
        logger.info(phone.toString());

    }
}

