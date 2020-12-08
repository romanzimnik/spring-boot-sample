package com.softwarecrafter.springbootsample.web.services;

import com.softwarecrafter.springbootsample.persistence.model.Todo;
import com.softwarecrafter.springbootsample.web.dto.TodoDTO;

import java.util.List;

public interface TodoService {

    List<TodoDTO> findAllTodos();

    TodoDTO findById(Long id);

}
