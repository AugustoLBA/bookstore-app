package com.bookstore.jpa.service;

import com.bookstore.jpa.dtos.BookRecordDTO;
import com.bookstore.jpa.models.BookModel;
import com.bookstore.jpa.models.ReviewModel;
import com.bookstore.jpa.repositories.AuthorRepository;
import com.bookstore.jpa.repositories.BookRepository;
import com.bookstore.jpa.repositories.PublisherRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }
    @Transactional
    public BookModel saveBook(BookRecordDTO recordDTO){
        BookModel book = new BookModel();

        book.setTitle(recordDTO.title());
        book.setPublisher(publisherRepository.findById(recordDTO.publisherId()).get());
        book.setAuthors(authorRepository.findAllById(recordDTO.authorsIds()).stream().collect(Collectors.toSet()));

        ReviewModel review = new ReviewModel();

        review.setBook(book);
        review.setComment(recordDTO.reviewComment());
        book.setReview(review);
        return bookRepository.save(book);
    }
}
