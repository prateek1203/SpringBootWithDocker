package com.java.app.controller;

import com.java.app.DTO.BookCategoryDTO;
import com.java.app.custom.annotations.Authorized;
import com.java.app.data.BookCategoryRepository;
import com.java.app.data.BookRepository;
import com.java.app.entity.Book;
import com.java.app.entity.BookCategory;
import com.java.app.exceptions.CategoryNotFoundException;
import com.java.app.mapper.BookCategoryMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

@RestController
public class BookCategoryController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookCategoryController.class);
    //private static final String BASE_URL = "https://http-hunt.thoughtworks-labs.net/challenge";

    private BookCategoryRepository bookCategoryRepository;
    private BookCategoryMapper bookCategoryMapper;
    private BookRepository bookRepository;

    @Autowired
    public BookCategoryController(BookCategoryRepository bookCategoryRepository, BookCategoryMapper bookCategoryMapper, BookRepository bookRepository) {
        this.bookCategoryRepository = bookCategoryRepository;
        this.bookCategoryMapper = bookCategoryMapper;
        this.bookRepository = bookRepository;
    }

    @RequestMapping(value = "/bookscategory/{id}", method = RequestMethod.GET, produces = "application/json")
    ResponseEntity<BookCategoryDTO> employeesPageable(@Valid @PathVariable(name = "id") Integer id) {
        LOGGER.info(String.format("/bookscategory/{%s}", id));
        Optional<BookCategory> category = bookCategoryRepository.findById(id);
        if (category.isPresent()) {
            LOGGER.debug("data present for id:- " + id);
            BookCategoryDTO bookCategoryDTO = bookCategoryMapper.ToBookCategoryDTO(category.get());
            LOGGER.debug("categories" + bookCategoryDTO.toString());
            return ResponseEntity.ok(bookCategoryDTO);
        } else {
            throw new CategoryNotFoundException("Invalid category id : " + id);
        }

    }

   /* @RequestMapping(value = "/bookscategory", method = RequestMethod.GET, produces = "application/json")
    ResponseEntity<Page<BookCategoryDTO>> employeesPageable() {
        LOGGER.info(String.format("/bookscategory"));
        Pageable pageable = PageRequest.of(0, 10, Sort.Direction.DESC, "categoryName");
        Page<BookCategory> category = bookCategoryRepository.findAll(pageable);
        List<BookCategoryDTO> bookCategoryDTOs = bookCategoryMapper.toBookCategoryDTOs(category.getContent());
        Page<BookCategoryDTO> bookCategoryDTOS = new PageImpl<>(bookCategoryDTOs, pageable, bookCategoryDTOs.size());
        return new ResponseEntity<>(bookCategoryDTOS, HttpStatus.OK);
    }*/

    @RequestMapping(value = "/bookscategory", method = RequestMethod.GET, produces = "application/json")
    ResponseEntity<Page<BookCategoryDTO>> createCategory() {
        LOGGER.info("/bookscategory");

        Random random = new Random();
        Optional<BookCategory> bookCategory = bookCategoryRepository.findById(7);
        if (bookCategory.isPresent()) {
            LOGGER.debug("Using existing category");
            Book book = new Book();
            book.setId(random.nextInt(9999));
            book.setAuthor("Prateek" + random.nextInt(9999));
            book.setTitle("Run Docker" + random.nextInt(9999));
            book.setName("Dockrise your application");
            book.setBookCategory(bookCategory.get());
            bookRepository.save(book);
        } else {
            LOGGER.debug("Creating New Book and category");
            BookCategory bookCategory1 = new BookCategory();
            bookCategory1.setId(random.nextInt(9999));
            bookCategory1.setCategoryName("test");
            //bookCategoryRepository.save(bookCategory1);
            Book book = new Book();
            book.setId(random.nextInt(9999));
            book.setName("Docker");
            book.setTitle("Spring boot");
            book.setAuthor("Prateek");
            book.setBookCategory(bookCategory1);
            bookRepository.save(book);
        }


        List<String> stringList = new CopyOnWriteArrayList<>();
        Pageable pageable = PageRequest.of(0, 10, Sort.Direction.DESC, "categoryName");
        Page<BookCategory> category = bookCategoryRepository.findAll(pageable);
        List<BookCategoryDTO> bookCategoryDTOs = bookCategoryMapper.toBookCategoryDTOs(category.getContent());
        Page<BookCategoryDTO> bookCategoryDTOS = new PageImpl<>(bookCategoryDTOs, pageable, bookCategoryDTOs.size());
        return new ResponseEntity<>(bookCategoryDTOS, HttpStatus.OK);

    }
}
