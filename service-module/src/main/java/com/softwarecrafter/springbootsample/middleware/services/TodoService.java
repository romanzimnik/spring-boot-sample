package com.softwarecrafter.springbootsample.middleware.services;


import com.softwarecrafter.springbootsample.middleware.dto.TodoDTO;
import org.bson.types.ObjectId;

import java.util.List;

/**
 * @author roman (romanzimnik) from software-crafter.com
 */
public interface TodoService {

    List<TodoDTO> findAllTodos();

    TodoDTO findById(ObjectId id);

    TodoDTO create(TodoDTO todoDTO);

    TodoDTO delete(ObjectId id);

    TodoDTO update(TodoDTO todoDTO);

}
