package io.khasang.moikaplus.dao;

import io.khasang.moikaplus.entity.City;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource()
public interface CityRepository extends PagingAndSortingRepository<City, Long> {

    // @RestResource(path = "names") http://localhost:8080/people/search/names
    List<City> findByName(@Param("name")  String name);
}