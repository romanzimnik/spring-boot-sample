package com.softwarecrafter.springbootsample.web;

import com.softwarecrafter.springbootsample.persistence.model.Book;
import com.softwarecrafter.springbootsample.persistence.repo.BookRepository;
import com.softwarecrafter.springbootsample.web.exception.BookIdMismatchException;
import com.softwarecrafter.springbootsample.web.exception.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public Iterable findAll() {
        return bookRepository.findAll();
    }

    @GetMapping("/title/{bookTitle}")
    public List findByTitle(@PathVariable String bookTitle) {
        return bookRepository.findByTitle(bookTitle);
    }

    @GetMapping("/{id}")
    public Book findOne(@PathVariable Long id) {
        return bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @DeleteMapping("/{title}")
    public void deleteByTitle(@PathVariable Long title) {
        bookRepository.findById(title)
                .orElseThrow(BookNotFoundException::new);
        bookRepository.deleteById(title);
    }

//    @PutMapping("/{id}")
//    public Book updateBook(@RequestBody Book book, @PathVariable Long id) {
//        if (book.getId() != id) {
//            throw new BookIdMismatchException();
//        }
//        bookRepository.findById(id)
//                .orElseThrow(BookNotFoundException::new);
//        return bookRepository.save(book);
//    }
}

