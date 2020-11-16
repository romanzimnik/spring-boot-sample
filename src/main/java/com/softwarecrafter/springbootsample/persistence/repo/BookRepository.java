package com.softwarecrafter.springbootsample.persistence.repo;

import com.softwarecrafter.springbootsample.persistence.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, Long> {
    List<Book> findByTitle(String title);
}
