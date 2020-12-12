package com.softwarecrafter.springbootsample.persistence.repository;

import com.softwarecrafter.springbootsample.persistence.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;


/**
 * @author roman (rzett) from software-crafter.com
 */
public interface BookRepository extends MongoRepository<Book, Long> {
}
