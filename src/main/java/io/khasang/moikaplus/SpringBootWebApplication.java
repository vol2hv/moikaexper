package io.khasang.moikaplus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootApplication
public class SpringBootWebApplication {
//    private static final Logger logger = LoggerFactory.getLogger(SpringBootWebApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebApplication.class, args);
//        logger.trace("This is a trace message");
//        logger.debug("This is a debug message");
//        logger.info("This is an info message");
//        logger.warn("This is a warn message");
//        logger.error("This is an error message");
    }
}

