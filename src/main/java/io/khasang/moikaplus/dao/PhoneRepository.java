package io.khasang.moikaplus.dao;

import io.khasang.moikaplus.entity.Person;
import io.khasang.moikaplus.entity.Phone;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource()
public interface PhoneRepository extends PagingAndSortingRepository<Phone, Long> {
}