package io.khasang.moikaplus.dao;

import io.khasang.moikaplus.SpringBootWebApplication;
import io.khasang.moikaplus.entity.City;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

//@RunWith(SpringJUnit4ClassRunner.class)
//@Ignore

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootWebApplication.class)
@Transactional
@Rollback
public class CityRepositoryTest {
    @Autowired
    CityRepository repository;
    City city;
    List<City> cityList;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findByName() throws Exception {
        city = new City();
        List<City> cityList = new ArrayList<>();
//        city= repository.findOne(1);


        repository.deleteAll();
        city = new City(0L,"g1","r1");
        repository.save(city);
        Long id = city.getId();
        city = new City(0L,"g2","r1");
        repository.save(city);
        city.setName("g2+");
        repository.save(city);
        city= repository.findOne(id);
        repository.findAll().forEach(cityList::add);
        cityList = repository.findByName("g2+");
    }

}