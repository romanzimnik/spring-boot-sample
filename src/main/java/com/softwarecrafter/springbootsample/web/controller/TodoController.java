package com.softwarecrafter.springbootsample.web.controller;

import com.softwarecrafter.springbootsample.web.dto.TodoDTO;
import com.softwarecrafter.springbootsample.web.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoController implements TodoService {

    private final TodoService service;

    @Autowired
    public TodoController(TodoService service) {
        this.service = service;
    }

    @Override
    public List<TodoDTO> findAllTodos() {
        return null;
    }

    @Override
    public TodoDTO findById(Long id) {
        return null;
    }
}
