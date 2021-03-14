package com.softwarecrafter.springbootsample.persistence.repository;

import com.softwarecrafter.springbootsample.persistence.model.Note;
import com.softwarecrafter.springbootsample.persistence.model.Todo;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


/**
 * @author roman (rzett) from software-crafter.com
 */
public interface NoteRepository extends MongoRepository<Note, Long> {
    Note findById(ObjectId id);
}
