package com.softwarecrafter.springbootsample.web.controller;


import com.softwarecrafter.springbootsample.middleware.dto.TodoDTO;
import com.softwarecrafter.springbootsample.middleware.services.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController implements TodoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TodoController.class);

    private final TodoService service;

    @Autowired
    public TodoController(TodoService service) {
        this.service = service;
    }

    @Override
    public Iterable<TodoDTO> findAllTodos() {
        return null;
    }

    @Override
    public TodoDTO findById(Long id) {
        return null;
    }

    @Override
    public TodoDTO create(TodoDTO todoDTO) {
        return null;
    }

    @Override
    public TodoDTO delete(Long id) {
        return null;
    }

    @Override
    public TodoDTO update(TodoDTO todoDTO) {
        return null;
    }
}
