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

        Todo t = repository.findById(id);

        TodoDTO todoDto = TodoMapper.mapEntityIntoDto(t);

        return todoDto;
    }

    @Override
    @Transactional
    public TodoDTO create(TodoDTO todo) {

        Todo t = repository.save(TodoMapper.mapDtoToEntity(todo));

        return TodoMapper.mapEntityIntoDto(t);
    }

    @Override
    public TodoDTO delete(ObjectId id) {
        Todo t = repository.findById(id);
        repository.delete(t);

        return TodoMapper.mapEntityIntoDto(t);
    }

    @Override
    @Transactional
    public TodoDTO update(TodoDTO todo) {

        Todo t = repository.save(TodoMapper.mapDtoToEntity(todo));

        return TodoMapper.mapEntityIntoDto(t);
    }
}
