package com.softwarecrafter.springbootsample.middleware.services;

import com.softwarecrafter.springbootsample.middleware.dto.TodoDTO;
import com.softwarecrafter.springbootsample.persistence.model.Todo;
import com.softwarecrafter.springbootsample.persistence.model.TodoMapper;
import com.softwarecrafter.springbootsample.persistence.repository.TodoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RepositoryTodoService implements TodoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RepositoryTodoService.class);

    private TodoRepository repository;

    @Autowired
    RepositoryTodoService(TodoRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<TodoDTO> findAllTodos() {

        List<Todo> todos = repository.findAll();

        return TodoMapper.mapEntitiesIntoDtos(todos);
    }

    @Override
    public TodoDTO findById(Long id) {
        return null;
    }

    @Override
    public TodoDTO create(TodoDTO todo) {

        repository.save(TodoMapper.mapDtoToEntity(todo));

        return todo;
    }

    @Override
    public TodoDTO delete(Long id) {
        return null;
    }

    @Override
    public TodoDTO update(TodoDTO todo) {
        return null;
    }
}
