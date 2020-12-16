package com.softwarecrafter.springbootsample.middleware.services;


import com.softwarecrafter.springbootsample.middleware.dto.TodoDTO;

import java.util.List;

public interface TodoService {

    List<TodoDTO> findAllTodos();

    TodoDTO findById(Long id);

    TodoDTO create(TodoDTO todoDTO);

    TodoDTO delete(Long id);

    TodoDTO update(TodoDTO todoDTO);

}
