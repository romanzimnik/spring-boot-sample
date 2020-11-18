package com.softwarecrafter.springbootsample.web;

import com.softwarecrafter.springbootsample.persistence.model.Book;
import com.softwarecrafter.springbootsample.persistence.repo.BookRepository;
import com.softwarecrafter.springbootsample.web.exception.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public Iterable findAll() {
        return bookRepository.findAll();
    }

//    @GetMapping("/{title}")
//    public List findByTitle(@PathVariable String title) {
//        return bookRepository.findByTitle(title);
//    }

    @GetMapping("/{id}")
    public Book findOne(@PathVariable(value = "id") Long id) {
        return bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        System.out.println("OVER HERE!");
        bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
        bookRepository.deleteById(id);
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

