package com.softwarecrafter.springbootsample.persistence.repo;

import com.softwarecrafter.springbootsample.persistence.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, Long> {
}
