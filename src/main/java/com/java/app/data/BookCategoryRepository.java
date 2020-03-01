package com.java.app.data;

import com.java.app.entity.BookCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCategoryRepository extends PagingAndSortingRepository<BookCategory, Integer> {
    Page<BookCategory> findAll(Pageable pageable);
}
