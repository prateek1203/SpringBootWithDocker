package com.java.app.mapper;

import com.java.app.DTO.BookCategoryDTO;
import com.java.app.DTO.BookDTO;
import com.java.app.entity.Book;
import com.java.app.entity.BookCategory;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
@Component
public interface BookCategoryMapper {
    @Mapping(target = "name", source = "bookCategory.categoryName")
    BookCategoryDTO ToBookCategoryDTO(BookCategory bookCategory);

    @Mappings({
            @Mapping(target = "authorName", source = "book.author"),
            @Mapping(target = "bookTitle", source = "book.title")
    })
    BookDTO toBookDTO(Book book);

    List<BookCategoryDTO> toBookCategoryDTOs(List<BookCategory> bookCategories);

    List<BookDTO> toBookDTOs(List<Book> books);

}
