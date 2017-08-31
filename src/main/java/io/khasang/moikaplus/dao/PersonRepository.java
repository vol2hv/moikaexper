package io.khasang.moikaplus.dao;

import io.khasang.moikaplus.entity.City;
import io.khasang.moikaplus.entity.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource()
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {
}