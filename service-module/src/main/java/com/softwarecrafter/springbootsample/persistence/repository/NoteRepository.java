package com.softwarecrafter.springbootsample.persistence.repository;

import com.softwarecrafter.springbootsample.persistence.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;


/**
 * @author roman (rzett) from software-crafter.com
 */
public interface NoteRepository extends MongoRepository<Note, Long> {
}
