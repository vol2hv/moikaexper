package io.khasang.moikaplus.exper;

import io.khasang.moikaplus.SpringBootWebApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootWebApplication.class)
//@Transactional
//@Rollback
public class EntityManagerAccessTest {
    @Autowired
    private EntityManagerAccess managerAccess;
    @Test
    public void proba() throws Exception {
        managerAccess.proba();
    }
}