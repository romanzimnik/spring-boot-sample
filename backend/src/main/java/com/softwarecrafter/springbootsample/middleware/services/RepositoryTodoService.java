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

        Todo todo = repository.findById(id);

        return TodoMapper.mapEntityIntoDto(todo);
    }

    @Override
    @Transactional
    public TodoDTO create(TodoDTO dto) {

        Todo todo = repository.save(TodoMapper.mapDtoToEntity(dto));

        return TodoMapper.mapEntityIntoDto(todo);
    }

    @Override
    public TodoDTO delete(ObjectId id) {
        Todo todo = repository.findById(id);
        repository.delete(todo);
        return TodoMapper.mapEntityIntoDto(todo);
    }

    @Override
    @Transactional
    public TodoDTO update(TodoDTO dto) {

        Todo todo = repository.save(TodoMapper.mapDtoToEntity(dto));

        return TodoMapper.mapEntityIntoDto(todo);
    }
}
