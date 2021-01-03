package com.softwarecrafter.springbootsample.middleware.services;


import com.softwarecrafter.springbootsample.middleware.dto.TodoDTO;

public interface TodoService {

    Iterable<TodoDTO> findAllTodos();

    TodoDTO findById(Long id);

    TodoDTO create(TodoDTO todoDTO);

    TodoDTO delete(Long id);

    TodoDTO update(TodoDTO todoDTO);

}
