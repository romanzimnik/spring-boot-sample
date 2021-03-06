package com.softwarecrafter.springbootsample.persistence.repository;

import com.softwarecrafter.springbootsample.persistence.model.Todo;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoRepository extends MongoRepository<Todo, Long> {
    Todo findById(ObjectId id);
}
