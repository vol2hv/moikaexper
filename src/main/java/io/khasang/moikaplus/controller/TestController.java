package io.khasang.moikaplus.controller;

import io.khasang.moikaplus.dao.CityRepository;
import io.khasang.moikaplus.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/app/test")
public class TestController {
    @Autowired
    private CityRepository repository;

    @RequestMapping
    public City res (){
        return repository.findOne(3l);
    }
    @RequestMapping("/all")
    public List<City> cityList(){
        List<City> cityList = new ArrayList<>();
        repository.findAll().forEach(cityList::add);
        return cityList;
    }

}
