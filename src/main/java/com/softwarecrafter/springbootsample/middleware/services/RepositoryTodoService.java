package com.softwarecrafter.springbootsample.middleware.services;

import com.softwarecrafter.springbootsample.persistence.repository.TodoRepository;
import com.softwarecrafter.springbootsample.middleware.dto.TodoDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RepositoryTodoService implements TodoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RepositoryTodoService.class);

    private TodoRepository repository;

    @Autowired
    RepositoryTodoService(TodoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TodoDTO> findAllTodos() {
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
