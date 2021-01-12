package com.softwarecrafter.springbootsample.persistence.model;

import com.softwarecrafter.springbootsample.middleware.dto.TodoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

public class TodoMapper {

    public static List<TodoDTO> mapEntitiesIntoDtos(List<Todo> entities) {
        List<TodoDTO> dtos = new ArrayList<>();

        entities.forEach(e -> dtos.add(mapEntityIntoDto(e)));

        return dtos;
    }

    public static TodoDTO mapEntityIntoDto(Todo entity) {
        TodoDTO dto = new TodoDTO();

        dto.setCreatedByUser(entity.getCreator());
        dto.setCreationTime(entity.getCreationTime());
        dto.setDescription(entity.getDescription());
        dto.setId(entity.getId());
        dto.setModifiedByUser(entity.getModifier());
        dto.setModificationTime(entity.getModificationTime());
        dto.setTitle(entity.getTitle());

        return dto;
    }

    static Page<TodoDTO> mapEntityPageIntoDtoPage(Pageable pageRequest, Page<Todo> source) {
        List<TodoDTO> dtos = mapEntitiesIntoDtos(source.getContent());
        return new PageImpl<>(dtos, pageRequest, source.getTotalElements());
    }

    public static Todo mapDtoToEntity(TodoDTO todoDTO) {
        return Todo.getBuilder()
                .description(todoDTO.getDescription())
                .title(todoDTO.getTitle())
                .creationTime(todoDTO.getCreationTime())
                .modificationTime(todoDTO.getModificationTime())
                .creator(todoDTO.getCreator())
                .modifier(todoDTO.getModifier())
                .build();
    }
}
