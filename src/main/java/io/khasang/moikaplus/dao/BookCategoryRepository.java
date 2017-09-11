package io.khasang.moikaplus.dao;


import io.khasang.moikaplus.entity.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCategoryRepository extends PagingAndSortingRepository<BookCategory, Integer> {
}
