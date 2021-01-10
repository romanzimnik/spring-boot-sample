package com.softwarecrafter.springbootsample.middleware.services;

import com.softwarecrafter.springbootsample.middleware.dto.TodoDTO;
import com.softwarecrafter.springbootsample.persistence.model.Todo;
import com.softwarecrafter.springbootsample.persistence.model.TodoMapper;
import com.softwarecrafter.springbootsample.persistence.repository.TodoRepository;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    @Transactional(readOnly = true)
    public TodoDTO findById(ObjectId id) {

        Todo todo = repository.findById(id);

        TodoDTO todoDto = TodoMapper.mapEntityIntoDto(todo);

        return todoDto;
    }

    @Override
    public TodoDTO create(TodoDTO todo) {

        repository.save(TodoMapper.mapDtoToEntity(todo));

        return todo;
    }

    @Override
    public TodoDTO delete(ObjectId id) {
        return null;
    }

    @Override
    public TodoDTO update(TodoDTO todo) {
        return null;
    }
}
