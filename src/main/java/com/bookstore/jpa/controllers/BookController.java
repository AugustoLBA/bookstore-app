package com.bookstore.jpa.controllers;

import com.bookstore.jpa.dtos.BookRecordDTO;
import com.bookstore.jpa.models.BookModel;
import com.bookstore.jpa.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookstore/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @PostMapping
    public ResponseEntity<BookModel> saveBook(@RequestBody @Valid BookRecordDTO recordDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.saveBook(recordDTO));
    }
}
