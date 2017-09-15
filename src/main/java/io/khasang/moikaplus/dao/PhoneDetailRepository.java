package io.khasang.moikaplus.dao;

import io.khasang.moikaplus.entity.Phone;
import io.khasang.moikaplus.entity.PhoneDetails;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource()
public interface PhoneDetailRepository extends PagingAndSortingRepository<PhoneDetails, Long> {
}