package com.java.app.mapper;

import com.java.app.DTO.BookDTO;
import com.java.app.entity.Book;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
@Component
public interface BookMapper {
    @Mappings({
            @Mapping(target = "authorName", source = "book.author"),
            @Mapping(target = "bookTitle", source = "book.title")
    })
    BookDTO ToBookDTO(Book book);

    List<BookDTO> toBookDTOs(List<Book> books);
}
