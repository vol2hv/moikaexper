package io.khasang.moikaplus.dao;

import io.khasang.moikaplus.entity.Address;
import io.khasang.moikaplus.entity.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource()
public interface AddressRepository extends PagingAndSortingRepository<Address, Long> {
}