package com.softwarecrafter.springbootsample.web.controller;


import com.softwarecrafter.springbootsample.middleware.dto.TodoDTO;
import com.softwarecrafter.springbootsample.middleware.services.TodoService;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author roman (romanzimnik) from software-crafter.com
 */
@RestController
@RequestMapping("/api/todo")
public class TodoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TodoController.class);

    private final TodoService service;

    @Autowired
    public TodoController(TodoService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TodoDTO> findAllTodos() {
        return service.findAllTodos();
    }

    @GetMapping("/{id}")
    public TodoDTO findById(@PathVariable ObjectId id) {
        return service.findById(id);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public TodoDTO create(@RequestBody @Valid TodoDTO todo) {
        return service.create(todo);
    }

    public TodoDTO delete(ObjectId id) {
        return null;
    }

    public TodoDTO update(TodoDTO todo) {
        return null;
    }
}
