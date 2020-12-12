package com.softwarecrafter.springbootsample.web.services;

import com.softwarecrafter.springbootsample.persistence.repository.TodoRepositiory;
import com.softwarecrafter.springbootsample.web.dto.TodoDTO;

import javax.annotation.Resource;
import java.util.List;

public class RepositoryTodoService implements TodoService {

    @Resource
    private TodoRepositiory repository;

    @Override
    public List<TodoDTO> findAllTodos() {
        return null;
    }

    @Override
    public TodoDTO findById(Long id) {
        return null;
    }
}
